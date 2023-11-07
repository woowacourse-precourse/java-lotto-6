package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLotto(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i ++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<Integer> winningInputToWinningLotto(String winningInput) {
        validateWinningInput(winningInput);

        List<Integer> winningNumbers = Arrays.stream(winningInput.split(","))
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }

    private void validateWinningInput(String winningInput) {
        if (!winningInput.matches("^[\\d,\\s]+$")) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_FORMAT.getMessage());
        }
    }
}
