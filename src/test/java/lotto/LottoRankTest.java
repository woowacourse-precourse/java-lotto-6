package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoRankTest {

    @DisplayName("LottoRank.findRank 테스트")
    @Nested
    class findRankTests {
        @DisplayName("맞힌 번호 개수와 보너스 번호 유무로 몇 등인지 검증한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "3:true:FIFTH",
                "4:true:FOURTH",
                "5:false:THIRD",
                "5:true:SECOND",
                "6:true:FIRST",
                "6:false:FIRST",
        },delimiter = ':')
        void 일치하는_개수와_보너스번호로_몇등인지_검증(int inputMatchingCount,String inputHasBonuseNumber,String expectedRank) {
            boolean hasBonuseNumber = Boolean.parseBoolean(inputHasBonuseNumber);

            LottoRank rank = LottoRank.findRank(inputMatchingCount, hasBonuseNumber);

            assertThat(rank.name()).isEqualTo(expectedRank);
        }

        @DisplayName("맞힌 번호 개수와 일치하는 Rank가 없을 경우 예외가 발생한다.")
        @ParameterizedTest
        @CsvSource(value = {
                "7: 맞힌 개수와 일치하는 Rank가 없습니다",
                "1: 맞힌 개수와 일치하는 Rank가 없습니다",
                "2: 맞힌 개수와 일치하는 Rank가 없습니다",
                "20: 맞힌 개수와 일치하는 Rank가 없습니다",
                "13: 맞힌 개수와 일치하는 Rank가 없습니다",
        },delimiter = ':')
        void 일치하는_Rank가_없을_경우_예외(int inputMatchingCount,String expectedErrorMessage) {
            assertThatThrownBy(() -> LottoRank.findRank(inputMatchingCount, true))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(expectedErrorMessage);
        }
    }
}
