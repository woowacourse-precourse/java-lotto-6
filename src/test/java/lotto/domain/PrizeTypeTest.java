package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTypeTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "MATCH3:3개 일치 (5,000원)", "MATCH4:4개 일치 (50,000원)", "MATCH5:5개 일치 (1,500,000원)",
                    "MATCH5_WITH_BONUS:5개 일치, 보너스 볼 일치 (30,000,000원)", "MATCH6:6개 일치 (2,000,000,000원)"
            },
            delimiter = ':'
    )
    @DisplayName("출력 메시지 생성")
    void createMessage(PrizeType prizeType, String expectedMessage) {
        assertThat(PrizeType.getMessage(prizeType, 0))
                .contains(expectedMessage);
    }
}