package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    static int[] result;
    private final User user;
    public Service() {
        this.user = new User();
    }


    public List<List<Integer>> lottoDraw(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            user.add(numbers);
        }
        return user.getLottoNum();
    }

    public Lotto saveWinningNumbers(String[] split) {
        List<Integer> lottoNum = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lottoNum);
    }

    public int[] findWinner(Lotto lotto, int bonusNum) {
        List<List<Integer>> userNums = user.getLottoNum();
        result = new int[8];
        for (List<Integer> userNun : userNums) {
            result[lotto.checkSameNum(userNun, bonusNum)]++;
        }
        return result;
    }

    public double findRateOfReturn() {
        return result[3] * 5000 + result[4] * 50000 + result[5] * 1500000
                + result[7] * 30000000 + result[6] * 2000000000;

    }

}
