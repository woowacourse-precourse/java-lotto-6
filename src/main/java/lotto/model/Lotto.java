package lotto.model;

import java.util.List;

public class Lotto {

    private static final String LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호가 중복됩니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    // 메서드 이름이랑 내부 매직 넘버는 수정해도 되는 부분인가?
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        if (isLottoSizeEqualToSix(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isLottoSizeEqualToSix(List<Integer> numbers) {
        return countUniqueLottoNumbers(numbers) != LottoConstants.LOTTO_NUMBER_SIZE;
    }

    private int countUniqueLottoNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}
