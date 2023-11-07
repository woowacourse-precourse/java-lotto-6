package lotto.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
            throw new IllegalArgumentException(ValidateErrorMessage.LOTTO_SAME_NUMBER_ERROR.getMessage());
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    public Map<String, Integer> match(List<Integer> luckyNumbers, int bonusNumber){
        Map<String, Integer> result = new HashMap<>();
        matchLuckyNumbers(luckyNumbers, result);
        matchBonusNumber(bonusNumber, result);
        return result;
    }

    private void matchBonusNumber(int bonusNumber, Map<String, Integer> result) {
        result.put(GameConstant.BONUS_NUMBER, 0);
        if (numbers.contains(bonusNumber)){
            result.put(GameConstant.BONUS_NUMBER, 1);
        }
    }

    private void matchLuckyNumbers(List<Integer> luckyNumbers, Map<String, Integer> result) {
        HashSet<Integer> lotto = new HashSet<>(numbers);
        HashSet<Integer> matcher = new HashSet<>(luckyNumbers);
        matcher.retainAll(lotto);
        result.put(GameConstant.LUCKY_NUMBERS, matcher.size());
    }
}
