package lotto;

import lotto.constant.BonusString;
import lotto.constant.DrawMessage;
import lotto.constant.LottoRank;
import lotto.constant.NumberUtil;
import lotto.domain.*;
import lotto.service.PrintUtil;

import java.util.*;

public class LottoDraw {
    private final List<String> lottoPlacePrice = new ArrayList<>(Arrays.asList("5000", "50000", "1500000", "30000000", "2000000000"));
    private final String hasBonus = BonusString.BONUS.getBonus();
    private final String noBonus = BonusString.NOBONUS.getBonus();
    Map<Integer, Map<String, Integer>> lottoPrizeSummary;
    StringBuilder result;

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
        return lottoNumbers.pickLottoNumbers(getPurchaseAmount());
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
        for (Lotto number : lottoNumbers) {
            int winCount = lottoStatistics.compareLottoNumbersWithWinnerNumbers(number, winnerNumbers);
            String checkBonus = lottoStatistics.compareLottoNumbersWithBonusNumber(number, bonusNumber);

            if (winCount < NumberUtil.MIN_WINNING_COUNT.getNumber()) continue;
            implementCount(summary, winCount, checkBonus);
        }
        return summary;
    }

    public void implementCount(Map<String, Integer> summary, int winCount, String checkBonus) {
        if (winCount != NumberUtil.BONUS_KEY_FIVE.getNumber()) checkBonus = noBonus;

        String getKey = winCount + checkBonus;
        summary.put(getKey, summary.getOrDefault(getKey, 0) + 1);
        lottoPrizeSummary.put(winCount, summary);
    }

    public void printLottoResults() {
        printUtil.printWinnerStatistics();
        result = new StringBuilder();
        for(int index = 0; index < LottoRank.values().length; index++) {
            result.append("\n");
            LottoRank lottoRank = LottoRank.values()[index];
            String message = DrawMessage.NO_BONUS_WINNING_RESULT_MESSAGE.getMessage();

            if(lottoRank.getBonus().equals(hasBonus)){
                message = DrawMessage.BONUS_WINNING_RESULT_MESSAGE.getMessage();
            }
            sumUpResultsHasBonus(lottoRank, index, message);
        }
        System.out.println(result);
    }

    public void sumUpResultsHasBonus(LottoRank lottoRank, int lottoPlacePriceIdx, String message) {
        int winCount = lottoRank.getWinningCount();
        String bonusCheck = lottoRank.getWinningCount() + lottoRank.getBonus();

        result.append(String.format(message,
                lottoRank.getWinningCount(),
                lottoPlacePrice.get(lottoPlacePriceIdx).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ","),
                lottoPrizeSummary.get(winCount).get(bonusCheck)));
    }

    public Map<String, Integer> innerMap() {
        Map<String, Integer> innerMap = new LinkedHashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            innerMap.put(lottoRank.getWinningCount() + lottoRank.getBonus(), 0);
        }
        return innerMap;
    }

    public void printTotalProfit(Map<String, Integer> summary, int lottoPurchaseAmount) {
        String totalProfit = lottoStatistics.calculateTotalProfit(summary, lottoPlacePrice, lottoPurchaseAmount);
        printUtil.printProfit(totalProfit);
    }
}
