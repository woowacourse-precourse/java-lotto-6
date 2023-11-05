package lotto;
import lotto.domain.LottoComputer;
import lotto.domain.LottoPlayer;



public class Application {
	
	public static String money;
	public static int ticketNumber; //추후 수정할 것
    public static void main(String[] args) {
    	
    	LottoPlayer.buyLotto();
        LottoComputer.makingLottoIndex();
        
    	
        
    }
}
