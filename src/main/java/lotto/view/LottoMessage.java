package lotto.view;

public enum LottoMessage {
    PURCHASE_MONEY_INPUT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNT("%d개를 구매했습니다."),
    WIN_LOTTO_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),

    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),

    PRINT_LOTTO_RESULT(
            "당첨 통계\n" +
                    "---\n" +
                    "3개 일치 (5,000원) - %d개\n" +
                    "4개 일치 (50,000원) - %d개\n" +
                    "5개 일치 (1,500,000원) - %d개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                    "6개 일치 (2,000,000,000원) - %d개\n" +
                    "총 수익률은 %s%%입니다.\n"
    );

    private String message;

    LottoMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}