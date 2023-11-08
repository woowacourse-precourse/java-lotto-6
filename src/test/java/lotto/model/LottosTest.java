package lotto.model;

import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottosTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = LottoService.getInstance();
    }


    @ParameterizedTest
    @CsvSource(value = {
            "1000,1",
            "10000,10",
            "8000,8"
    })
    @DisplayName("구매금액에 맞게 로또가 생성됐는지")
    void 구매금엑에_맞게_로또가_생성되는지(int purchaseAmount, int expectLottoNum) throws Exception {
        //given
        //when
        lottoService.makeLottoByPurchaseAmount(purchaseAmount);
        //then
        assertThat(lottoService.getLottoNum()).isEqualTo(expectLottoNum);
    }

}