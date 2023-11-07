package lotto;

import lotto.lottoUI.ERRORUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoWithLessThanSixNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoWithInvalidNumbers() {
        // 로또 번호가 0부터 45 사이가 아닌 경우에 대한 예외 테스트
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        // 로또 번호가 1부터 45 사이가 아닌 경우에 대한 예외 테스트
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 47, 48)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수일 경우 예외가 발생한다.")
    @Test
    void purchaseWithNegativeAmount() {
        assertThatThrownBy(() -> {
            LottoPurchase.Set_amountWithNegativeAmount();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERRORUI.InputNegativeError());
    }

    @DisplayName("구매금액이 천의 배수가 아닐 경우 예외가 발생한다.")
    @Test
    void purchaseWithMultiplesOfThousand() {
        assertThatThrownBy(() -> {
            LottoPurchase.Set_amountWithMultiplesOfThousand();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERRORUI.MultipleOfThousandError());
    }

    @DisplayName("로또 번호를 랜덤으로 추가하는지 테스트한다.")
    @Test
    void generateLotto_shouldGenerate6UniqueNumbers() {
        // Arrange
        LottoPublisher lottoPublisher = new LottoPublisher(1000);
        int count = 1; // 1장의 로또만 생성

        // Act
        List<List<Integer>> lottos = LottoPublisher.LottoSixNumber(count);

        // Assert
        assertEquals(count, lottos.size());
        List<Integer> generatedLotto = lottos.get(0);
        assertEquals(6, generatedLotto.size());
    }

    @DisplayName("구매한 티켓의 장수가 나오는지 테스트한다.")
    @Test
    void generateLottoTicketsBasedOnPurchaseAmount() {
        // Arrange
        int purchaseAmount = 5000; // 5000원의 구매 금액

        LottoPublisher lottoPublisher = new LottoPublisher(purchaseAmount);

        int NumberOfLotto = LottoPublisher.getPublish_num();

        int expectedTicketCount = purchaseAmount / LottoPublisher.Lotto_price;

        assertEquals(expectedTicketCount, NumberOfLotto);
    }

    // 아래에 추가 테스트 작성 가능

}