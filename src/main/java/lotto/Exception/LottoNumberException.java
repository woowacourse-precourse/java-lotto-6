package lotto.Exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberException {
    private final static String ERROR = "[ERROR] ";

    public void checkLottoNumbers(List<Integer> numbers) {
        notRightLengthCase(numbers);
        notRightRangeCase(numbers);
        duplicationCase(numbers);
    }

    public void LottoNumbersCase(String numbers) {
        // [E1] 로또 번호의 “개수”가 6개 미만 또는 초과될 경우_끝자리 쉼표
        if (numbers.endsWith(",")) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 6개를 입력해야 합니다.");
        }

        // [E5] 공백을 입력한 경우
        if (numbers.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR + "로또 번호를 입력해주세요.");
        }

        // [E3] 로또 번호에 문자를 입력한 경우
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (!(Character.isDigit(c) || c == ',')) {
                throw new IllegalArgumentException(ERROR + "로또 번호 입력은 숫자와 콤마(,)로 구성해주세요.");
            }
        }
    }

    // [E1] 로또 번호의 “개수”가 6개 미만 또는 초과될 경우
    public void notRightLengthCase(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 6개를 입력해야 합니다.");
        }
    }

    // [E2] 로또 번호의 1~45 범위에 벗어난 경우
    public void notRightRangeCase(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // [E4] 로또 번호가 중복된 경우
    public void duplicationCase(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        inputNumbers.stream().map(number -> numbers.add(number)).collect(Collectors.toList());
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 중복되지 않는 숫자를 입력해주세요.");
        }
    }
}
