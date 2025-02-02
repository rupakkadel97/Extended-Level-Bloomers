import java.io.*;
public class Simulator {
	private String mPath;
	private String mFileName;
	private double loss, target;
	private tradeArray mTrades;
	
	//constructor
	public Simulator(String p, String name, double l, double t){
		mPath = p;//first tme mPath = "C:\\ProfOmar286_18\\Data\\"
		mFileName = name;//first mFileName = "stocks.txt"
		loss = l;//First loss = 0.01
		target = t; //first target = 0.01
		mTrades = new tradeArray(4000); //create an array of trades empty
	}
	
	public tradeArray getTrades() {
		return mTrades;
	}
	public void run() {
		//open the file for symbols //first time we open stocks.txt
		String fileName = mPath+mFileName;
		//create the file name 
		File myfile = new File(fileName);
		 if (!myfile.exists()) {
			 System.out.println("file does not exist " + fileName);
			 System.exit(1);
		 }
		try{ 
			FileReader fr = new FileReader(fileName);
			//open the file FileReader->BufferedReader
			BufferedReader br = new BufferedReader(fr);
			String Symbol;
			//go through the file symbol by symbol
			while((Symbol = br.readLine())!= null) {
				//create a symbolTester for the symbol
				//first symbol to be read is "BAC"
				symbolTester tester = new symbolTester(Symbol, mPath, loss, target);
				//First time this is called 
				//symbolTester tester = new symbolTester("BAC", "C:\\ProfOmar286_18\\Data\\", 0.01, 0.01);
				//test
				if (tester.test()) {
					//add the trades to the mTrades array
					mTrades.addArray(tester.getTrades());
				}else {
					System.out.println("Error testing  " +  Symbol);
				}
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}