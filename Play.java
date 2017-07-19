import java.io.*;
public class Play
{
    private static String playerHistory;
    private static String computerHistory;
	private PredictionEngine engine;
	public static void input_main(String[] args) throws InterruptedException{
		System.out.println("First msg");
		System.out.println("Second msg");
		System.out.println("x");
	}
	public static void main(String[] args) {
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
			String s = bufferRead.readLine();
			while(s.equals("x")==false) {
				writer.println(s);
				s = bufferRead.readLine();
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
    
}
