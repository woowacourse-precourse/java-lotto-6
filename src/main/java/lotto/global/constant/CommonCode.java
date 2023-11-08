package lotto.global.constant;

/**
 * @author yoonho
 * @since 2023.11.08
 */
public record CommonCode() {
    public static final Integer BUY_MIN_UNIT = 1000;        // 로또구입금액 최소단위
    public static final Integer MIN_LOTTO_NUM = 1;          // 최소 로또번호
    public static final Integer MAX_LOTTO_NUM = 45;         // 최대 로또번호
    public static final Integer LOTTO_NUM_COUNT = 6;        // 한게임당 로또번호 개수

    // 당첨통계 템플릿
    public static final String LOTTO_REPORT_TEMPLATE = """
                        
            당첨통계
            ---
            3개 일치 (5,000원) - %s개
            4개 일치 (50,000원) - %s개
            5개 일치 (1,500,000원) - %s개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
            6개 일치 (2,000,000,000원) - %s개
            총 수익률은 %s%%입니다.
            """;
}