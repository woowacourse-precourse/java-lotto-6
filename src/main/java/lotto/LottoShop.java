package lotto;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputMoney;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printLottoList;
import static lotto.view.OutputView.printLottoStatistics;
import static lotto.view.OutputView.println;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoMachine;
import lotto.domain.Statistician;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;

public class LottoShop {
    private static final String INPUT_PURCHASE_AMOUNT_COMMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_COMMENT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_COMMENT = "보너스 번호를 입력해 주세요.";
    private final LottoMachine lottoMachine;
    private final Statistician statistician;

    public LottoShop(LottoMachine lottoMachine, Statistician statistician) {
        this.lottoMachine = lottoMachine;
        this.statistician = statistician;
    }

    public void runLottoGame() {
        LottoAmount lottoAmount = purchaseAmount();
        println();
        List<Lotto> lottoList = buyLotto(lottoAmount);
        println();

        WinningLotto winningLotto = drawWinningLotto();
        WinningStatistics winningStatistics = makeWinningStatistics(lottoAmount, lottoList, winningLotto);
        printLottoStatistics(winningStatistics);
    }

    public LottoAmount purchaseAmount() {
        println(INPUT_PURCHASE_AMOUNT_COMMENT);
        try {
            return new LottoAmount(inputMoney());
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return purchaseAmount();
        }
    }

    public List<Lotto> buyLotto(LottoAmount lottoAmount) {
        List<Lotto> lottoList = lottoMachine.buyLottos(lottoAmount);
        printLottoList(lottoList);
        return lottoList;
    }
    private WinningLotto drawWinningLotto() {
        List<Integer> winningNumbers = drawWinningNumbers();
        println();
        int bonusNumber = drawBonusNumber(winningNumbers);
        println();

        return WinningLotto.of(winningNumbers, bonusNumber);
    }

    private List<Integer> drawWinningNumbers() {
        println(INPUT_WINNING_NUMBERS_COMMENT);
        try {
            return inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return drawWinningNumbers();
        }
    }

    private int drawBonusNumber(List<Integer> winningNumbers) {
        println(INPUT_BONUS_NUMBER_COMMENT);
        try {
            return inputBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return drawBonusNumber(winningNumbers);
        }
    }

    private WinningStatistics makeWinningStatistics(LottoAmount lottoAmount, List<Lotto> lottoList, WinningLotto winningLotto) {
        return statistician.makeLottoStatistics(lottoAmount, lottoList, winningLotto);
    }
}
