package lotto;

import lotto.model.domain.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RefereeTest {

    private static final String ERROR_MESSAGE1 = "[ERROR] 잘못된 랭킹입니다. 랭킹은 1등부터 5등 사이여야 합니다.";
    private static final String ERROR_MESSAGE2 = "[ERROR] 잘못된 값입니다. 0으로 나눌 수 없습니다.";

    @DisplayName("로또 랭킹이 1등 ~ 5등이 아닌 다른 등수가 산출될경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 100})
    void invalidateLottoRankingLevel(int input) {
        assertThatThrownBy(() -> {
            Referee referee = new Referee(List.of(1, 2, 3, 4, 5, 6), 7);
            referee.increaseCountForRank(input);

        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE1);
    }

    @DisplayName("수익률 계산 시 분모 값(로또 금액)이 0이하로 계산될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void invalidateDivideByZero(int input) {
        assertThatThrownBy(() -> {
            Referee referee = new Referee(List.of(1, 2, 3, 4, 5, 6), 7);
            referee.calculateLottoBenefit(input);

        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE2);
    }
}
