package lotto.model;

import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;

/**
 * 로또 번호를 저장하는 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호의 개수가 6개인지 검증하는 메서드
     *
     * @param numbers 로또 번호 리스트
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(LottoExceptionMessage.INVALID_LOTTO_LENGTH);
        }
    }

    /**
     * 로또 번호의 중복을 확인하는 메서드
     *
     * @param numbers 로또 번호 리스트
     */
    private void duplicateValidate(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (numbers.size() != uniqueCount) {
            throw new LottoException(LottoExceptionMessage.INVALID_LOTTO_DUPLICATED);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
