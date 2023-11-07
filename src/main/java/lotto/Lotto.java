package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯자리의 수입니다.\n");
        }

        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복값을 허용하지 않습니다.\n");
        }

        for (Integer number : numbers) {
            if (!isLottoRange(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.\n");
            }
        }
    }

    public static boolean isLottoRange(Integer number) {
        return number > 0 && number < 46;
    }


    public static void checkLottoNumber(Lotto lotto, Integer bonusNumber) {

    }
}
