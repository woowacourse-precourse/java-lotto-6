package lotto;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoComputer;
import lotto.domain.LottoPlayer;
import lotto.domain.LottoResult;
import lotto.object.LottoNumber;


public class Application {
	
	public static int purchaseAmount;
	public static int ticketNumber; 
	public static List<Integer> playerNumber = new ArrayList<>();
	public static int playerBonusNumber;
	public static List<LottoNumber> lottoList = new ArrayList<LottoNumber>();
	public static List<Integer> computerNumber = new ArrayList<>();
    public static void main(String[] args) {
    	
    	
    	LottoPlayer.buyLotto();
    	lottoList = LottoComputer.lottoMaker();
    	LottoComputer.printTicket(lottoList);
    	LottoPlayer.inputNumber();
    	LottoResult.lottoCompare(lottoList);
    	LottoResult.resultPrint();
    }
}
