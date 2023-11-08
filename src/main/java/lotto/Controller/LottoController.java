package lotto.Controller;

import lotto.View.LottoBuyer;
import lotto.View.LottoChecker;
import lotto.View.WinningLottoGenerator;

public class LottoController {
    public static LottoBuyer lottoBuyer = new LottoBuyer();
    public static WinningLottoGenerator winningLottoGenerator = new WinningLottoGenerator();
    public static LottoChecker lottoChecker;

    public void buyLotto() {
        lottoBuyer.inputMoney();
        lottoBuyer.generateLottos();
        lottoBuyer.printLottoCount();
        lottoBuyer.printLottos();
    }

    public void generateWinningLotto() {
        winningLottoGenerator.generateWinningNumbers();
        winningLottoGenerator.generateBonusNumber();
    }

    public void checkWinningResult() {
        lottoChecker = new LottoChecker(lottoBuyer.getBoughtLottos(), winningLottoGenerator.getWinningNumbers());
        lottoChecker.printCheckStart();
        lottoChecker.checkWinning();
    }
}
