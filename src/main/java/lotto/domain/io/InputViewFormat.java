package lotto.domain.io;

public enum InputViewFormat {
    GUIDE_CASH("구입금액을 입력해 주세요."),
    GUIDE_LOTTO_AMOUNT_FORMAT("%s개를 구매했습니다."),
    GUIDE_LOTTO_ANSWER("당첨번호를 입력해 주세요."),
    GUIDE_BONUS_ANSWER("보너스 번호를 입력해 주세요."),
    GUIDE_STATICS("당첨 통계"),
    GUIDE_RESULT_FORMAT("%d개 일치 (%s원) - %d개"),
    GUIDE_RATE_FORMAT("총 수익률은 %.1f%입니다.");

    InputViewFormat(String state) {
    }
}
