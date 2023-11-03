package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;
import lotto.util.FakeNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoStore 클래스")
class LottoStoreTest {

    @DisplayName("올바른 구매 금액에 대한 로또 개수 반환 테스트")
    @Test
    void shouldReturnCorrectLottoCountForValidPurchaseAmount() {
        // given
        LottoStore lottoStore = new LottoStore();
        int purchaseAmount = 6000;

        // when
        int expectedLottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = lottoStore.buyLottos(purchaseAmount);

        // then
        assertThat(lottos).hasSize(expectedLottoCount);
    }

    @DisplayName("유효하지 않은 구매 금액으로 인한 예외 발생 테스트")
    @Test
    void shouldThrowExceptionForInvalidPurchaseAmount() {
        // given
        LottoStore lottoStore = new LottoStore();
        int invalidAmount = 7777;

        // when & then

        assertThatThrownBy(() -> lottoStore.buyLottos(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(new InvalidInputException(ErrorMessage.INVALID_PURCHASE_AMOUNT).getMessage());
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void testBuyLottos() {
        // given
        List<Integer> expectedNumbers = List.of(1, 19, 6, 5, 37, 45);
        LottoStore lottoStore = new LottoStore(new FakeNumbersGenerator(expectedNumbers));
        int purchaseAmount = 1000;

        // when
        List<Lotto> lottos = lottoStore.buyLottos(purchaseAmount);

        // then
        assertThat(lottos).hasSize(1);
        assertThat(lottos.get(0).getNumbers()).isEqualTo(expectedNumbers);
    }
}
