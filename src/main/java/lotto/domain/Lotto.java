package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.GameConstant;
import lotto.message.ValidateErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateSameNumber(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSameNumber(List<Integer> numbers) {
        Set<Integer> tempNumber = new HashSet<>(numbers);
        if (tempNumber.size() < numbers.size()) {
            throw new IllegalArgumentException(
                    ValidateErrorMessage.LOTTO_SAME_NUMBER_ERROR.getMessage());
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public Reward match(List<Integer> luckyNumbers, int bonusNumber){
        return Reward.computer(matchLuckyNumbers(luckyNumbers), matchBonusNumber(bonusNumber));
    }

    private int matchBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }

    private int matchLuckyNumbers(List<Integer> luckyNumbers) {
        HashSet<Integer> lotto = new HashSet<>(numbers);
        HashSet<Integer> matcher = new HashSet<>(luckyNumbers);
        matcher.retainAll(lotto);
        return matcher.size();
    }
}