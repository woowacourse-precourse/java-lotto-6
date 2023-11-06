package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.EnumList.ConstantErrorMessage;
import lotto.EnumList.ConstantLotto;

public class InsertLottoNumber {
    private final List<Integer> lotto;

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
                throw new IllegalArgumentException(ConstantErrorMessage.ERROR_NUMBER_SIZE_MESSAGE.errorMessage());
            }
        }
    }

    private void checkNumber(String[] number) {
        for (String count : number) {
            boolean isTrue = count.chars().allMatch(Character::isDigit);

            if (!isTrue) {
                throw new IllegalArgumentException(ConstantErrorMessage.ERROR_NUMBER.errorMessage());
            }
        }
    }

    private boolean validateNumber(String number) {
        int count = Integer.parseInt(number);

        return count >= ConstantLotto.MIN_NUMBER.value() && count <= ConstantLotto.MAX_NUMBER.value();
    }

    public List<Integer> sendLottoNumber() {
        return lotto;
    }
}
