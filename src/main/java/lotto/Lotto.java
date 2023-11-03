package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

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


    }


    public List<Lotto> publishRandomLottos(int ticketNum) {
        return IntStream.range(0, ticketNum)
                .mapToObj(i -> generateRandomLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateRandomLotto() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }
}
