package lotto;

import java.util.List;
import java.util.Set;

import static lotto.LottoGenerator.LIMIT_NUMBER_COUNT;
import static util.NumberValidator.isValidNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidNumber(numbers);
    }

    // TODO: 추가 기능 구현
    public int getDrawResult(Set<Integer> winningNumber, int bonus){
        int divisionHelper = 1;
        Division result = Division.findDivisionResult(getSameCount(winningNumber), hasBonusBall(bonus));
        if(result == null){
            return LIMIT_NUMBER_COUNT;
        }
        return result.ordinal()+divisionHelper;
    }

    public int getSameCount(Set<Integer> winningNumber){
        return Math.toIntExact(
                numbers.stream()
                        .filter(number -> winningNumber.contains(number))
                        .count()
        );
    }

    public boolean hasBonusBall(int bonus){
        return numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
