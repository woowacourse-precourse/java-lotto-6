package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import lotto.constant.WinningAmountConstant;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameServiceTest {
    private static LottoGameService service = new LottoGameService();

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateRateOfReturn() {
        Double rateOfReturn = service.calculateRateOfReturn(1000, 50000);

        assertThat(rateOfReturn).isEqualTo(5000.0);
    }

    @DisplayName("당첨금 총 합 계산 테스트")
    @Test
    void sumWinningAmount() {
        //given
        LinkedHashMap<WinningAmountConstant, Integer> map = new LinkedHashMap<WinningAmountConstant, Integer>();

        map.put(WinningAmountConstant.FIFTH, 3);
        map.put(WinningAmountConstant.FOURTH, 1);
        map.put(WinningAmountConstant.THIRD, 1);
        map.put(WinningAmountConstant.SECOND, 0);
        map.put(WinningAmountConstant.FIRST, 0);

        WinningResult winningResult = new WinningResult(map);

        //when
        int sumAmount = winningResult.calculateWinningAmount();
        //then
        assertThat(sumAmount).isEqualTo(1565000);
    }
}