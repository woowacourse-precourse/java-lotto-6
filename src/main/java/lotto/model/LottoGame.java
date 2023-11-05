package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final User user;

    private final WinLotto winLotto;

    public LottoGame(Integer amount) {

    }

    public List<Lotto> issuanceLotto(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount / 1000; i++) {
            List<Integer> numbers = new ArrayList<>();

            lottos.add(new Lotto(generateNumbers(numbers)));
        }

        return lottos;
    }

    public List<Integer> generateNumbers(List<Integer> numbers) {

        do {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        } while (validateDuplication(numbers));

        return numbers;
    }

    public boolean validateDuplication(List<Integer> nums) {

        for (Integer number : nums) {
            if (nums.contains(number)) {
                return false;
            }
        }

        return true;
    }
}
