package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.StringUtils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateDuplicateNumbers(numbers);
        validateRangeOverNumber(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_LENGTH.constants) {
            throw new IllegalArgumentException(StringUtils.createErrorMessage("로또 번호는 6개를 입력해주세요."));
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersToSet = new HashSet<>(numbers);
        if (numbersToSet.size() != Constants.LOTTO_LENGTH.constants) {
            throw new IllegalArgumentException(StringUtils.createErrorMessage("로또 번호는 중복될 수 없습니다."));
        }
    }

    private void validateRangeOverNumber(List<Integer> numbers) {
        long overNumberCount = numbers.stream()
                .filter(number -> number > Constants.LOTTO_MAX_NUMBER.constants
                        || number < Constants.LOTTO_MIN_NUMBER.constants).count();

        if (overNumberCount != 0) {
            throw new IllegalArgumentException(StringUtils.createErrorMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다."));
        }
    }

    public String getLottoPrintMessage() {
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("[");

        List<String> numbersToString = numbers.stream().map(String::valueOf).toList();
        messageBuilder.append(String.join(", ", numbersToString));

        messageBuilder.append("]");

        return messageBuilder.toString();
    }

    public boolean isNumberContain(int number) {
        return numbers.contains(number);
    }

    public Reward getLottoResult(WinningLotto winningLotto) {
        return Reward.valueOf(getMatchCount(winningLotto.getLotto()),
                isNumberContain(winningLotto.getBonusNumber().getNumber()));
    }

    private int getMatchCount(Lotto lotto) {
        return (int) this.numbers.stream().filter(lotto::isNumberContain).count();
    }
}
