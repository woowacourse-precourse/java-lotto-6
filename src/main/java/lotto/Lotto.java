package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constant.ErrorMessage;
import constant.ServiceMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private static int countLotto(final int money) {
        int n = money / 1000;
        System.out.println();
        System.out.print(String.valueOf(n).concat(ServiceMessage.getMessageByCode(102)));
        return n;
    }

    private void hasDulicatedNumber(final List<Integer> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.buildErrorMessage(903));
        }
    }
    public static List<List<Integer>> getLottos(final int money) {
        int n = countLotto(money);
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Lotto temp = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            List<Integer> lotto = temp.getLotto();
            Collections.sort(lotto);
            lottos.add(lotto);
        }
        return lottos;
    }
}
