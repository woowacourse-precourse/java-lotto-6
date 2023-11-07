package lotto.domain;

import java.util.List;
import java.util.Objects;
import lotto.config.LottoConfig;
import lotto.exception.InvalidBonusNumberException;

public class LottoGame {

    private final UserInterface userInterface;
    private final LottoMachine lottoMachine;

    private LottoGame(UserInterface userInterface, LottoMachine lottoMachine) {
        this.userInterface = userInterface;
        this.lottoMachine = lottoMachine;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void play() {
        int purchasePrice = getValidPurchasePrice();
        List<Lotto> lottos = generateLottosByPurchasePrice(purchasePrice);
        showPurchasedLottos(lottos);

        WinningLotto winningLotto = getWinningLottoWithBonusNumber();
        LottoWinningResult lottoWinningResult = createWinningResultByPurchasedAndWinningLotto(lottos, winningLotto);
        showLottoWinningResult(lottoWinningResult);
    }

    private static LottoWinningResult createWinningResultByPurchasedAndWinningLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        return LottoWinningResult.of(lottos, winningLotto);
    }

    private int getValidPurchasePrice() {
        return userInterface.getValidPurchasePrice();
    }

    private List<Lotto> generateLottosByPurchasePrice(int purchasePrice) {
        int lottoCount = purchasePrice / LottoConfig.PURCHASE_PRICE_UNIT;
        return lottoMachine.generateLottos(lottoCount);
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

    private void showPurchasedLottos(List<Lotto> lottos) {
        LottoResult lottoResult = LottoResult.from(lottos);
        userInterface.printPurchasedResult(lottos.size(), lottoResult);
    }

    private void showLottoWinningResult(LottoWinningResult lottoWinningResult) {
        userInterface.printWinningResult(lottoWinningResult);
    }

    public static class Builder {

        private UserInterface userInterface;
        private LottoMachine lottoMachine;

        public Builder userInterface(UserInterface userInterface) {
            this.userInterface = userInterface;
            return this;
        }

        public Builder lottoMachine(LottoMachine lottoMachine) {
            this.lottoMachine = lottoMachine;
            return this;
        }

        public LottoGame build() {
            if (Objects.isNull(userInterface) || Objects.isNull(lottoMachine)) {
                throw new NullPointerException();
            }
            return new LottoGame(userInterface, lottoMachine);
        }
    }
}
