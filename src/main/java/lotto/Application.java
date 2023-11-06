package lotto;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoComputer;
import lotto.domain.LottoPlayer;
import lotto.object.LottoNumber;


public class Application {
	
	public static String money;
	public static int ticketNumber; 
	public static List<Integer> playerNumber = new ArrayList<>();
	public static int playerBonusNumber;
	public static List<LottoNumber> numbers = new ArrayList<LottoNumber>();
	public static List<Integer> computerNumber = new ArrayList<>();
    public static void main(String[] args) {
    	
    	
    	LottoPlayer.buyLotto();
    	LottoComputer.lottoMaker();
    	LottoComputer.printTicket(LottoComputer.lottoMaker());
    	        
    }
}
