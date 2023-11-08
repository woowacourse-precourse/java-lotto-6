package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.enums.LottoNumberRange;
import lotto.enums.LottoRank;

public class Computer {

    public Lotto getLottoNumber() {
        while (true) {
            try {
                List<Integer> numbers = getRandomNumber();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LottoNumberRange.MIN_NUMBER.getValue(),
                        LottoNumberRange.MAX_NUMBER.getValue(), LottoNumberRange.MIN_SELECT_COUNT.getValue()));
        return sortNumber(numbers);
    }

    public List<Integer> sortNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public int calculateLottoTicketCount(int paymentAmount) {
        return (paymentAmount / 1000);
    }

    public int calculateTotalPrize(HashMap<Integer, Integer> winningCount) {
        int totalPrize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankCount = getRankCount(lottoRank.getRank(), winningCount);
            totalPrize += lottoRank.getPrize() * rankCount;
        }
        return totalPrize;
    }

    public int getRankCount(int rank, HashMap<Integer, Integer> winningCount) {
        int rankCount = 0;
        if (winningCount.containsKey(rank)) {
            rankCount = winningCount.get(rank);
        }
        return rankCount;
    }

    public String calculateTotalProfit(int totalPrize, int paymentAmount) {
        double TotalProfit = ((double) totalPrize / paymentAmount) * 100;
        return (String.format("%.1f%%", TotalProfit));
    }
}
