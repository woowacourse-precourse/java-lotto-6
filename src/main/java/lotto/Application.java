package lotto;
import lotto.domain.*;



public class Application {
	
	public static String money;
    public static void main(String[] args) {
        LottoPlayer lottoPlayer = new LottoPlayer();
		lottoPlayer.buyLotto();
		lottoPlayer.lottoTicket(money);
    }
}
