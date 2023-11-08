package lotto.domain;

import lotto.enums.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {
    private LottoPurchase lottoPurchase;

    @BeforeEach
    @Test
    void createLottoPurchase() {
        lottoPurchase = LottoPurchase.valueOf(1000);
        lottoPurchase = LottoPurchase.valueOf("1000");
    }

    @Test
    void createLottoPurchaseByNonNumeric() {
        assertThatThrownBy(() -> LottoPurchase.valueOf("1000j")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
    }


    @Test
    void getAmount() {
        assertThat(lottoPurchase.getAmount()).isEqualTo(1000);
    }

    @Test
    void getNumberOfTickets() {
        assertThat(lottoPurchase.getNumberOfTickets()).isEqualTo(1);
    }

    @DisplayName("구매한 갯수에 맞게 로또 티켓을 발행하는 메소드")
    @Test
    void generateLottoTickets() {
        assertThat(lottoPurchase.generateLottoTickets().getLottoTickets().size()).isEqualTo(1);
    }

    @DisplayName("숫자형이 아닌 문자가 들어오면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByString() {
        assertThatThrownBy(() -> LottoPurchase.valueOf("5wqesad")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
    }

    @DisplayName("양수가 아닌 수가 들어오면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByNegativeNumber() {
        assertThatThrownBy(() -> LottoPurchase.valueOf("0")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        assertThatThrownBy(() -> LottoPurchase.valueOf("-1000")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
    }

    @DisplayName("1,000원 단위가 아닌 수가 들어오면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByNonThousandAmount() {
        assertThatThrownBy(() -> LottoPurchase.valueOf("1200")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_PURCHASE_RULE_INPUT_MESSAGE.getMessage());
    }
}