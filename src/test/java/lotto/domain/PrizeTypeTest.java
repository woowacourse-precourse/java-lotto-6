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

    @ParameterizedTest
    @CsvSource(
            value = {
                    "MATCH3:5000", "MATCH4:50000", "MATCH5:1500000",
                    "MATCH5_WITH_BONUS:30000000", "MATCH6:2000000000"
            },
            delimiter = ':'
    )
    @DisplayName("상금 금액 확인")
    void prize(PrizeType prizeType, int expectedPrize) {
        assertThat(prizeType.getPrize())
                .isEqualTo(expectedPrize);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "MATCH3:3:false", "MATCH4:4:false", "MATCH5:5:false",
                    "MATCH5_WITH_BONUS:5:true", "MATCH6:6:false", "NOT_APPLICABLE:0:false"
            },
            delimiter = ':'
    )
    @DisplayName("당첨번호 일치 개수, 보너스번호와 일치여부에 따른 prizeType 결정")
    void getPrizeType(PrizeType expectedPrizeType, int matchCount, boolean isBonusMatch) {
        assertThat(PrizeType.valueOfMatchCount(matchCount, isBonusMatch))
                .isEqualTo(expectedPrizeType);
    }
}