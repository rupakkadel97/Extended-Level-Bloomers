import java.util.*;
public class Trade {
	private	Direction dir;
	private String symbol;
	private Date entryDate;
	private Date exitDate;
	private double entryPrice;
	private double exitPrice;
	private double target;
	private double stopLoss;
	private boolean on;
	private int holdingPeriod;
	
	public Trade() {
		dir = Direction.NONE;
		symbol = "";
		entryDate = null;
		exitDate = null;
		entryPrice = 0.0;
		exitPrice = 0.0;
		target = 0.0;
		stopLoss = 0.0;
		on = false;
		holdingPeriod = 0;
	}
	public Trade (String sym, Date opDate, double entry, double stop, double tar, Direction d) {
		symbol = sym;
		entryDate = opDate;
		entryPrice = entry;
		stopLoss = stop;
		target = tar;
		dir = d;
		on = true;
		exitPrice = 0.0;
		exitDate = null;
		holdingPeriod = 0;
	}
	//copy constructor 
	public Trade(Trade T) {
		symbol = T.symbol;
		entryDate = T.entryDate;
		entryPrice = T.entryPrice;
		stopLoss = T.stopLoss;
		target = T.target;
		dir = T.dir;
		on = T.on;
		exitPrice = T.exitPrice;
		exitDate = T.exitDate;
		holdingPeriod = T.holdingPeriod;
	}
	public boolean isOn() {
		return on;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getExitDate() {
		return exitDate;
	}
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	public double getEntryPrice() {
		return entryPrice;
	}
	public void setEntryPrice(double entryPrice) {
		this.entryPrice = entryPrice;
	}
	public double getExitPrice() {
		return exitPrice;
	}
	public void setExitPrice(double exitPrice) {
		this.exitPrice = exitPrice;
	}
	public double getTarget() {
		return target;
	}
	public void setTarget(double target) {
		this.target = target;
	}
	public void setHoldingPeriod(int holdingperiod) {
		this.holdingPeriod = holdingperiod; ;
	}
	public double getStopLoss() {
		return stopLoss;
	}
	public int getHoldingPeriod() {
		return this.holdingPeriod;
	}
	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}
	//double PL() returns the profit/loss in dollars
	public double PL() {
		//if long trade proft/loss = exitPrice - entryPrice positive is a win
		//if short trade, profit/loss = entryPrice - exitPrice positive a win
		if (dir == Direction.LONG){
			return (exitPrice - entryPrice);
		} else if (dir == Direction.SHORT){
			return (entryPrice - exitPrice);
		} else {
			System.out.println("We got a problem!!!");
			return 0;
		}
	}
	//double percentPL() returns the Profit/loss in percentage
	//THIS IS THE MOST IMPORTANT 
	public double percentPL() {
		//if long trade proft/loss = exitPrice - entryPrice positive is a win
		//if short trade, profit/loss = entryPrice - exitPrice positive a win
		if (dir == Direction.LONG){
			return (exitPrice - entryPrice)/entryPrice*100;
		} else if (dir == Direction.SHORT){
			return (entryPrice - exitPrice)/entryPrice*100;
		} else {
			System.out.println("We got a problem!!!");
			return 0;
		}
	}	
	//String toString() returns the trades as follows 
	//entrydate, entry price, stoploss, target, direction, exitdate, exitprice, percentPL
	public String toString() {
		String st = entryDate.toString() +", " + entryPrice + ", " + stopLoss + ", " + 
				target + ", " + dir +", " + exitDate.toString() + ", " + exitPrice + ", " +
				this.percentPL();
		return st;
	}
	
	public void open (String sym, Date opDate, double entry, double stop, double tar, Direction d) {
		symbol = sym;
		entryDate = opDate;
		entryPrice = entry;
		stopLoss = stop;
		target = tar;
		dir = d;
		on = true;
	}
	public void close (Date clDate, double exitP) {
		if(on == false) {
			System.out.println("Error, trying to close a closed trade");
			System.exit(1);	
		}
		exitDate = clDate;
		exitPrice = exitP;
		on = false;		
	}
}
	

