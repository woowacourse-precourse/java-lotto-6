package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottosTest {

    private WinningLottos winningLottos;

    @BeforeEach
    void setWinningLottos() {
        //given
        winningLottos = new WinningLottos(Arrays.stream(WinningLotto.values())
                .toList());
    }

    @Test
    @DisplayName("당첨 로또의 총 금액을 조회한다.")
    public void 당첨_로또의_총_금액을_조회한다() {
        //when
        int totalAmounts = winningLottos.getTotalAmounts();

        //then
        int amountsSum = Arrays.stream(WinningLotto.values())
                .map(WinningLotto::getAmounts)
                .mapToInt(Integer::intValue)
                .sum();
        assertThat(totalAmounts).isEqualTo(amountsSum);
    }

    @Test
    @DisplayName("당첨 로또의 종류별 개수를 조회한다.")
    public void 당첨_로또의_종류별_개수를_조회한다() {
        //when
        List<Long> winningLottoCounts = Arrays.stream(WinningLotto.values())
                .map(winningLottos::getWinningLottoCount)
                .toList();

        //then
        assertThat(winningLottoCounts).containsOnly(1L);
    }
}
