package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningRankTest {

    @ParameterizedTest(name = "맞춘 개수 : {0}, 보너스 일치 여부 {1}, 예상 등수 : {2}")
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH",
            "3,false,FIFTH", "2,true,NOTHING"})
    @DisplayName("맞춘 공의 횟수와 보너스 일치 여부를 통해 등수를 판단할 수 있다")
    void fromTest(int countOfCorrect, boolean isBonusCorrect, WinningRank expected) {

        WinningRank actual = WinningRank.from(countOfCorrect, isBonusCorrect);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "맞춘 개수 : {0}")
    @CsvSource({"-1", "7"})
    @DisplayName("맞춘 공의 개수가 6개 보다 크거나 0개 보다 작으면 예외가 발생한다")
    void fromTest_whenCountOfCorrectIsOutOfRange(int countOfCorrect) {
        boolean isBonusCorrect = false;

        assertThatThrownBy(() -> WinningRank.from(countOfCorrect, isBonusCorrect))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("맞춘 숫자의 수는 0 이상 6 이하이어야 합니다");
    }
}
