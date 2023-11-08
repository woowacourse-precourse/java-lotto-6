package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import output.LottoCounter;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        hasDulicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현
    private List<Integer> getLotto() {
        return numbers;
    }

    private void hasDulicatedNumber(final List<Integer> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.buildErrorMessage(903));
        }
    }
    public static List<List<Integer>> getLottos(final int money) {
        int n = LottoCounter.countLotto(money);
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto temp = new Lotto(numbers);
            List<Integer> lotto = temp.getLotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
