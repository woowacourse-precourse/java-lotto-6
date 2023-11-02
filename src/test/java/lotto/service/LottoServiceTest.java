package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("가격을 입력받고 가격만큼 로또를 구매하는지")
    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2", "3000, 3", "4000, 4", "200000000, 200000"})
    void purchaseLottoWithValidPriceTest(Integer inputMoney, Integer expectedLottoCount) {
        // given && when
        Integer lottoCount = lottoService.purchaseLottoWithValidPrice(inputMoney);

        // then
        assertTrue(lottoCount.equals(expectedLottoCount));
    }

}