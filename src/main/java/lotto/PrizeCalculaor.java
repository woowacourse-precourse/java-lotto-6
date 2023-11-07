package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrizeCalculaor {
    private final static int THREE_WINNING_PRIZE = 5000;
    private final static int FOUR_WINNING_PRIZE = 50000;
    private final static int FIVE_WINNING_PRIZE = 15000000;
    private final static int FIVE_BONUS_WINNING_PRIZE = 30000000;
    private final static int SIX_WINNING_PRIZE = 2000000000;

    List<Integer> calculatePrize(List<Integer> countsOfWonLotto){
        List<Integer> prizes = new ArrayList<>();
        prizes.add(countsOfWonLotto.get(0)*THREE_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(1)*FOUR_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(2)*FIVE_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(3)*FIVE_BONUS_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(4)*SIX_WINNING_PRIZE);
        return prizes;
    }

    int calculateTotalPrize(List<Integer> countsOfWonLotto){
        List<Integer> prizes = calculatePrize(countsOfWonLotto);
        int totalPrize = prizes.stream().reduce(0, Integer::sum);
        return totalPrize;
    }
}
