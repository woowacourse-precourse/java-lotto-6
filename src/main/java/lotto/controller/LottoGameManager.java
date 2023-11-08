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
    private final List<Lotto> userLottos;
    private final List<Integer> matchCounts = new ArrayList<>(Collections.nCopies(5, 0));
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private BigDecimal profitRate;

    public LottoGameManager(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
        this.userLottos = new ArrayList<>();
    }

    public void play() {
        int lottoCount = determiningTheNumberOfLotto();
        creatingAndCheckingLotto(lottoCount);
        settingWinningNumberAndBonusNumber();
        JudgementOfWinning();
        profitCalculating();
    }

    public int determiningTheNumberOfLotto() {
        priceInputMessage();
        int lottoCount = purchaseLotto();
        InterfaceView.purchaseCheckingMessage(lottoCount);
        return lottoCount;
    }

    public void creatingAndCheckingLotto(int lottoCount) {
        createLotto(lottoCount);
        printLotto(userLottos);
    }

    public void settingWinningNumberAndBonusNumber() {
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
        profitRate = profitCalculator.calculateProfit();
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

    private void checkResult() {

        for (Lotto userLotto : userLottos) {
            WinningRanking prizeRank = userLotto.checkWinning(winningLotto, bonusNumber.getBonusNumber());
            if (prizeRank != WinningRanking.LOSING) {
                matchCounts.set(prizeRank.getRank() - 1, matchCounts.get(prizeRank.getRank() - 1) + 1);
            }
        }
    }

    private void setWinningNumber() {
        String winningNumbersInput = userInputManager.getWinningNumbersInput();
        List<Integer> winningNumbers = Utils.convertStringToIntegers(winningNumbersInput);
        this.winningLotto = new Lotto(winningNumbers);
    }

    public List<Lotto> getUserLottos() {
        return this.userLottos;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return this.bonusNumber;
    }

    public List<Integer> getMatchCounts() {
        return matchCounts;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }
}