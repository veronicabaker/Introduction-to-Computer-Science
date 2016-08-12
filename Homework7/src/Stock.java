/*
 * Veronica Baker
 * Intro to CS
 */
public class Stock 
{
	//initialize variables
	public String symbol;
	public String name;
	private double previousClosingPrice;
	private double currentPrice;
	
	//constructor 
	public Stock(String newSymbol, String newName)
	{
		symbol = newSymbol;
		name = newName;
	}
	//set current price of stock
	public void setCurrentPrice(double newCurrentPrice)
	{
		currentPrice = newCurrentPrice;
	}
	//set previous price of stock
	public void setPreviousClosingPrice(double newPreviousClosingPrice)
	{
		previousClosingPrice = newPreviousClosingPrice;
	}
	//find out the percent change in prices
	public double getChangePercent()
	{
		return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
	}
}
