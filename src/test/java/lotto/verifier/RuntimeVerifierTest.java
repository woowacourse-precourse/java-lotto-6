package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


public class RuntimeVerifierTest {


    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("checkBonusNumberExistsInWinningLotto 메소드 테스트")
    class CheckBonusNumberExistsInWinningLotto {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 보너스번호가_당첨번호에_포함되는_경우_에러를_발생시키는지_테스트(List<Integer> winningNumbers, int bonus) {

            RuntimeVerifier runtimeVerifier = new RuntimeVerifier();
            Lotto winningLotto1 = new Lotto(winningNumbers);
            WinningLotto winningLotto = new WinningLotto(winningLotto1);
            BonusNumber bonusNumber = new BonusNumber(bonus);

            assertThatThrownBy(() ->
                    runtimeVerifier.checkBonusNumberExistsInWinningLotto(winningLotto, bonusNumber))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_EXISTS_IN_WINNING_LOTTO);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of(7, 8, 9, 10, 11, 12), 7),
                    Arguments.of(List.of(4, 7, 8, 9, 10, 11), 4),
                    Arguments.of(List.of(1, 2, 7, 8, 9, 10), 10)

            );
        }

    }

}