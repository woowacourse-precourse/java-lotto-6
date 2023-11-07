package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static 
	Prints p = new Prints();
	public static final int lotLength = 6;
    public static void main(String[] args) 
    {
    	run();
    }
    private static void run()
    {
    	startMsg();
    	int buyLot = buyAmount();
    	int amount = buyLot/1000;
    	Lotto[] buyLotsNumbers = new Lotto[amount];
    	System.out.println(amount + p.buyingAmt);
    	for(int i =0; i < amount; i++) buyLotsNumbers[i] = new Lotto();
    	for(int i =0; i < amount; i++) buyLotsNumbers[i].printNumbers();
    	winningNumMsg();
    	Lotto winning = winningNum();
    	int bonusNum = inputBonusNum();
    	printLots(buyLotsNumbers, winning, bonusNum, buyLot);
    }
    
    private static void printLots(Lotto[] lots, Lotto winN, int bonus, int buyLot)
    {
    	Map<price, Integer> m = setResult();
    	for(int i = 0; i < lots.length; i++)
    	{
    		int check = checkPrice(lots[i], winN);
    		boolean bnCheck = checkBonus(lots[i], bonus);
    		price nowP = price.getPrice(check, bnCheck);
    		m.put(nowP, m.get(nowP) + 1);
    	}
    	printLotsValue(m, buyLot);
    }
    private static void printLotsValue(Map<price, Integer> m, int buyLot)
    {
    	p.totalStatistics();
    	double totalP = 0;
    	for (int i = price.values().length - 2; i >= 0; i--) 
    	{
            price.values()[i].printMessage(m.get(price.values()[i]));
            totalP += price.values()[i].getPriceAmount() * m.get(price.values()[i]);
        }
    	p.printStastics(buyLot, totalP);
    }
    
  
    private static  Map<price, Integer> setResult() 
    {
        Map<price, Integer> result = new LinkedHashMap<>();

        for (price p : price.values()) {
            result.put(p, 0);
        }
        return result;
    }
    private static boolean checkBonus(Lotto lot, int bonus)
    {
    	for(int i = 0; i < lotLength; i++ )
    	{
    		if(lot.getLotsNum(i) == bonus) {return true;}
    	}
    	return false;
    }
    private static int checkPrice(Lotto lot, Lotto win)
    {
    	int cnt = 0;
    	for(int i = 0; i < lotLength; i++ )
    	{
    		for(int j = 0; j < lotLength; j++)
    		{
    			if(lot.getLotsNum(i) == win.getLotsNum(j))cnt++;
    		}
    	}
    	return cnt;
    }
    
    private static int inputBonusNum()
    {
    	System.out.println(p.bonusMsg);
    	String bonusS = Console.readLine();
    	return Integer.parseInt(bonusS);
    }
    
    private static int buyAmount()
    {
    	int amount = 0;
    	try{
    		amount = Integer.parseInt(Console.readLine());
    	}catch (NumberFormatException e) {
			System.out.println(p.ErrMsgNotPurchase);
			throw new IllegalArgumentException();
		}
    	return amount;
    }
    private static Lotto winningNum()
    {
    	String winningLine = Console.readLine();
    	String[] num = winningLine.split(",");
    	List<Integer> nums = new ArrayList<Integer>();
    	for(int i = 0; i < num.length; i++)
    	{
    		nums.add(Integer.parseInt(num[i]));
    	}
    	Lotto lot = new Lotto(nums);
    	return lot;
    }
    private static void startMsg()
    {
    	System.out.println(p.startMsg);
    }
    private static void winningNumMsg()
    {
    	System.out.println(p.winningMsg);
    }
}
