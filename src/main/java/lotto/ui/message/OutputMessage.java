package lotto.ui.message;

import lotto.domain.LottoResult;
import lotto.domain.Ranking;

public enum OutputMessage {

    PRINT_LOTTO_COUNT("개를 구매했습니다."),
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

    private final String comment;

    OutputMessage(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }
}
