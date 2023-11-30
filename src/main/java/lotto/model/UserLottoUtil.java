package lotto.model;

import java.util.List;

public class UserLottoUtil {
    private static final String LOTTO_TYPE_ERROR = "[ERROR]숫자만을 입력해주세요";
    private static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 로또 번호를 중복해서 입력하지마세요";
    private static final String LOTTO_LENGTH_ERROR = "[ERROR] 로또 번호는 6개만 입력 해주세요";
    private static final String LOTTO_RANGE_ERROR = "[ERROR] 1~45 범위의 숫자만을 입력하세요";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_MAX_SIZE = 6;

    public int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(LOTTO_TYPE_ERROR);
        }
    }

    public void duplicateNumberInList(List<Integer> userLotto, int checkNumber, int checkIndex) {
        if (userLotto.subList(checkIndex + 1, userLotto.size()).contains(checkNumber)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
        }
    }

    public void validateSizeUserLotto(List<Integer> userLotto) {
        if (userLotto.size() != LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR);
        }
    }

    public void duplicateLotto(List<Integer> userLotto) {
        for (int index = 0; index < userLotto.size(); index++) {
            duplicateNumberInList(userLotto, userLotto.get(index), index);
            checkNumberRange(userLotto.get(index));
        }
    }

    public void checkNumberRange(int checkNumber) {
        if (MIN_NUMBER > checkNumber || checkNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR);
        }
    }
}
