package lotto.view.constants;

import java.util.List;
import java.util.stream.Collectors;

public enum ConstantMessage {
    ASK_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),

    DISPLAY_LOTTO_PURCHASE_COUNT("개를 구매했습니다.");

    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }


}
