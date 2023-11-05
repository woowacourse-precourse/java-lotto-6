package lotto;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoResult;



public class Application {
	
	public static String money;
	public static int ticketNumber; 
	public static List<Integer> playerNumber = new ArrayList<>();
	public static int playerBonusNumber;
    public static void main(String[] args) {
    	
//    	LottoPlayer.buyLotto();
//      LottoComputer.makingLottoIndex();
        
    	LottoResult.resultPrint();
    	        
    }
}
