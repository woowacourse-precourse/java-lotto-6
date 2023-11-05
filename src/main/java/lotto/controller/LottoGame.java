package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private List<Lotto> lotto = new ArrayList<>();
    private long purchaseAmount;
    private InputView inputView;
    private OutputView outputView;
    private User user;

    public LottoGame(InputView inputView, OutputView outputView, User user) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.user = user;
    }

    public void start() {
        user.setPurchaseAmount(inputView.purchaseAmount());
        purchaseAmount = user.getPurchaseAmount() % 1000;
        outputView.printPurchaseAmount(purchaseAmount);
    }
}
