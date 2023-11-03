package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @DisplayName("로또 개수만큼의 로또 리스트를 생성하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void createLottoList(Integer lottoCount) {
        // given
        List<Integer> randomNumbers = lottoService.createRandomNumbers();
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        // when
        IntStream.range(0, lottoCount)
                .forEach(i -> purchasedLotto.addLotto(new Lotto(randomNumbers)));

        // then
        assertEquals(purchasedLotto.getLottos().size(), lottoCount);
    }
}