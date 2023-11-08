package lotto.controller;

import lotto.domain.*;
import lotto.message.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.stream.IntStream;

public class LottoController {
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private Amount amount;
    private Buyer buyer;
    private WinningLotto winningLotto;

    public void play() {
        buyLotto();
        winningLottoSetting();
        resultLotto();
    }

    private void buyLotto() {
        settingAmount();
        this.buyer = new Buyer(getBuyerLottos());
        OutputView.purchaseLottos(buyer);
    }

    private Lottos getBuyerLottos() {
        return new Lottos(IntStream
                .range(0, this.amount.buyCount())
                .mapToObj(i -> new Lotto(lottoNumberGenerator.pickUniqueNumbers()))
                .toList()
        );
    }

    private void settingAmount() {
        while (true) {
            try {
                this.amount = new Amount(getPurchaseAmount());
                return;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private double getPurchaseAmount() {
        return InputView.getPurchaseAmountFromInput();
    }

    private void winningLottoSetting() {
        Lotto winningNumberLotto = getWinningLottoAndCheck();
        BonusNumber bonusNumber = getBonusNumberAndCheck(winningNumberLotto);
        this.winningLotto = new WinningLotto(winningNumberLotto, bonusNumber);
    }

    private Lotto getWinningLottoAndCheck() {
        while (true) {
            try {
                return InputView.getWinningLottoFromInput();
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private BonusNumber getBonusNumberAndCheck(Lotto winningNumberLotto) {
        while (true) {
            try {
                BonusNumber bonusNumber = InputView.getBonusNumberFromInput();
                bonusNumber.containsException(winningNumberLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private void resultLotto() {
        OutputView.winningResult(this.buyer, this.winningLotto);
    }
}
