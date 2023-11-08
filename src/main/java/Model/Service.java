package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private Service() {
    }

    private class Singleton {
        private static final Service INSTANCE = new Service();
    }

    public static Service getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Integer> lottoGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> makeLotto(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getMyWinning(int winningNumber) {
        if (winningNumber == 1) {
            return Winnings.FIRST_PRIZE_MONEY.getValue();
        }

        if (winningNumber == 2) {
            return Winnings.SECOND_PRIZE_MONEY.getValue();
        }

        if (winningNumber == 3) {
            return Winnings.THIRD_PRIZE_MONEY.getValue();
        }

        if (winningNumber == 4) {
            return Winnings.FOURTH_PRIZE_MONEY.getValue();
        }

        if (winningNumber == 5) {
            return Winnings.FIFTH_PRIZE_MONEY.getValue();
        }

        return 0;
    }

    public int calWinningsRank(int count, boolean bonus) {
        if(count == 3) {
            return WinningRanks.FIFTH_RANK.getValue();
        }

        if(count == 4) {
            return WinningRanks.FOURTH_RANK.getValue();
        }

        if(count == 5) {
            if(bonus) {
                return WinningRanks.SECOND_RANK.getValue();
            }
            return WinningRanks.THIRD_RANK.getValue();
        }

        if(count == 6) {
            return WinningRanks.FIRST_RANK.getValue();
        }

        return 0;
    }
}
