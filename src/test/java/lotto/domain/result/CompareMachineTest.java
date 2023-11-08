package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.MockNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import lotto.domain.win.Bonus;
import lotto.domain.win.WinLotto;
import lotto.option.EqualStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CompareMachineTest {
    private final int INPUT_MONEY = 1000;

    @DisplayName("당첨내역을 제대로 계산하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("validParameters")
    void checkCompareSystem(List<Integer> numbers, int number, EqualStatus equalStatus, int equalNumber) {
        //given
        LottoCount lottoCount = LottoCount.from(INPUT_MONEY);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator(List.of(1, 3, 5, 7, 9, 11)));

        Lotto lotto = new Lotto(numbers);
        Bonus bonus = new Bonus(number);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        //when
        CompareMachine compareMachine = new CompareMachine();
        compareMachine.compare(userLotto, winLotto);

        //then
        assertThat(compareMachine.getWinStatus().get(new LottoResult(equalStatus))).isEqualTo(equalNumber);
    }

    static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, EqualStatus.FOUR_EQUAL, 1),
                Arguments.of(List.of(1, 2, 4, 6, 8, 10), 3, EqualStatus.THREE_EQUAL, 0),
                Arguments.of(List.of(1, 2, 3, 5, 7, 9), 11, EqualStatus.FIVE_AND_BONUS_EQUAL, 1)
        );
    }

    @Test
    @DisplayName("수익률을 제대로 계산하는지 확인한다.")
    void checkCalculateRate() {
        //given
        LottoCount lottoCount = LottoCount.from(INPUT_MONEY);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator(List.of(1, 3, 5, 7, 9, 11)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        //when
        CompareMachine compareMachine = new CompareMachine();
        compareMachine.compare(userLotto, winLotto);

        //then
        assertThat(compareMachine.calculateRate(userLotto)).isEqualTo(5000);
    }
}
