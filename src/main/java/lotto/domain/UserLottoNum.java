package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class UserLottoNum {
    private static final Integer LOTTO_SIZE = 7;
    private static final Integer MAX_NUM = 45;
    private static final Integer MIN_NUM = 1;

    private final Lotto userLotto;
    private final Integer bonusNum;

    public UserLottoNum(List<Integer> userLotto, Integer bonusNum) {
        this.userLotto = new Lotto(userLotto);

        validateBonusNum(userLotto, bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateBonusNum(List<Integer> userLotto, Integer bonusNum) {
        validateDuplicate(userLotto, bonusNum);
        validateRange(bonusNum);
    }

    private void validateDuplicate(List<Integer> userLotto, Integer bonusNum) {
        Set<Integer> nonDuplicateNum = new HashSet<>(userLotto);
        nonDuplicateNum.add(bonusNum);
        if(nonDuplicateNum.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복되었습니다.");
        }
    }

    private void validateRange(Integer bonusNum) {
        if(bonusNum <= MIN_NUM || bonusNum >= MAX_NUM) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 1~45 범위에 없습니다.");
        }
    }

    public boolean isContain(int num) {
        return userLotto.isContain(num);
    }
}
