package lotto.controller;

import static lotto.constants.MarksAndConstants.ONE_HUNDRED;
import static lotto.constants.MarksAndConstants.SINGLE_LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNum;
import lotto.model.BuyingCost;
import lotto.model.Comparing;
import lotto.model.Lotto;
import lotto.constants.LottoRanks;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int totalCost = getValidBuyingCost();
        List<List<Integer>> purchased = purchaseLotto(totalCost);
        Lotto winningNum = getValidWinningNum();
        int bonusNum = getValidBonusNum(winningNum);
        inputView.finishInput();

        Map<LottoRanks, Integer> lottoResult = compareLotto(purchased, winningNum, bonusNum);
        double returnRate = getReturnRate(lottoResult, totalCost);
        outputView.printTotalResult(lottoResult, returnRate);
    }

    private int getValidBuyingCost() {
        BuyingCost buyingCost = new BuyingCost();
        int validCost;
        while (true) {
            try {
                validCost = buyingCost.getCost(inputView.inputBuyingCost());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return validCost;
    }

    private Lotto getValidWinningNum() {
        WinningNumbers winningNum = new WinningNumbers();
        Lotto result;
        while (true) {
            try {
                result = winningNum.getLotto(inputView.inputWinnerNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNum.clearList();
            }
        }
        outputView.makeCompartment();
        return result;
    }

    private int getValidBonusNum(Lotto lotto) {
        BonusNum bonusNum = new BonusNum();
        int validBonusNum;
        while (true) {
            try {
                validBonusNum = bonusNum.getBonusNum(inputView.inputBonusNumber(), lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return validBonusNum;
    }

    private List<List<Integer>> purchaseLotto(int totalPrice) {
        List<List<Integer>> purchased = Lotto.getManyLotto(totalPrice / SINGLE_LOTTO_PRICE);
        outputView.printQuantityAndAllPurchasedLotto(purchased.size(), purchased);
        return purchased;
    }

    private Map<LottoRanks, Integer> compareLotto(List<List<Integer>> purchased, Lotto winningNum, int bonusNum) {
        Comparing nextPhase = new Comparing(winningNum, bonusNum);
        return nextPhase.getResult(purchased);
    }

    public Double getReturnRate(Map<LottoRanks, Integer> enumMap, int cost) {
        long totalSum = 0;
        for (LottoRanks key : enumMap.keySet()) {
            totalSum += (long) key.getWinnings() * enumMap.get(key);
        }
        return (double) (totalSum * ONE_HUNDRED) / cost;
    }
}
