package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrintingMessageTest {

    @DisplayName("int형 매개 변수를 넘겨 주면 포메팅에 맞춰 출력용 메시지를 가져온다.")
    @Test
    void getWithIntegerTypeParameterFormat() {
        // given
        int lottoCount = 10;
        String expectedResult = "\n10개를 구매했습니다.";
        // when, then
        assertThat(PrintingMessage.BUYING_MESSAGE.getWithFormat(lottoCount))
                .isEqualTo(expectedResult);
    }

    @DisplayName("double형 매개 변수를 넘겨 주면 포메팅에 맞춰 출력용 메시지를 가져온다.")
    @Test
    void getWithDoubleTypeParameterFormat() {
        // given
        double profitRate = 62.5;
        String expectedResult = "총 수익률은 62.5%입니다.";
        // when, then
        assertThat(PrintingMessage.PROFIT_MESSAGE.getWithFormat(profitRate))
                .isEqualTo(expectedResult);
    }

    @DisplayName("최종 결과 출력 메시지를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {
            "6:2000000000:1:6개 일치 (2,000,000,000원) - 1개",
            "5:30000000:2:5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
            "5:1500000:3:5개 일치 (1,500,000원) - 3개",
            "4:50000:4:4개 일치 (50,000원) - 4개",
            "3:5000:5:3개 일치 (5,000원) - 5개"
    }, delimiter = ':')
    void getResultWithFormat(int sameCount, long prizeProfit, int prizeCount, String expectedResult) {
        assertThat(PrintingMessage.PRIZE_MESSAGE.getResultWithFormat(sameCount, prizeProfit, prizeCount))
                .isEqualTo(expectedResult);
    }
}