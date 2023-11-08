package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRamdomNumbersTest {

    @DisplayName("구입금액에 따른 로또 번호 개수 테스트")
    @Test
    void 랜덤_로또_번호_생성_테스트() {
        //given
        LottoRamdomNumbers lottoRamdomNumbers = new LottoRamdomNumbers();
        String purchaseAmount = "8000";
        //when
        List<Lotto> lottoNumbers = lottoRamdomNumbers.generateRandomLottoNumbers(purchaseAmount);

        //then
        assertThat(lottoNumbers.size()).isEqualTo(8);
    }
}