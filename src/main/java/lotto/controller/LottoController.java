package lotto.controller;

import lotto.domain.*;
import lotto.message.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.stream.IntStream;

public class LottoController {
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private Amount amount;
    private Buyer buyer;
    private WinningLotto winningLotto;

    public void play() {
        buyLotto();
        setWinningLotto();
        resultLotto();
    }

    private void buyLotto() {
        setAmount();
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

    private void setAmount() {
        while (true) {
            try {
                this.amount = new Amount(getPurchaseAmount());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private double getPurchaseAmount() {
        return InputView.getPurchaseAmount();
    }

    private void setWinningLotto() {
        Lotto winningLotto = InputView.getWinningLotto();
        BonusNumber bonusNumber = getBonusNumberAndContainsCheck(winningLotto);
        this.winningLotto = new WinningLotto(winningLotto, bonusNumber);
    }

    private BonusNumber getBonusNumberAndContainsCheck(Lotto winningLotto) {
        BonusNumber bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.getBonusNumber();
                if (bonusNumber.contains(winningLotto)) {
                    throw new IllegalArgumentException(ErrorMessage.START.getValue() + ErrorMessage.BONUS_DUPLICATE.getValue());
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void resultLotto() {
        OutputView.winningResult(this.buyer, this.winningLotto);
    }
}
