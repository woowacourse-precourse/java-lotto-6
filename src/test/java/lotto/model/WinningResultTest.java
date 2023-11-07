package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    WinningResult winningResult;

    @BeforeEach
    void setWinningResult() {
        winningResult = new WinningResult();
    }

    @DisplayName("등수의 갯수를 저장할 수 있고, 가져올 수 있다.")
    @Test
    void plusLottoPlace() {
        //given
        LottoPlace calculatedLottoPlace = LottoPlace.THIRD;
        winningResult.plusLottoPlace(calculatedLottoPlace);

        //when
        Integer placeCount = winningResult.getPlaceCount(calculatedLottoPlace);

        assertThat(placeCount).isEqualTo(1);
    }


    @DisplayName("전체 당첨금액을 계산할 수 있다.")
    void caculateTotalRevenue() {
        //given
        winningResult.plusLottoPlace(LottoPlace.FIFTH);
        winningResult.plusLottoPlace(LottoPlace.FIFTH);
        winningResult.plusLottoPlace(LottoPlace.FOURTH);

        Money totalRevenue = winningResult.calculateTotalRevenue();
        Money expected = new Money("60000");

        assertThat(totalRevenue).satisfies(totalRevenue::equals);
    }
}
