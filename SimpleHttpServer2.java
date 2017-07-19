
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server{

  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(3232), 0);
    server.createContext("/play", new GetHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
    System.out.println("The server is running");
  }

  // http://localhost:8000/info

  static class GetHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
      StringBuilder response = new StringBuilder();
      Map <String,String> params = Server.queryToMap(httpExchange.getRequestURI().getQuery());
      PredictionEngine engine = new PredictionEngine();
      String playerHistory = params.get("user");
      String computerHistory = params.get("computer");
      String playerMove = params.get("move");
      char compMove = engine.determineOptimalMove(playerHistory, computerHistory); 
      char winner = engine.determineWinner(playerMove.charAt(0), compMove);
      response.append( compMove + " " + winner);
      Server.writeResponse(httpExchange, response.toString());
    }
  }

  public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
    httpExchange.sendResponseHeaders(200, response.length());
    OutputStream os = httpExchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }


  /**
   * returns the url parameters in a map
   * @param query
   * @return map
   */
  public static Map<String, String> queryToMap(String query){
    Map<String, String> result = new HashMap<String, String>();
    for (String param : query.split("&")) {
        String pair[] = param.split("=");
        if (pair.length>1) {
            result.put(pair[0], pair[1]);
        }else{
            result.put(pair[0], "");
        }
    }
    return result;
  }

}
