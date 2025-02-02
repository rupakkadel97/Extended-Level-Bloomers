import java.util.*;
public class tradeArray {
	
	//A vector of trades Vector<Trade> 
	private Vector<Trade> v;
	//default constructor calls default constructor for Vector 
	public tradeArray(){
		v = new Vector<Trade>();
	}
	//Constructor with one integer calls the Vector constructor
	public tradeArray(int s){
		v = new Vector<Trade>(s);
	}
	//constructor with two integers calls also Vector constructor
	public tradeArray(int s, int inc){
		v = new Vector<Trade>(s, inc);
	}
	public int size() {
		return v.size();
	}
	//inset method to call the add method in the Vector 
	public void insert(Trade T) {
		v.add(T);
	}
	//public Trade At(int index) retuning the trade at index index.
	public Trade At(int index) {
		return v.elementAt(index);
	}
	public void addArray(tradeArray input) {
		for (int i =0; i < input.size(); i++) {
			Trade T = new Trade(input.At(i));
			this.insert(T);
		}
	}
	public String toString() {
		String st = "";
		int s = size();
		for (int i = 0; i <s; i++) {
			st += this.At(i).toString() + "\n";
		}
		return st;
	}
	
	//TODO
	//Write a method that will generate Statistics we will use a class Stats
	//this has to return an object Stats
	public Stats getStats() {
		//create a Stats objects 
		Stats st = new Stats();
		//go throu the array (vector) trade per trade and update the info in Stats
		for (int i = 0; i < this.size(); i++){
			st.numberOfTrades++;
			st.numberDays += this.At(i).getHoldingPeriod();
			if(this.At(i).percentPL() >= 0) {
				st.totalWinnings += this.At(i).percentPL();
				st.numberWinners++;
				if(this.At(i).getDir() == Direction.LONG) {
					st.numberLong++;
					st.longWinners++;
					st.totalLongWinnings += this.At(i).percentPL();
					st.numberLongDays += this.At(i).getHoldingPeriod();
					
				}else {
					st.numberShort++;
					st.shortWinners++;
					st.totalShortWinnings += this.At(i).percentPL();
					st.numberShortDays +=  this.At(i).getHoldingPeriod();
				}
			} else {//it is a loser
				st.numberLosers++;
				st.totalLoss += this.At(i).percentPL();
				if(this.At(i).getDir() == Direction.LONG) {
					st.numberLong++;
					st.longLosers++;
					st.totalLongLoss += this.At(i).percentPL();
					st.numberLongDays +=  this.At(i).getHoldingPeriod();
					
				}else {
					st.numberShort++;
					st.shortLosers++;
					st.totalShortLoss += this.At(i).percentPL();
					st.numberShortDays +=  this.At(i).getHoldingPeriod();
				}
			}
		}
		return st;
	}
	
	
}