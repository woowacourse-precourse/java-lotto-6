package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @DisplayName("맞은 개수와 보너스 번호 포함 여부로 Result 를 찾기.")
    @Test
    void find() {
        assertAll(
                () -> assertThat(Result.find(6, false)).isEqualTo(Result.SIX_MATCH),
                () -> assertThat(Result.find(5, true)).isEqualTo(Result.FIVE_AND_BONUS_MATCH),
                () -> assertThat(Result.find(5, false)).isEqualTo(Result.FIVE_MATCH),
                () -> assertThat(Result.find(4, false)).isEqualTo(Result.FOUR_MATCH),
                () -> assertThat(Result.find(3, false)).isEqualTo(Result.THREE_MATCH)
        );
    }
}