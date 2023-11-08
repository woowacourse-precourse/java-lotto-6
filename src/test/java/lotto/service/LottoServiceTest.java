package lotto.service;

import static lotto.domain.grade.Grade.FIFTH;
import static lotto.domain.grade.Grade.FIRST;
import static lotto.domain.grade.Grade.FOURTH;
import static lotto.domain.grade.Grade.NONE;
import static lotto.domain.grade.Grade.SECOND;
import static lotto.domain.grade.Grade.THIRD;
import static lotto.utils.LottoConstant.PROFIT_MULTIPLY;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.Result;
import lotto.domain.winning.Winning;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

    @MethodSource("resultProvider")
    @ParameterizedTest
    void 로또_당첨_결과를_반환한다(Lotto lotto, long winningMoney) {
        //Arrange
        LottoService service = LottoService.of();

        int bonusNumber = 7;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Winning winning = Winning.of(winningNumbers, bonusNumber);

        List<Lotto> lottos = List.of(lotto);

        //Act
        Result actual = service.getResult(winning, lottos);

        //Assert
        assertThat(actual.getWinningMoney().longValue()).isEqualTo(winningMoney);
        assertThat(actual.getProfit().getPercentage()).isEqualTo(
                ((double) winningMoney / (lottos.size() * PURCHASE_AMOUNT_UNIT)) * PROFIT_MULTIPLY);
    }


    static Stream<Arguments> resultProvider() {
        return Stream.of(
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), FIRST.getWinningMoney()),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 7)), SECOND.getWinningMoney()),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 5, 8)), THIRD.getWinningMoney()),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 4, 8, 9)), FOURTH.getWinningMoney()),
                Arguments.of(Lotto.of(List.of(1, 2, 3, 8, 9, 10)), FIFTH.getWinningMoney()),
                Arguments.of(Lotto.of(List.of(1, 2, 8, 9, 10, 11)), NONE.getWinningMoney())
        );
    }
}