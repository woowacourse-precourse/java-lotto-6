package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
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
    void createLottoListTest(Integer lottoCount) {
        // given
        List<Integer> randomNumbers = lottoService.createRandomNumbers();
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        // when
        IntStream.range(0, lottoCount)
                .forEach(i -> purchasedLotto.addLotto(new Lotto(randomNumbers)));

        // then
        assertEquals(purchasedLotto.getLottos().size(), lottoCount);
    }

    @DisplayName("나머지가 발생하는 가격이 입력되었을 때, 예외처리를 하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 888, 1950, 2350})
    void invalidInputMoneyTest(Integer inputMoney) {
        // given & when & then
        assertThatThrownBy(
                () -> lottoService.purchaseLottoWithValidPrice(inputMoney))
                .isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("0이 입력되었을 때, 예외처리를 하는지")
    @Test
    void invalidInputMoneyZeroTest() {
        // given
        Integer inputMoney = 0;

        // when & then
        assertThatThrownBy(
                () -> lottoService.purchaseLottoWithValidPrice(inputMoney))
                .isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("생성한 번호를 오름차순으로 정렬하는지")
    @Test
    void createRandomNumbersSortTest() {
        // given & when
        List<Integer> createdNumbers = lottoService.createRandomNumbers();

        // then
        for (int i = 0; i < createdNumbers.size()-1; i++) {
            assertThat(createdNumbers.get(i)).isLessThanOrEqualTo(createdNumbers.get(i+1));
        }
    }
}