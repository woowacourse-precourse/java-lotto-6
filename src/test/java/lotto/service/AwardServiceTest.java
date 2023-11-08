package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Award;
import lotto.domain.BonusNumber;
import lotto.domain.ClientLotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AwardServiceTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("makeAwards 테스트")
    class MakeAwards {
        @ParameterizedTest
        @MethodSource("awardProvider")
        void 당첨로또는_로또번호_개수를_준수한다(List<Award> expected, String money, String winning, String bonus) {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        ClientLotto clientLotto = new ClientLotto();
                        WinningLotto winningLotto = new WinningLotto();
                        BonusNumber bonusNumber = new BonusNumber();
                        final byte[] buf = String.join("\n", money, winning, bonus).getBytes();

                        System.setIn(new ByteArrayInputStream(buf));
                        assertThat(AwardService.makeAwards(winningLotto, clientLotto, bonusNumber)).isEqualTo(expected);
                    },
                    List.of(1, 2, 3, 4, 5, 6)
            );
        }
    }

    private Stream<Arguments> awardProvider() {
        return Stream.of(
                Arguments.of(List.of(Award.ZERO), "1000", "7,8,9,10,11,12", "13"),
                Arguments.of(List.of(Award.ONE), "1000", "4,7,8,9,10,11", "12"),
                Arguments.of(List.of(Award.TWO), "1000", "1,2,7,8,9,10", "11"),
                Arguments.of(List.of(Award.THREE), "1000", "1,2,3,7,8,9", "10"),
                Arguments.of(List.of(Award.FOUR), "1000", "1,2,3,4,7,8", "9"),
                Arguments.of(List.of(Award.FIVE), "1000", "1,2,3,4,5,7", "8"),
                Arguments.of(List.of(Award.FIVE_BONUS), "1000", "1,2,3,4,5,8", "6"),
                Arguments.of(List.of(Award.SIX), "1000", "1,2,3,4,5,6", "7")
        );
    }
}