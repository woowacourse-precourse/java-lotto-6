package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoSeller;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private LottoSeller lottoSeller;
    private List<Lotto> userLottos;
    private int userAmount;
    private int countOfLottos;

    public void init() {
        lottoSeller = new LottoSeller();
        userLottos = new ArrayList<>();
        userAmount = 0;
        countOfLottos = 0;
    }

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        inputAmount();
        giveUserLottos();
        requestPrintPurchasedLottos();
    }

    private void inputAmount() {
        String userInput = InputViewer.requestAmountInput();
        userAmount = lottoSeller.getAmount(userInput);
    }

    private void giveUserLottos() {
        countOfLottos = userAmount / LOTTO_PRICE;
        userLottos = lottoSeller.giveLotto();
    }

    private void requestPrintPurchasedLottos() {
        OutputViewer.printPurchasedCountOfLottos(countOfLottos);
        for (Lotto lotto : userLottos) {
            OutputViewer.printPurchasedLotto(lotto);
        }
    }
}
