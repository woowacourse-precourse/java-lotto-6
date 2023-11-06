package lotto.controller;

import lotto.domain.*;
import lotto.message.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
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
        this.buyer = new Buyer(new Lottos(IntStream
                .range(0, this.amount.buyCount())
                .mapToObj(i -> new Lotto(lottoNumberGenerator.pickUniqueNumbers()))
                .toList()
        ));
        OutputView.purchaseLottos(buyer);
    }

    private void setAmount() {
        this.amount = new Amount(getPurchaseAmount());
    }

    private double getPurchaseAmount() {
        return InputView.getPurchaseAmount();
    }

    private void setWinningLotto() {
        Lotto winningLotto = InputView.getWinningLotto();
        BonusNumber bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.getBonusNumber();
                if (bonusNumber.contains(winningLotto)) {
                    throw new IllegalArgumentException(ErrorMessage.START.getValue() + ErrorMessage.BONUS_DUPLICATE.getValue());
                }
                this.winningLotto = new WinningLotto(winningLotto, bonusNumber);
                return;
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
