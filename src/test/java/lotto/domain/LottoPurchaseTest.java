package lotto.domain;

import lotto.enums.ErrorEnum;
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
        lottoPurchase = new LottoPurchase(1000);
        lottoPurchase = new LottoPurchase("1000");
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
        assertThatThrownBy(() -> new LottoPurchase("5wqesad")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
    }

    @DisplayName("양수가 아닌 수가 들어오면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByNegativeNumber() {
        assertThatThrownBy(() -> new LottoPurchase("0")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        assertThatThrownBy(() -> new LottoPurchase("-1000")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
    }

    @DisplayName("1,000원 단위가 아닌 수가 들어오면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByNonThousandAmount() {
        assertThatThrownBy(() -> new LottoPurchase("1200")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_THOUSAND_INPUT_MESSAGE.getMessage());
    }
}