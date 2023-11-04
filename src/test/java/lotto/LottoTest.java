package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Disabled
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Disabled
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500a", "천 원", "1장"})
    void createPurchaseAmountByNaN(String amount) {
        LottoPurchase lottoPurchase = new LottoPurchase();

        assertThatThrownBy(() -> lottoPurchase.setLottoPurchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500", "1900", "1000.4", "-1000.4"})
    void createPurchaseAmountIndivisibleBy1000(String amount) {
        LottoPurchase lottoPurchase = new LottoPurchase();

        assertThatThrownBy(() -> lottoPurchase.setLottoPurchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("구입 금액이 '-3,000'과 같은 음수이거나 0이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "-4000"})
    void createPurchaseAmountByNonPositiveInteger(String amount) {
        LottoPurchase lottoPurchase = new LottoPurchase();

        assertThatThrownBy(() -> lottoPurchase.setLottoPurchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 구입 금액은 1,000원입니다.");
    }

    @DisplayName("로또 번호가 정수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0.1", "1번", "자동", "-0.9"})
    void createWinningNumberByNonInteger(String number) {
        WinningNumber winningNumber = new WinningNumber();

        assertThatThrownBy(() -> winningNumber.setWinningNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningNumberBySevenNumber() {
        WinningNumber winningNumber = new WinningNumber();

        assertThatThrownBy(() -> winningNumber.setWinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개를 입력하셔야 합니다.");
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRange() {
        WinningNumber winningNumber = new WinningNumber();

        assertThatThrownBy(() -> winningNumber.setWinningNumber("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}