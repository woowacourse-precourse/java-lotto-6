package lotto.controller;

import lotto.Utils;
import lotto.WinningRanking;
import lotto.model.*;
import lotto.view.InterfaceView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.InterfaceView.*;


public class LottoGameManager {

    private final UserInputManager userInputManager;
    private List<Lotto> userLottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public LottoGameManager(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
        this.userLottos = new ArrayList<>();
    }

    public void play() {
        int lottoCount = determiningTheNumberOfLotto();
        createAndCheckLotto(lottoCount);
        setWinningNumberAndBonusNumber();
        JudgementOfWinning();
        profitCalculating();
    }

    public int determiningTheNumberOfLotto() {
        priceInputMessage();
        int lottoCount = purchaseLotto();
        InterfaceView.checkMessage(lottoCount);
        return lottoCount;
    }

    public void createAndCheckLotto(int lottoCount) {
        createLotto(lottoCount);
        printLotto(userLottos);
    }

    public void setWinningNumberAndBonusNumber() {
        winningNumberInputMessage();
        setWinningNumber();
        bonusNumberInputMessage();
        this.bonusNumber = setBonusNumber();
    }

    public void JudgementOfWinning() {
        checkResult();
        printResult(matchCounts);
    }

    public void profitCalculating() {
        ProfitCalculator profitCalculator = new ProfitCalculator(Purchase.getPurchasePrice(), matchCounts);
        BigDecimal profitRate = profitCalculator.calculateProfit();
        printProfitRate(profitRate);
    }

    private int purchaseLotto() {
        String purchasePriceInput = userInputManager.getPurchasePriceInput();
        Purchase purchase = new Purchase(purchasePriceInput);
        return purchase.getLottoCount();
    }

    private BonusNumber setBonusNumber() {
        String bonusNumberInput = userInputManager.getBonusNumberInput();
        return new BonusNumber(bonusNumberInput);
    }

    private void createLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            userLottos.add(Lotto.makeLotto());
        }
    }


    private List<Integer> matchCounts = new ArrayList<>(Collections.nCopies(5, 0));

    private void checkResult() {

        for (Lotto userLotto : userLottos) {
            WinningRanking prizeRank = userLotto.checkWinning(winningLotto, bonusNumber.getBonusNumber());
            if (prizeRank != WinningRanking.LOSING) {
                // 열거형 값을 사용하여 해당 등수의 matchCounts 값을 증가시킵니다.
                matchCounts.set(prizeRank.getRank() - 1, matchCounts.get(prizeRank.getRank() - 1) + 1);
            }
        }
    }

    private void setWinningNumber() {
        String winningNumbersInput = userInputManager.getWinningNumbersInput();
        List<Integer> winningNumbers = Utils.convertStringToIntegers(winningNumbersInput);
        this.winningLotto = new Lotto(winningNumbers);
    }
}