package lotto.domain;

import java.util.List;
import lotto.config.exception.ExceptionType;
import lotto.config.exception.InputException;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.constant.LottoConstant;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers;

        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, this.lottoNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (isSixLength(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_INPUT_SIX);
        }

        if (isDuplicates(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_DUPLICATE);
        }

        if (isLottoRange(numbers)) {
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }
    }

    private boolean isSixLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplicates(List<Integer> numbers) {
        return numbers.size() > numbers.stream().distinct().count();
    }

    private boolean isLottoRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> isLower(number) || isHight(number));
    }

    private static boolean isHight(Integer number) {
        return LottoConstant.LOTTO_END_NUMBER < number;
    }

    private static boolean isLower(Integer number) {
        return LottoConstant.LOTTO_START_NUMBER > number;
    }

    public List<Integer> get(){
        return this.lottoNumbers;
    }
}
