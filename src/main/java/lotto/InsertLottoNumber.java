package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertLottoNumber {
    private final List<Integer> lotto;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private static final String ERROR_NUMBER_MESSAGE = "[ERROR] 숫자를 다시 입력하세요.";
    private static final String ERROR_NUMBER_SIZE_MESSAGE = "[ERROR] 1부터 45 사이의 숫자를 입력하세요.";

    public InsertLottoNumber(String number) {
        String[] lottoNumber = number.split(",");
        checkNumber(lottoNumber);
        checkValidate(lottoNumber);

        lotto = Arrays.stream(lottoNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void checkValidate(String[] number) {
        for (String count : number) {
            if (!validateNumber(count)) {
                throw new IllegalArgumentException(ERROR_NUMBER_SIZE_MESSAGE);
            }
        }
    }

    private void checkNumber(String[] number) {
        for (String count : number) {
            boolean isTrue = count.chars().allMatch(Character::isDigit);

            if (!isTrue)
                throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }

    private boolean validateNumber(String number) {
        int count = Integer.parseInt(number);

        return count >= LOTTO_NUMBER_MIN && count <= LOTTO_NUMBER_MAX;
    }

    public List<Integer> sendLottoNumber() {
        return lotto;
    }
}
