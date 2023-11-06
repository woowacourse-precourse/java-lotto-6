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
        int totalCost = getValidBuyingCost(inputView);
        List<List<Integer>> purchased = purchaseLotto(totalCost);

        Lotto winningNum = getValidWinningNum(inputView);
        int bonusNum = getValidBonusNum(inputView, winningNum);
        inputView.finishInput();

        Map<LottoRanks, Integer> lottoResult = compareLotto(purchased, winningNum, bonusNum);
        double returnRate = getReturnRate(lottoResult, totalCost);
        outputView.printTotalResult(lottoResult, returnRate);
    }

    public int getValidBuyingCost(InputView inputView) {
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
    public Lotto getValidWinningNum(InputView inputView) {
        WinningNumbers winningNum = new WinningNumbers();
        Lotto result;
        while (true) {
            try {
                result = winningNum.getLotto(inputView.inputWinnerNumbers());
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNum.clearList();
            }
        }
        return result;
    }
    public int getValidBonusNum(InputView inputview, Lotto lotto) {
        BonusNum bonusNum = new BonusNum();
        int validBonusNum;
        while (true) {
            try {
                validBonusNum = bonusNum.getBonusNum(inputview.inputBonusNumber(), lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return validBonusNum;
    }

    public List<List<Integer>> purchaseLotto(int totalPrice) {
        List<List<Integer>> purchased = Lotto.getManyLotto(totalPrice/SINGLE_LOTTO_PRICE);
        outputView.printQuantityAndAllLottoNumbers(purchased.size(), purchased);
        return purchased;
    }
    public Map<LottoRanks, Integer> compareLotto(List<List<Integer>> purchased, Lotto winningNum, int bonusNum) {
        Comparing nextPhase = new Comparing(winningNum, bonusNum);
        nextPhase.compareAllToWinningNum(purchased);
        return nextPhase.getWinningResult(purchased.size());
    }

    public Double getReturnRate(Map<LottoRanks,Integer> enumMap, int cost) {
        long totalSum = 0;
        for (LottoRanks key : enumMap.keySet()) {
            totalSum += (long) key.getWinnings()*enumMap.get(key);
        }
        return (double)(totalSum*ONE_HUNDRED)/cost;
    }
}
