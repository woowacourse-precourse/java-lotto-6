package lotto.util;

import static lotto.util.constant.GameRule.LOTTO_SIZE;
import static lotto.util.content.ErrorMessage.LOTTO_SIZE_ERROR;

import java.util.List;

public class Censor {

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getContent());
        }
    }

    // TODO: 추가 검증 기능 구현

}
