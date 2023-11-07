package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("등수의 갯수를 저장할 수 있고, 가져올 수 있다.")
    @Test
    void plusLottoPlace() {
        //given
        WinningResult winningResult = new WinningResult();
        LottoPlace calculatedLottoPlace = LottoPlace.THIRD;
        winningResult.plusLottoPlace(calculatedLottoPlace);

        //when
        Integer placeCount = winningResult.getPlaceCount(calculatedLottoPlace);

        assertThat(placeCount).isEqualTo(1);
    }
}
