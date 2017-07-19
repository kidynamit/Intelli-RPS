import java.io.*;
public class Play
{
    private static String playerHistory;
    private static String computerHistory;
	private static PredictionEngine engine;
	public static void input_main(String[] args) throws InterruptedException{
		System.out.println("First msg");
		System.out.println("Second msg");
		System.out.println("x");
	}
	public static void main(String[] args) {
		try {
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            engine = new PredictionEngine();
            String text = bufferReader.readLine();
            String[] tokens = text.split("\\s");
            playerHistory = tokens[0];
            computerHistory = tokens[1];
            char compMove = engine.determineOptimalMove(playerHistory, computerHistory);
            String playerMove = tokens[2];
            char winner = engine.determineWinner(playerMove.charAt(0), compMove);
            System.out.print(compMove + " " + winner );
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
