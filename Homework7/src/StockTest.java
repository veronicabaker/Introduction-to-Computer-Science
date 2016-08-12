
public class StockTest 
{
	public static void main(String[] args)
	{
		//create new stock
		Stock stock = new Stock ("ORCL", "Oracle Corporation");
		//set current price
		stock.setCurrentPrice(34.35);
		//set previous price
		stock.setPreviousClosingPrice(34.5);
		//find percent change and print out
		System.out.printf("The price change percent for " + stock.name + " is: " + "%.2f%%", stock.getChangePercent());
	}
}
