package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.system.ExceptionMessage;
import lotto.system.LottoNumberConstant;
import lotto.system.SystemMessage;
import lotto.validator.BallValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createWinningNumbers() {
        while (true) {
            OutputView.printFrom(SystemMessage.INPUT_WINNING_NUMBER);
            try {
                return new Lotto(InputView.readIntegerList());
            } catch (IllegalArgumentException e) {
                OutputView.exceptionMessage(e);
            }
        }
    }

    public static Lotto createAuto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumberConstant.MIN.getValue(),
                LottoNumberConstant.MAX.getValue(), LottoNumberConstant.LENGTH.getValue()));
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDistinct(numbers);
        numbers.forEach(BallValidator::validate);
    }

    private void validateLength(List<Integer> numbers) {
        if (LottoNumberConstant.LENGTH.isNotEqual(numbers.size())) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_LENGTH.getMessage());
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DISTINCT.getMessage());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.get());
    }

    private boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> get() {
        return numbers;
    }
}
