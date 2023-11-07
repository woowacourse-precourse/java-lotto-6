package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.enums.LottoNumberRange;
import lotto.enums.LottoRank;
import lotto.model.Result;
import lotto.model.User;

public class Computer {

    public void getLottoNumber(Result result) {
        while (true) {
            try {
                List<Integer> numbers = getRandomNumber();
                Lotto lotto = new Lotto(numbers);
                result.addLottoTicket(lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoNumberRange.MIN_NUMBER.getValue(),
                LottoNumberRange.MAX_NUMBER.getValue(), LottoNumberRange.MIN_SELECT_COUNT.getValue()));
        return sortNumber(numbers);
    }

    public List<Integer> sortNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public void calculateLottoTicketCount(User user) {
        user.setLottoTicketCount(user.getPaymentAmount() / 1000);
    }

    public void calculateTotalPrize(Result result) {
        int totalPrize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            int rankCount = getRankCount(lottoRank.getRank(), result);
            totalPrize += lottoRank.getPrize() * rankCount;
        }
        result.setTotalPrize(totalPrize);
    }

    public int getRankCount(int rank, Result result) {
        int rankCount = 0;
        if (result.getWinningCount().containsKey(rank)) {
            rankCount = result.getWinningCount().get(rank);
        }
        return rankCount;
    }

    public void calculateTotalProfit(Result result, User user) {
        double TotalProfit = ((double) result.getTotalPrize() / user.getPaymentAmount()) * 100;
        result.setTotalProfit(String.format("%.1f%%", TotalProfit));
    }
}
