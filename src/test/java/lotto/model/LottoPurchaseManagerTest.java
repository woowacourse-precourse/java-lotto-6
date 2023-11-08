package lotto.model;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.MAX_LOTTO_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseManagerTest {
    @DisplayName("유효한 금액")
    @Test
    void 유효한_금액() {
        assertDoesNotThrow(() -> LottoPurchaseManager.createLottoPurchaseManager("10000"));
    }

    @DisplayName("음수 금액일 경우 예외가 발생한다")
    @Test
    void 음수_금액_오류() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("-100"));
        assertThat(exception).hasMessage(ErrorMessages.NO_MONEY.toString());
    }

    @DisplayName("0원 금액일 경우 예외가 발생한다")
    @Test
    void zero_원_금액_오류() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("0"));
        assertThat(exception).hasMessage(ErrorMessages.NO_MONEY.toString());
    }

    @DisplayName("로또 최대 개수를 초과하는 금액일 경우 예외가 발생한다")
    @Test
    void 최대_금액_초과_오류() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoPurchaseManager.createLottoPurchaseManager(String.valueOf(BASE_LOTTO_PRICE*(MAX_LOTTO_COUNT+1))));
        assertThat(exception).hasMessage(ErrorMessages.TOO_MANY_LOTTOS.toString());
    }

    @DisplayName("단위 오류일 경우 예외가 발생한다")
    @Test
    void 단위_오류() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("5500"));
        assertThat(exception).hasMessage(ErrorMessages.UNIT_BASE_PRICE.toString());
    }

    @DisplayName("문자열 금액 오류일 경우 예외가 발생한다")
    @Test
    void 문자열_오류() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("abc"));
        assertThat(exception).hasMessage(ErrorMessages.NOT_INTEGER.toString());
    }
}
