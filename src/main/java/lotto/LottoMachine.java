package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

    private int lottoCount;

    public void insertMoney(String input) {
        notParsableNumber(input);
        notValidNumber(Integer.parseInt(input));
        notDividedWithThousand(Integer.parseInt(input));

        lottoCount = Integer.parseInt(input) / 1000;
    }

    private void notParsableNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값을 정수로 변환할 수 없습니다.");
        }
    }

    private void notValidNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 0 이하의 숫자입니다.");
        }
    }

    private void notDividedWithThousand(int number) {
        int remainder = number % 1000;

        if (remainder > 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나눠 떨어지지 않습니다.");
        }
    }

    List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        notSixNumbers(numbers);
        duplicateNumber(numbers);
        for (Integer number : numbers) {
            numberNotInRange(number);
        }

        return numbers;
    }

    public void notSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 가지고 있지 않습니다.");
        }
    }

    public void duplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복 숫자가 존재합니다.");
        }
    }

    public void numberNotInRange(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45의 범위가 아닌 숫자가 있습니다.");
        }
    }


}
