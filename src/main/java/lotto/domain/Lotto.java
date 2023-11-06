package lotto.domain;

import java.util.List;

public class Lotto {

    private static String INPUT_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복되는 값을 사용할 수 없습니다.";
    private static String INPUT_RANGE_ERROR="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static String INPUT_SIZE_ERROR = "[ERROR] 당첨 번호는 6개의 숫자가 입력되어야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateWinningNumDuplication(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareLottoWithWinning(Lotto winningNum) {
        return (int) numbers.stream()
                .filter(winningNum::containNum)
                .count();
    }

    public boolean containNum(int number) {
        return numbers.contains(number);
    }

    public void validateWinningAndBonus(Lotto winningNum,int bonus){
        validateRangeInt(bonus);
        validateDuplication(winningNum.getNumbers(), bonus);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INPUT_SIZE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(INPUT_RANGE_ERROR);
            }
        }
    }

    private void validateRangeInt(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(INPUT_RANGE_ERROR);
        }
    }

    private void validateDuplication(List<Integer> winningNum, int bonus) {
        if(winningNum.contains(bonus)){
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR);
        }
    }

    private void validateWinningNumDuplication(List<Integer> winningNum) {
       if(winningNum.size()!=winningNum.stream().distinct().count()){
           throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR);
       }
    }
}
