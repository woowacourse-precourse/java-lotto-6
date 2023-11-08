package lotto;

import lotto.domain.LottoComputer;
import lotto.domain.LottoPlayer;

public class Application {
        public static String money;
        public static int ticketNumber;
    public static void main(String[] args) {
        LottoPlayer.buyLotto();
        LottoComputer.makingLottoIndex();
    }
}
