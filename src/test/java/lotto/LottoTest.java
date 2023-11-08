package lotto;

import java.util.ArrayList;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    final LottoService lottoService = new LottoService();
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

    @DisplayName("로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputPurchasePriceByDifferentUnit() {
        final String purchasePrice = "1500";

        assertThatThrownBy(() -> lottoService.checkLottoAmount(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 맞는 로또 수량 확인")
    @Test
    void correctLottoAmountByPurchasePrice() {
        final String purchasePrice = "5000";
        final int expectedLottoAmount = 5;

        final int actualLottoAmount = lottoService.checkLottoAmount(purchasePrice);

        assertEquals(expectedLottoAmount, actualLottoAmount,"구입 금액에 맞게 로또 수량이 정해져야 한다.");
    }

    @DisplayName("당첨 로또 번호가 1~45사이의 수가 아니면 예외가 발생한다.")
    @Test
    void createLottoByCorrectNumber() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1,2,3,4,5,48));

        assertThatThrownBy(() -> lottoService.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 수에 맞는 로또 발행 여부 확인")
    @Test
    void createLottosByLottoAmount() {
        List<Lotto> lottos = new ArrayList<>();
        final int lottoAmount = 5;

        lottos = lottoService.generateLottos(lottoAmount, lottos);

        assertThat(lottos.size()).isEqualTo(5);
    }
}