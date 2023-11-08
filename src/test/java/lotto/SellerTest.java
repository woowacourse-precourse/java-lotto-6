package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.global.Prize;
import lotto.global.helper.SellerHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class SellerTest {


    @DisplayName("구입한 로또 번호와 당첨 번호를 비교하여 결과를 기록한다.")
    @Test
    void recordResultWithPrize() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 5, 9, 23, 28, 37)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        Result result = SellerHelper.compareAndRecord(lottos, new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(result.getWinCount(Prize.FIRST)).isEqualTo(1);
        assertThat(result.getWinCount(Prize.SECOND)).isEqualTo(1);
        assertThat(result.getWinCount(Prize.THIRD)).isEqualTo(0);
        assertThat(result.getWinCount(Prize.FORTH)).isEqualTo(1);
        assertThat(result.getWinCount(Prize.FIFTH)).isEqualTo(1);
    }

    @DisplayName("총 당첨 금액과 구입한 금액을 비교하여 수익률을 계산한다.")
    @Test
    void calculateYieldRate() {
        assertThat(SellerHelper.calculateYieldRate(10000, 2000))
                .isEqualTo(500);
        assertThat(SellerHelper.calculateYieldRate(2000, 10000))
                .isEqualTo(20);
        assertThat(SellerHelper.calculateYieldRate(2000, 11000))
                .isEqualTo(18.2);
    }
}
