package lotto.model;

import java.util.*;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();
    private static final String WRONG_NUMBER_FORMAT = "잘못된 형식입니다. 숫자 구분은 오직 ,(comma)로만 해주세요.";
    private static final String NOT_SIX_NUMBERS = "6개의 숫자를 입력(생성)해주세요.";
    private static final String DOUBLE_ELEMENT_EXCEPTION = "중복된 원소가 존재합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numberCommand) {
        List<String> commaSeparatedNumbers = List.of(numberCommand.split(","));
        validateNumber(commaSeparatedNumbers);
        List<Integer> shiftedNumbers = new ArrayList<>();
        for (String number: commaSeparatedNumbers)
            shiftedNumbers.add(Integer.parseInt(number));
        validate(shiftedNumbers);
        Collections.sort(shiftedNumbers);
        this.numbers = shiftedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS);
        }
    }

    private void validateNumber(List<String> splitNumbers) {
        for (String numberLiteral : splitNumbers) {
            try {
                Integer.parseInt(numberLiteral);
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(WRONG_NUMBER_FORMAT);
            }
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int element : numbers) {
            if (!uniqueNumbers.add(element)) {
                throw new IllegalArgumentException(DOUBLE_ELEMENT_EXCEPTION);
            }
        }
    }

    public int countMatch(Lotto targetNumbers) {
        int countNumberMatching = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (targetNumbers.numbers.get(i) == numbers.get(i))
                countNumberMatching++;
        }
        return countNumberMatching;
    }

    public boolean isBonus(BonusNumber bonusNumber) {
        for (int number: numbers) {
            if (bonusNumber.isEqual(number))
                return true;
        }
        return false;
    }

    public Ranking checkRanking(Lotto winningNumbers, BonusNumber bonusNumber) {
        int countTotalMatches = this.countMatch(winningNumbers);
        boolean bonusNumberCheck = this.isBonus(bonusNumber);
        if (bonusNumberCheck) countTotalMatches++;

        if (countTotalMatches == 5 && !bonusNumberCheck) {
            return Ranking.SECOND;
        }
        return Ranking.getRanking(countTotalMatches, false);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
