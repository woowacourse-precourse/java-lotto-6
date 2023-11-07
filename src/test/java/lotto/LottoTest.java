package lotto;

import lotto.lottoUI.ERRORUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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


    // 아래에 추가 테스트 작성 가능

}