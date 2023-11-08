package lotto.domain;

import static lotto.global.Constants.INITIAL_INDEX;
import static lotto.global.Constants.LOTTO_NUMBER_MAX;
import static lotto.global.Constants.LOTTO_NUMBER_MIN;
import static lotto.global.Constants.LOTTO_NUMBER_SIZE;
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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                        LOTTO_NUMBER_SIZE)
                .stream()
                .sorted()
                .toList();
        return Lotto.of(numbers);
    }

    public static List<Lotto> buyLottos(Tickets tickets) {
        return IntStream.range(INITIAL_INDEX, tickets.getNumberOfTickets())
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

    public int getMatchCount(Lotto winningLottoNumber) {
        return (int) numbers.stream()
                .filter(winningLottoNumber.numbers::contains)
                .count();
    }

    public boolean checkDuplicateNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}