package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;

public class Lotto {    // 인스턴스 변수 추가 ㄴㄴ, 패키지 변경은 가능
    private final List<Integer> numbers;    // 접근 제어자 변경 ㄴㄴ

    public Lotto(List<Integer> numbers) {
        validateLottoTicketSize(numbers);
        numbers.forEach(this::validateNumberInRange);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    public void validateLottoTicketSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.SIZE_OF_LOTTO_TICKET) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_OF_LOTTO_IS_NOT_PROPER.getMessage());
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    public int matchedCount(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(lotto.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Integer get(int index) {
        return numbers.get(index);
    }
}