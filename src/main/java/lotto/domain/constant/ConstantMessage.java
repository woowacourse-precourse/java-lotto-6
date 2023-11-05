package lotto.domain.constant;

import java.text.DecimalFormat;
public enum ConstantMessage {
    //입력 메시지
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    //출력 메시지
    // TODO 보너스 메시지를 유동적으로 출력할 수 있도록 변경 필요함
    TAKE_BONUS_MESSAGE(", 보너스 볼 일치"),
    BUYING_COUNT_MESSAGE("%d개를 구매했습니다."),
    WIN_STATICS_HEADER_MESSAGE("당첨 통계\n---"),
    WIN_1ST_MESSAGE("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    // TODO 게터이외에 메시지를 이용하는 메서드 구현이 필요함
}
