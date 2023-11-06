package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {

    public void checkLottoNumber(List<String> lotto) {
        checkLottoDuplicate(lotto);
    }

    //로또 번호가 중복이 없는지 확인
    public void checkLottoDuplicate(List<String> lotto) {
        List<String> Set;
        Set<String> lottoWithoutDuplicate = new HashSet<>(lotto);
        if (lotto.size() != lottoWithoutDuplicate.size()) {
            System.out.println("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
