package lotto;

import java.util.regex.Pattern;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, String bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        if (!Pattern.matches("^[0-9]*$", bonusNumber)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 숫자만 가능합니다.");
        }
    }
}
