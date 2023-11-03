package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreChecker;
import lotto.domain.LottoSeller;
import lotto.userInterface.InputViewer;
import lotto.userInterface.OutputViewer;
import lotto.utils.StringChanger;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private LottoSeller lottoSeller;
    private LottoScoreChecker lottoScoreChecker;
    private List<Lotto> userLottos;
    private int userAmount;
    private int countOfLottos;

    public void init() {
        lottoSeller = new LottoSeller();
        userLottos = new ArrayList<>();
        lottoScoreChecker = new LottoScoreChecker();
        userAmount = 0;
        countOfLottos = 0;
    }

    public void run() {
        purchaseLotto();
        getWinningNumbers();
    }

    private void purchaseLotto() {
        inputAmount();
        giveUserLottos();
        requestPrintPurchasedLottos();
    }

    private void getWinningNumbers() {
        String userInput = InputViewer.requestWinningNumberInput();
        List<String> inputNumbers = StringChanger.stringToTrimmedStringList(userInput);
        lottoScoreChecker.setWinningLotto(inputNumbers);
    }

    private void inputAmount() {
        String userInput = InputViewer.requestAmountInput();
        userInput = StringChanger.trimString(userInput);
        userAmount = lottoSeller.getAmount(userInput);
    }

    private void giveUserLottos() {
        countOfLottos = userAmount / LOTTO_PRICE;
        userLottos = lottoSeller.giveLotto();
    }

    private void requestPrintPurchasedLottos() {
        OutputViewer.printCountOfPurchaseLottos(countOfLottos);
        for (Lotto lotto : userLottos) {
            OutputViewer.printPurchasedLotto(lotto);
        }
    }
}
