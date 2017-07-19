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
            System.out.print(compMove);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
