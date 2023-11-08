package lotto.service;

import static lotto.constant.PrizeConstant.fifthPrizeCount;
import static lotto.constant.PrizeConstant.firstPrizeCount;
import static lotto.constant.PrizeConstant.fourthPrizeCount;
import static lotto.constant.PrizeConstant.secondPrizeCount;
import static lotto.constant.PrizeConstant.thirdPrizeCount;
import static lotto.service.InputService.winningNumberList;
import static lotto.service.OutputService.quantity;
import static lotto.view.InputView.bonusNumber;
import static lotto.view.InputView.inputMoney;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;

public class LottoService {
    public static List<List<Integer>> lottoNumberLists = new ArrayList<>();
    public static double returnRate;

    public static List<List<Integer>> generateLottoNumberLists() {
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Lotto.generateSortedLottoNumbers();

            lottoNumberLists.add(lottoNumbers);
        }

        return lottoNumberLists;
    }

    public static void calculateWinningStats() {
        for (List<Integer> lottoNumber : lottoNumberLists) {
            int matchCount = countMatches(lottoNumber);
            boolean matchBonus = hasBonus(lottoNumber);
            updatePrizeCounts(matchCount, matchBonus);
        }
    }

    private static int countMatches(List<Integer> lottoNumber) {
        int matchCount = 0;
        for (int winningNumber : winningNumberList) {
            if (lottoNumber.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static boolean hasBonus(List<Integer> lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    private static void updatePrizeCounts(int matchCount, boolean matchBonus) {
        Prize prize = Prize.getByMatchesAndBonus(matchCount, matchBonus);

        if (prize == Prize.FIRST_PRIZE) {
            firstPrizeCount++;
        }
        if (prize == Prize.SECOND_PRIZE) {
            secondPrizeCount++;
        }
        if (prize == Prize.THIRD_PRIZE) {
            thirdPrizeCount++;
        }
        if (prize == Prize.FOURTH_PRIZE) {
            fourthPrizeCount++;
        }
        if (prize == Prize.FIFTH_PRIZE) {
            fifthPrizeCount++;
        }
    }

    public static double calculateReturnRate() {
        int reward = fifthPrizeCount * Prize.FIFTH_PRIZE.getPrizeMoney()
                + fourthPrizeCount * Prize.FOURTH_PRIZE.getPrizeMoney()
                + thirdPrizeCount * Prize.THIRD_PRIZE.getPrizeMoney()
                + secondPrizeCount * Prize.SECOND_PRIZE.getPrizeMoney()
                + firstPrizeCount * Prize.FIRST_PRIZE.getPrizeMoney();

        returnRate = ((double) reward / (double) (inputMoney)) * 100;
        returnRate = Math.round(returnRate * 100.0) / 100.0;

        return returnRate;
    }
}
