package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int LOTTO_PRICE = 1000;
    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 45;
    private static int NUMBER_COUNT = 6;

    public static List<Lotto> buyLotto(int cash) {
        Validator.validateBuyCash(cash);
        return IntStream.range(0, cash / LOTTO_PRICE).mapToObj(i -> makeRandomNumbers()).toList();
    }

    private static Lotto makeRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return createLotto(numbers);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(new ArrayList<>(numbers));
    }
}
