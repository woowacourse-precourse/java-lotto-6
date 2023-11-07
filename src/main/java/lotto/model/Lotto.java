package lotto.model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

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
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public static int buyLottoTicket(int money) {
        final int LOTTO_PRICE = 1000;
        return money / LOTTO_PRICE;
    }

    public static List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortLotto(numbers);
    }

    public static List<Integer> sortLotto(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static List<Lotto> collectLotto(int lottoTicketCount) {
        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = new Lotto(makeLotto());
            lotties.add(lotto);
        }
        return lotties;
    }
}
