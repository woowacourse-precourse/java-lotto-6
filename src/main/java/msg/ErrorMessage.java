package msg;

import java.text.MessageFormat;
import lotto.LottoConfig;

public enum ErrorMessage {
    COUNT_DIFFERENCE("[ERROR] 로또 번호 개수가 다릅니다."),
    DUPLICATE("[ERROR] 중복된 숫자를 가질 수 없습니다."),
    INVALID_NUMBER("[ERROR] 로또 번호로 적합하지 않은 숫자입니다."),
    THERES_NO_COMMON("[ERROR] 일반 숫자가 없습니다."),
    THERES_NO_BONUS("[ERROR] 보너스 숫자가 없습니다."),
    INVALID_UNIT(MessageFormat.format("[ERROR] {0}원 단위로 입력해주세요.", LottoConfig.PRICE)),
    NOT_A_NUMBER("[ERROR] 숫자를 입력해 주세요."),
    NONE_PRIZE("[ERROR] 미 당첨 내역은 출력할 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}
