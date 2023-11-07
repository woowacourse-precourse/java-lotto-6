package lotto.controller;

import static lotto.model.Rank.FIFTH;
import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.FOURTH;
import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;
import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.DUPLICATED_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
            compareBonusAndWinningNumbers(new HashSet<>(lottoNumbers), bonus.getNumber());
        }
        return new Lotto(lottoNumbers);
    }

    public static Bonus createBonus(int number, Lotto firstPrizeLotto) {
        if (firstPrizeLotto != null) {
            compareBonusAndWinningNumbers(new HashSet<>(firstPrizeLotto.getNumbers()), number);
        }
        return new Bonus(number);
    }

    private static void compareBonusAndWinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    public static Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUM_OF_NUMBERS));
    }

    public static Map<Rank, Long> getWinningCountsByRank(List<Lotto> lottoTickets, Lotto firstPrizeLotto,
                                                         int bonusNum) {
        Map<Rank, Long> winningCountByRank = initializeWinningCountsByRank();
        for (Lotto lotto : lottoTickets) {
            int match = lotto.compareLotto(firstPrizeLotto);
            if (match >= NUM_OF_NUMBERS - 3) {
                winningCountByRank.put(checkRank(match, lotto, bonusNum),
                        winningCountByRank.get(checkRank(match, lotto, bonusNum)) + 1);
            }
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

    public static Rank checkRank(int match, Lotto lotto, int bonusNumber) {
        if (match == NUM_OF_NUMBERS) {
            return FIRST;
        }
        if (match == NUM_OF_NUMBERS - 1) {
            return resultSecondAndThird(lotto, bonusNumber);
        }
        if (match == NUM_OF_NUMBERS - 2) {
            return FOURTH;
        }
        return FIFTH;
    }

    public static Rank resultSecondAndThird(Lotto lotto, int bonusNumber) {
        if (lotto.compareBonus(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }
}
