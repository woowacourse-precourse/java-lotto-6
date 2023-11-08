package lotto.domain;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private List<Lotto> lottos;
    private List<Integer> winningLotto;

    private int purchasePrice;
    private int purchaseAmount;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public LottoGame() {

    }

    public LottoGame(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setPurchaseAmount() {
        this.purchaseAmount = purchasePrice / 1000;
    }

    public void init() {
        this.purchasePrice = inputView.inputPurchasePrice();
        setPurchaseAmount();
        outputView.printPurchaseAmount(purchaseAmount);
    }

    public void setWinningLotto(int count) {
        this.winningLotto = inputView.inputWinningNumbers(count);
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }
}
