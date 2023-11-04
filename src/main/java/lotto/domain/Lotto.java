package lotto.domain;

import java.util.List;
import java.util.Objects;

/**
 * TODO : 아래 주석 지우기
 * 제공된 Lotto 클래스를 활용해 구현해야 한다.
 * numbers의 접근 제어자인 private을 변경할 수 없다.
 * Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
 * Lotto의 패키지 변경은 가능하다.
 */
class Lotto {

    private static final int MAX_LOTTO_NUMBERS_SIZE = 6;
    private static final String UNKNOWN_NUMBERS_MESSAGE = "알 수 없는 숫자 목록으로 로또를 생성할 수 없습니다.";
    private static final String INVALID_LOTTO_NUMBERS_SIZE_MESSAGE =
            "로또 번호의 개수는 최대 " + MAX_LOTTO_NUMBERS_SIZE + "개입니다.";
    private static final String LOTTO_NUMBERS_DUPLICATION_MESSAGE = "로또 번호에 중복된 숫자를 포함할 수 없습니다.";

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
        if (numbers.size() != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE_MESSAGE);
        }
    }

    private static void checkNumbersDuplication(List<Integer> numbers) {
        if (calculateUniqueCount(numbers) != MAX_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_MESSAGE);
        }
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

    public int matchWith(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
