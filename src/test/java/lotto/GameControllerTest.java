package lotto;

import static lotto.enums.PrizeRank.FIFTH;
import static lotto.enums.PrizeRank.FIRST;
import static lotto.enums.PrizeRank.FOURTH;
import static lotto.enums.PrizeRank.SECOND;
import static lotto.enums.PrizeRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.controller.GameController;
import lotto.model.Lotto;
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

    @DisplayName("로또와 일치하는 숫자 개수 반환")
    @ParameterizedTest(name = "{index}: {1}" + "반환")
    @MethodSource("ticketList")
    void returnMatchNumberAmount(List<Integer> list, int matchNumberAmount) {
        assertThat(gameController.matchNumberAmount(list, VALID_LOTTO.getNumbers()))
                .isEqualTo(matchNumberAmount);
    }

    @DisplayName("일치하는 숫자 개수에 따른 등수 반환")
    @ParameterizedTest(name = "{index}: {2}" + "등 반환")
    @MethodSource("ticketList")
    void returnRank(List<Integer> list, int matchNumberAmount, int rank) {
        GameController gameController = new GameController();

        int result = gameController.getRank(list, matchNumberAmount, VALID_BONUS_NUMBER);

        assertThat(rank).isEqualTo(result);
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
                Arguments.of(VALID_FIFTH_PRIZE_TICKET, FIFTH.matchCondition(), 5),
                Arguments.of(VALID_FOURTH_PRIZE_TICKET, FOURTH.matchCondition(), 4),
                Arguments.of(VALID_THIRD_PRIZE_TICKET, THIRD.matchCondition(), 3),
                Arguments.of(VALID_SECOND_PRIZE_TICKET, SECOND.matchCondition(), 2),
                Arguments.of(VALID_FIRST_PRIZE_TICKET, FIRST.matchCondition(), 1)
        );
    }
}
