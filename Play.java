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
            playerHistory = bufferReader.readLine();
            computerHistory = bufferReader.readLine();
            char compMove = engine.determineOptimalMove(playerHistory, computerHistory);
            String playerMove = bufferReader.readLine();
            char winner = engine.determineWinner(playerMove.charAt(0), compMove);
            System.out.print(compMove + " " + winner );
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
