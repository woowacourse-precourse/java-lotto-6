package lotto.validator;

import lotto.domain.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {

    Constants constants = new Constants();

    public void checkLottoNumber(List<String> lotto) {
        checkLottoDuplicate(lotto);
    }

    public void checkBonusNumber(List<Integer> lotto, String bonusNumber) {
        // 숫자인지 validate하는 함수

        checkBonusDuplicate(lotto, Integer.parseInt(bonusNumber));
    }

    // 로또 번호가 중복이 없는지 확인
    public void checkLottoDuplicate(List<String> lotto) {
        Set<String> lottoWithoutDuplicate = new HashSet<>(lotto);
        if (lotto.size() != lottoWithoutDuplicate.size()) {
            System.out.println(constants.WINNING_NUMBER_DUPLICATED_ERROR);
            throw new IllegalArgumentException();
        }
    }

    // 보너스넘버가 중복이 아닌지 확인
    public void checkBonusDuplicate(List<Integer> lotto, int bonusNumber) {
        for (int i = 0; i < constants.LOTTO_NUMBER; i++) {
            if(lotto.get(i) == bonusNumber) {
                System.out.println(constants.BONUS_NUMBER_DUPLICATED_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }
}
