package lotto;

import static lotto.enums.ExceptionCase.INPUT_TYPE_MISMATCH;
import static lotto.enums.ExceptionCase.NUMBER_DUPLICATION;
import static lotto.enums.ExceptionCase.NUMBER_OUT_OF_RANGE;
import static lotto.enums.PrizeRank.FIFTH;
import static lotto.enums.PrizeRank.FIRST;
import static lotto.enums.PrizeRank.FOURTH;
import static lotto.enums.PrizeRank.SECOND;
import static lotto.enums.PrizeRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.controller.GameController;
import lotto.model.Lotto;
import lotto.validator.PrizeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameControllerTest {
    private static final GameController gameController = new GameController();
    private static final Lotto VALID_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final List<Integer> VALID_FIFTH_PRIZE_TICKET = List.of(1, 2, 3, 7, 8, 9);
    private static final List<Integer> VALID_FOURTH_PRIZE_TICKET = List.of(1, 2, 3, 4, 8, 9);
    private static final List<Integer> VALID_THIRD_PRIZE_TICKET = List.of(1, 2, 3, 4, 5, 8);
    private static final List<Integer> VALID_SECOND_PRIZE_TICKET = List.of(1, 2, 3, 4, 5, 9);
    private static final List<Integer> VALID_FIRST_PRIZE_TICKET = List.of(1, 2, 3, 4, 5, 6);
    private static final int VALID_BONUS_NUMBER = 9;

    @DisplayName("보너스 번호가 양의 정수가 아니면 예외가 발생한다")
    @Test
    void createBonusNumberNegativeInt() {
        assertThatThrownBy(() -> PrizeValidator.validateBonusNumber("-50", VALID_LOTTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TYPE_MISMATCH.message());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> PrizeValidator.validateBonusNumber("1", VALID_LOTTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_DUPLICATION.message());
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void createBonusNumberByOverRange() {
        assertThatThrownBy(() -> PrizeValidator.validateBonusNumber("46", VALID_LOTTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE.message());
    }

    @DisplayName("로또와 일치하는 숫자 개수 반환")
    @ParameterizedTest(name = "{index}: {1}" + "반환")
    @MethodSource("ticketList")
    void returnMatchNumberAmount(List<Integer> list, int matchNumberAmount) {
        assertThat(gameController.matchNumberAmount(list, VALID_LOTTO.getNumbers()))
                .isEqualTo(matchNumberAmount);
    }

    @DisplayName("등수에 따른 금액 반환")
    @ParameterizedTest(name = "{index}: {2}" + "반환")
    @MethodSource("ticketList")
    void returnPrizeMoney(List<Integer> list, int matchNumberAmount, int prizeMoney) {
        GameController gameController = new GameController();

        gameController.addPrize(list, matchNumberAmount, VALID_BONUS_NUMBER);

        assertThat(prizeMoney).isEqualTo(gameController.getTotalPrizeMoney());
    }

    @DisplayName("당첨 금액에 따른 수익률 반환")
    @Test
    void returnReturnRate() {
        int count = 7;
        int earnedMoney = 5000;
        BigDecimal estimatedReturnRate = new BigDecimal("71.4");

        BigDecimal resultReturnRate = gameController.calculateReturnRate(count, earnedMoney);

        assertThat(resultReturnRate).isEqualTo(estimatedReturnRate);
    }

    static Stream<Arguments> ticketList() {
        return Stream.of(
                Arguments.of(VALID_FIFTH_PRIZE_TICKET, FIFTH.matchCondition(), FIFTH.prize()),
                Arguments.of(VALID_FOURTH_PRIZE_TICKET, FOURTH.matchCondition(), FOURTH.prize()),
                Arguments.of(VALID_THIRD_PRIZE_TICKET, THIRD.matchCondition(), THIRD.prize()),
                Arguments.of(VALID_SECOND_PRIZE_TICKET, SECOND.matchCondition(), SECOND.prize()),
                Arguments.of(VALID_FIRST_PRIZE_TICKET, FIRST.matchCondition(), FIRST.prize())
        );
    }
}
