package lotto.validator.impl;

import java.util.Arrays;
import java.util.List;
import lotto.constants.CommonLetter;
import lotto.constants.ErrorMessages;
import lotto.constants.GameInfo;
import lotto.validator.Validator;

public class LottoValidator implements Validator<String> {

    @Override
    public void validate(String data) {
        isNumberAndInRange(isSizeInRange(data));
    }

    // 로또 길이가 6이 아닌 경우
    public List<String> isSizeInRange(String data) {
        int originSize = data.split(CommonLetter.SEPARATOR.getLetter()).length;
        List<String> distinctData = Arrays.stream(data.split(CommonLetter.SEPARATOR.getLetter()))
            .distinct()
            .toList();
        if (originSize != distinctData.size()) {
            throwException(ErrorMessages.INPUT_LOTTO_DUPLICATE);
        }
        if (distinctData.size() != GameInfo.LOTTO_COUNT.getNumber()) {
            throwException(ErrorMessages.INPUT_LOTTO_SIZE);
        }
        return distinctData;
    }

    // 숫자가 아닌 경우 && 범위 내에 있을 경우
    private void isNumberAndInRange(List<String> data) {
        for (String number : data) {
            if (!isNumber(number)) {
                throwException(ErrorMessages.INPUT_LOTTO_SIZE);
            }
            if (!isInRange(number)) {
                throwException(ErrorMessages.INPUT_LOTTO_SIZE);
            }
        }
    }

    private boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInRange(String number) {
        return Integer.parseInt(number) >= GameInfo.LOTTO_MIN_NUMBER.getNumber()
            && Integer.parseInt(number) <= GameInfo.LOTTO_MAX_NUMBER.getNumber();
    }

}
