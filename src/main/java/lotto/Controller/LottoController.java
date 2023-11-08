package lotto.Controller;

import lotto.View.LottoBuyer;
import lotto.View.WinningLottoGenerator;

public class LottoController {
    public static LottoBuyer lottoBuyer = new LottoBuyer();
    public static WinningLottoGenerator winningLottoGenerator = new WinningLottoGenerator();

    public void buyLotto() {
        lottoBuyer.inputMoney();
        lottoBuyer.generateLottos();
        lottoBuyer.printLottoCount();
        lottoBuyer.printLottos();
    }

}
