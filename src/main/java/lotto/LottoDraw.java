package lotto;

import lotto.domain.*;
import lotto.service.PrintUtil;

import java.util.*;

public class LottoDraw {
    private final List<String> lottoPlacePrice = new ArrayList<>(Arrays.asList("5000", "50000", "1500000", "30000000", "2000000000"));

    Map<Integer, Map<String, Integer>> lottoPrizeSummary;

    LottoNumber lottoNumber = new LottoNumber();
    LottoNumbers lottoNumbers = new LottoNumbers();
    LottoStatistics lottoStatistics = new LottoStatistics();
    LottoPrize lottoPrize = new LottoPrize();
    PrintUtil printUtil = new PrintUtil();

    public void startLottoDraw() {

        Lotto[] lottoNumbers = pickLottoNumbers();
        Lotto winnerNumbers = pickWinnerNumbers();
        int bonusNumber = pickBonusNumber(winnerNumbers);

        printTotalProfit(printSummarizeWithLottoNumbers(lottoNumbers, winnerNumbers, bonusNumber), lottoNumbers.length);

    }

    public int getPurchaseAmount() {
        return lottoNumber.inputPurchaseAmount();
    }

    public Lotto[] pickLottoNumbers() {
        int numberOfLotto = getPurchaseAmount() / 1000;
        return lottoNumbers.pickLottoNumbers(numberOfLotto);
    }

    public Lotto pickWinnerNumbers() {
        return lottoNumber.inputWinnerNumbers();
    }

    public int pickBonusNumber(Lotto lotto) {
        return lottoNumber.inputBonusNumber(lotto);
    }

    public Map<String, Integer> printSummarizeWithLottoNumbers(Lotto[] lottoNumbers, Lotto winnerNumbers, int bonusNumber) {
        lottoPrizeSummary = lottoPrize.initLottoPrize();
        Map<String, Integer> summary = summarizeLottoResults(lottoNumbers, winnerNumbers, bonusNumber);
        printLottoResults();
        return summary;
    }

    public Map<String, Integer> summarizeLottoResults(Lotto[] lottoNumbers, Lotto winnerNumbers, int bonusNumber) {
        Map<String, Integer> summary = innerMap();
        for (int i = 0; i < lottoNumbers.length; i++) {
            int winCount = lottoStatistics.compareLottoNumbersWithWinnerNumbers(lottoNumbers[i], winnerNumbers);
            String checkBonus = lottoStatistics.compareLottoNumbersWithBonusNumber(lottoNumbers[i], bonusNumber);

            if (winCount < 3) continue;
            if (winCount != 5) checkBonus = "NoBonus";

            String getKey = winCount + checkBonus;
            summary.put(getKey, summary.getOrDefault(getKey, 0) + 1);
            lottoPrizeSummary.put(winCount, summary);
        }
        return summary;
    }

    public void printLottoResults() {
        printUtil.printWinnerStatistics();
        int lottoPlacePriceIdx = 0;
        for (int winCount = 3; winCount <= 6; winCount++, lottoPlacePriceIdx++) {

            if (winCount == 5) {
                int count = lottoPrizeSummary.get(winCount).get("5NoBonus");
                System.out.println(winCount + "개 일치 (" + lottoPlacePrice.get(lottoPlacePriceIdx).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원) - " + count + "개");
                lottoPlacePriceIdx++;
                count = lottoPrizeSummary.get(winCount).get("5Bonus");
                System.out.println(winCount + "개 일치, 보너스 볼 일치 (" + lottoPlacePrice.get(lottoPlacePriceIdx).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원) - " + count + "개");
                continue;
            }
            String str = winCount + "NoBonus";
            int count = lottoPrizeSummary.get(winCount).get(str);
            System.out.println(winCount + "개 일치 (" + lottoPlacePrice.get(lottoPlacePriceIdx).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원) - " + count + "개");
        }
    }

    public Map<String, Integer> innerMap() {
        Map<String, Integer> innerMap = new HashMap<>();

        for (int winCount = 3; winCount <= 6; winCount++) {
            String str = winCount + "NoBonus";
            innerMap.put(str, 0);
            if (winCount == 5) {
                str = winCount + "Bonus";
                innerMap.put(str, 0);
            }
        }
        return innerMap;
    }

    public void printTotalProfit(Map<String, Integer> summary, int lottoPurchaseAmount) {
        String totalProfit = lottoStatistics.calculateTotalProfit(summary, lottoPlacePrice, lottoPurchaseAmount);
        printUtil.printProfit(totalProfit);
    }
}
