package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNum;
import lotto.model.BuyingCost;
import lotto.model.Lotto;
import lotto.model.LottoRanks;
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
        int cost = getValidBuyingCost(inputView);
        int counts = cost/1000;
        List<List<Integer>> manyLotto = Lotto.getManyLotto(counts);
        outputView.printQuantityAndAllNumbers(counts, manyLotto);
        Lotto winning = getValidWinningNum(inputView);
        int bonusNum = getValidBonusNum(inputView, winning);

        // 각 로또마다 당첨번호와 일치하는 숫자 개수, 보너스 숫자와의 일치 여부 구하기
        List<Integer> matchedNumber = new ArrayList<>(Collections.nCopies(counts, 0));
        List<Boolean> matchedBonusNum = new ArrayList<>(Collections.nCopies(counts, false));
        for (int i = 0; i < manyLotto.size(); i++) {
            List<Integer> oneLotto = manyLotto.get(i);
            matchedNumber.set(i, winning.getSameNumberCount(oneLotto));
            if (matchedNumber.get(i) == 5 && oneLotto.contains(bonusNum)) {
                matchedBonusNum.set(i, true);
            }
        }
        Map<LottoRanks, Integer> winnerCount = LottoRanks.getEnumMap();
        for (int i = 0; i < manyLotto.size(); i++) {
            int sameNumCount = matchedNumber.get(i);
            boolean sameBonusNum = matchedBonusNum.get(i);
            LottoRanks key = LottoRanks.findKey(sameNumCount, sameBonusNum);
            winnerCount.put(key, winnerCount.get(key)+1);
        }

        // 당첨 통계 산출 결과 출력하기
        outputView.printWinningResult(winnerCount);

        // 수익률 산출 및 출력하기
        long totalPrize = 0;
        for (LottoRanks key : winnerCount.keySet()) {
            totalPrize += (long)key.getWinnings() * winnerCount.get(key);
        }
        double returnRates = (double)totalPrize*100/cost;
        System.out.println("총 수익률은 " + String.format("%.1f", returnRates) + "%입니다.");
        Console.close();
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
}
