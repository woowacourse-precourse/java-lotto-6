package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGenerator {
    public List<List<Integer>> generateLotto(int lottoAmount) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i ++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(numbers);
        }
        return lottos;
    }

    public List<Integer> winningInputToWinningLotto(String winningInput) {
        List<Integer> winningNumbers = Arrays.stream(winningInput.split(","))
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }
}
