package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.constant.Rank;

public class LottoMachine {
    private List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MINIMUM.getValue(), LottoNumber.MAXIMUM.getValue(), LottoNumber.SIZE.getValue());
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Lotto> issue(int count) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lotteries.add(new Lotto(createNumbers()));
        }
        return lotteries;
    }

    public List<Rank> draw(Lotto winningNumber, int bonus, List<Lotto> lotteries) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            int count = lotto.equalsNumberCount(winningNumber);
            result.add(Rank.getRank(count, lotto.contains(bonus)));
        }
        return result;
    }

    public double combineWinnings(List<Rank> result) {
        double winnings = 0;
        for (Rank rank : result) {
            winnings += rank.getWinnings();
        }
        return winnings;
    }
}