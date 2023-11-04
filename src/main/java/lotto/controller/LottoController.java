package lotto.controller;

import static lotto.constants.MarksAndConstants.ONE_HUNDRED;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNum;
import lotto.model.BuyingCost;
import lotto.model.Matching;
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
        List<List<Integer>> purchasedLotto = Lotto.getManyLotto(totalCost/1000);
        outputView.printQuantityAndAllNumbers(purchasedLotto.size(), purchasedLotto);

        Lotto winningNum = getValidWinningNum(inputView);
        int bonusNum = getValidBonusNum(inputView, winningNum);

        Map<LottoRanks, Integer> lottoResult = matching(purchasedLotto, winningNum, bonusNum);
        outputView.printLottoResult(lottoResult, getReturnRate(lottoResult, totalCost));
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
    public Map<LottoRanks, Integer> matching(List<List<Integer>> purchased, Lotto winningNum, int bonusNum) {
        Matching nextPhase = new Matching(purchased, winningNum);
        nextPhase.compareToWinningNumbers(bonusNum);
        return nextPhase.countLottoWinningResult(purchased.size());
    }

    public Double getReturnRate(Map<LottoRanks,Integer> enumMap, int cost) {
        long totalSum = 0;
        for (LottoRanks key : enumMap.keySet()) {
            totalSum += (long) key.getWinnings()*enumMap.get(key);
        }
        return (double)(totalSum*ONE_HUNDRED)/cost;
    }
}
