package lotto;

public enum price {
	First(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), 
    Second(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Third(5, 1_500_000, "5개 일치 (1,500,000원) - "), 
    Fouth(4, 50_000, "4개 일치 (50,000원) - "), 
    Fifth(3, 5_000, "3개 일치 (5,000원) - "), 
    Length(0, 0, "");
	
	private int value;
	private int priceAmount;
	private String printMsg;
	private 
	price(int value, int priceAmount, String printMsg) 
	{
		this.value = value;
		this.priceAmount = priceAmount;
		this.printMsg = printMsg;
	}
	
	public static price getPrice(int cnt, boolean bn)
	{
		if(cnt == 3) {return Fifth;}
		if(cnt == 4) {return Fouth;}
		if(cnt == 5)
		{
			if(bn) {return Second;}
			return Third;
		}
		if(cnt == 6) {return First;} 
		return Length;
	}
	
	public int getValue()
	{
		return value;
	}
	public int getPriceAmount()
	{
		return priceAmount;
	}
	public String printMsg()
	{
		return printMsg;
	}
	public void printMessage(int cnt)
	{
		System.out.println(printMsg + cnt + "개");
	}
}
