package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String UNKNOWN_NUMBERS_MESSAGE = "알 수 없는 숫자 목록으로 로또를 생성할 수 없습니다.";
    private static final String UNKNOWN_LOTTO_MESSAGE = "알 수 없는 로또와 매치할 수 없습니다.";
    private static final String LOTTO_NUMBERS_DUPLICATION_MESSAGE = "로또 번호에 중복된 숫자를 포함할 수 없습니다.";
    private static final String INVALID_LOTTO_NUMBERS_SIZE_MESSAGE =
            "로또 번호의 개수는 최대 " + LOTTO_NUMBERS_SIZE + "개입니다.";

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validate(numbers);

        return new Lotto(mapToLottoNumber(numbers));
    }

    private static void validate(List<Integer> numbers) {
        checkNumbersNonNull(numbers);
        checkNumbersSize(numbers);
        checkNumbersDuplication(numbers);
    }

    private static void checkNumbersNonNull(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException(UNKNOWN_NUMBERS_MESSAGE);
        }
    }

    private static void checkNumbersSize(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE_MESSAGE);
        }
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private static void checkNumbersDuplication(List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_MESSAGE);
        }
    }

    private static boolean hasDuplication(List<Integer> numbers) {
        return calculateUniqueCount(numbers) != LOTTO_NUMBERS_SIZE;
    }

    private static long calculateUniqueCount(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private static List<LottoNumber> mapToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    public int matchWith(Lotto lotto) {
        checkLottoNonNull(lotto);

        return (int) lotto.numbers.stream()
                .filter(this::contains)
                .count();
    }

    private void checkLottoNonNull(Lotto lotto) {
        if (Objects.isNull(lotto)) {
            throw new IllegalArgumentException(UNKNOWN_LOTTO_MESSAGE);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
