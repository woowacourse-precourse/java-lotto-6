package lotto.game;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    @Test
    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void createMachineByValidateMoneyAmount() {
        assertThatThrownBy(() -> new Machine(3200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액에 맞추어 로또를 생산하여 반환한다.")
    void createLottosByMoneyAmount() {
        assertThat(new Machine(5000).createLottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또번호와 당첨번호를 확인하여 결과를 반환한다.")
    void createMatchResultTest() {
        List<Lotto> lottos = new ArrayList<>() {
            {
                add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
                add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
            }
        };

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(new Machine(1000).createMatchResult(lottos, winningNumber))
                .isEqualTo(
                        Map.of(
                                2000000000d, 1,
                                30000000d, 1,
                                1500000d, 0,
                                50000d, 0,
                                5000d, 0
                        )
                );
    }

    @Test
    @DisplayName("당첨번호와 로또번호를 비교하여 맞는 개수를 반환한다.")
    void calculateMatchCountResultTest() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1,2,3,7,8,9));
        assertThat(new Machine(2000).getMatchCount(winningNumber, lotto))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("구매금액과 당첨된 로또를 기반으로 총 수익률을 반환한다.")
    void calculateInvestmentResultByMoneyAndMatchResult() {
        Map<Double, Integer> matchResult = Map.of(
                2000000000d, 0,
                30000000d, 0,
                1500000d, 0,
                50000d, 0,
                5000d, 1
        );

        assertThat(new Machine(8000).calculateInvestmentResult(matchResult))
                .isEqualTo(62.5);
    }

}