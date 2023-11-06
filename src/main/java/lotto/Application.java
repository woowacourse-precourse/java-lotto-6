package lotto;

import java.util.List;
import lotto.config.AppConfig;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningResult;
import lotto.domain.RandomLottoMachine;
import lotto.domain.UserInterface;
import lotto.domain.WinningLotto;
import lotto.exception.InvalidBonusNumberException;

public class Application {

    private final UserInterface userInterface = AppConfig.userInterface();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        int lottoCount = application.calculateLottoPurchaseCount();
        List<Lotto> lottos = application.generateLottos(lottoCount);
        application.printPurchasedLottos(lottos);

        WinningLotto winningLotto = application.getWinningLottoWithBonusNumber();
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottos, winningLotto);
        application.printWinningResult(lottoWinningResult);

    }

    private void printWinningResult(LottoWinningResult lottoWinningResult) {
        userInterface.printWinningResult(lottoWinningResult);
    }

    private WinningLotto getWinningLottoWithBonusNumber() {
        WinningLotto winningLotto = userInterface.getWinningLotto();
        addBonusNumberToWinningNumber(winningLotto);
        return winningLotto;
    }

    private void addBonusNumberToWinningNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                Integer bonusNumber = userInterface.getBonusNumber();
                winningLotto.addBonusNumber(bonusNumber);
                return;
            } catch (InvalidBonusNumberException exception) {
                userInterface.printErrorMessage(exception);
            }
        }
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        LottoResult lottoResult = LottoResult.from(lottos);
        userInterface.printPurchasedResult(lottos.size(), lottoResult);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        LottoMachine lottoMachine = new RandomLottoMachine();
        return lottoMachine.generateLottos(lottoCount);
    }

    private int calculateLottoPurchaseCount() {
        int purchasePrice = userInterface.getValidPurchasePrice();
        return purchasePrice / LottoConfig.PURCHASE_PRICE_UNIT;
    }
}
