package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Prize;
import lotto.model.Lotto;

import java.util.*;

import static lotto.constant.Prize.*;

public class Service {
    private final Prize[] prizes = new Prize[]{
            null,
            null,
            null,
            FIFTH_PRIZE,
            FOURTH_PRIZE,
            THIRD_PRIZE,
            FIRST_PRIZE
    };

    public List<Lotto> buyLotteries(int price) {
        int lotterySize = price / 1000;
        List<Lotto> boughtLotteries = new ArrayList<>();
        while (lotterySize-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            boughtLotteries.add(new Lotto(getSortedNumber(numbers)));
        }
        return boughtLotteries;
    }

    private List<Integer> getSortedNumber(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public HashMap<String, Integer> getLotteryResult(List<Lotto> boughtLotteries, Lotto winner, int bonusNumber) {
        HashMap<String, Integer> lotteryResult = new HashMap<>();
        for (Lotto lotto : boughtLotteries) {
            MatchResult matchResult = getMatchResult(lotto, winner, bonusNumber);
            updateLotteryResult(lotteryResult, matchResult.count, matchResult.hasBonus);
        }
        return lotteryResult;
    }

    private void updateLotteryResult(HashMap<String, Integer> result, int count, boolean hasBonus) {
        if (count < 3) {
            return;
        }
        if (count == 5 && hasBonus) {
            result.put(SECOND_PRIZE.getOutputMessage().getMsg(), result.getOrDefault(SECOND_PRIZE.getOutputMessage().getMsg(), 0) + 1);
            return;
        }
        result.put(prizes[count].getOutputMessage().getMsg(), result.getOrDefault(prizes[count].getOutputMessage().getMsg(), 0) + 1);
    }

    private MatchResult getMatchResult(Lotto boughtLotto, Lotto winner, int bonusNumber) {
        boolean[] matched = new boolean[46];
        int match = 0;
        for (int number : winner.getNumbers()) {
            matched[number] = true;
        }
        for (int number : boughtLotto.getNumbers()) {
            if (matched[number]) {
                match += 1;
            }
        }
        return new MatchResult(match, matched[bonusNumber]);
    }


    private static class MatchResult {
        int count;
        boolean hasBonus;

        public MatchResult(int count, boolean hasBonus) {
            this.count = count;
            this.hasBonus = hasBonus;
        }
    }

}
