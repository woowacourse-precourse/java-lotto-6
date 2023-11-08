package lotto.domain;

import static lotto.global.Validator.validateLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottosDto;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto generateRandomLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .stream()
            .sorted()
            .toList();
        return Lotto.of(numbers);
    }

    public static List<Lotto> buyLottos(Tickets tickets) {
        return IntStream.range(0, tickets.getNumberOfTickets())
            .mapToObj(i -> Lotto.generateRandomLottoNumbers())
            .toList();
    }

    public static LottosDto toLottosDto(Tickets tickets) {
        List<Lotto> lottos = buyLottos(tickets);
        return new LottosDto(lottos);
    }


    public String toString() {
        return numbers.toString();
    }

    public int getMatchCount(Lotto userLottoNumbers) {
        return (int) numbers.stream()
            .filter(userLottoNumbers.numbers::contains)
            .count();
    }

    public boolean checkDuplicate(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
