package lotto;

public class Prints 
{
	
	public static final String startMsg = "구입금액을 입력해 주세요.";
	public static final String buyingAmt = "개를 구매했습니다.";
	public static final String winningMsg = "당첨 번호를 입력해 주세요.";
	public static final String bonusMsg = "보너스 번호를 입력해 주세요.";
	
	public static final String ErrMsgNotPurchase = "[ERROR] 잘못된 값을 입력하셨습니다.";
	public static final String ErrMsgOverBound = "[ERROR] 값의 갯수가 잘 못 되었습니다.";
	public static final String ErrMsgOverRange = "[ERROR] 값의 숫자가 범위를 벗어났습니다.";
	public static final String ErrMsgDuplicationRange = "[ERROR] 값이 중복되어서 들어가있습니다.";
	
	public static final String printLotStart = "[";
	public static final String printLotEnd = "]";
	public static final String printLotSpace = ", ";
	public static final void totalStatistics()
	{
		System.out.println("당첨 통계");
		System.out.println("---");
	}
	public static final void printStastics(int buyLot, double totalStastics)
	{
	    System.out.println("총 수익률은 " + String.format("%.1f", totalStastics/buyLot) + "%입니다.");
	}
	
}
