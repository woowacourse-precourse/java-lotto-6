package lotto.controller;

import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Rank;

public class DataController {
    public static List<Integer> convertElementStringToInteger(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String element : input.split(",")) {
            numbers.add(Integer.parseInt(element));
        }
        return numbers;
    }

    public static Lotto createLotto(List<Integer> lottoNumbers, Bonus bonus) {
        if (bonus != null) {
            bonus.validateWinningNumbers(new HashSet<>(lottoNumbers));
        }
        return new Lotto(lottoNumbers);
    }

    public static Bonus createBonus(int number, Lotto firstPrizeLotto) {
        if (firstPrizeLotto != null) {
            firstPrizeLotto.validateBonusNumber(number);
        }
        return new Bonus(number);
    }

    public static Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUM_OF_NUMBERS));
    }

    public static Map<Rank, Long> getWinningCountsByRank(List<Lotto> lottoTickets, Lotto firstPrizeLotto,
                                                         int bonusNum) {
        Map<Rank, Long> winningCountByRank = initializeWinningCountsByRank();
        for (Lotto lotto : lottoTickets) {
            lotto.updateLottoRank(firstPrizeLotto, winningCountByRank, bonusNum);
        }
        return winningCountByRank;
    }

    public static Map<Rank, Long> initializeWinningCountsByRank() {
        Map<Rank, Long> winningCountByRank = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningCountByRank.put(rank, 0L);
        }
        return winningCountByRank;
    }

    public static long calcTotalPrizeAmount(Map<Rank, Long> winningCountByRank) {
        long totalPrizeAmount = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeAmount += winningCountByRank.get(rank) * rank.getPrizeMoney();
        }
        return totalPrizeAmount;
    }

    public static double calcGainPercentage(long totalPrizeAmount, long money) {
        return Math.round(((double) totalPrizeAmount / money * 100 * 10)) / 10.0;
    }
}
