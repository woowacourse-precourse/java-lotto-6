package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static lotto.type.LottoProperty.LOTTO_PRICE;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoAmountByNotNumber() {
        assertThatThrownBy(() -> new LottoAmount("check"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1보다 작은 숫자면 예외가 발생한다.")
    @Test
    void createLottoAmountByZero() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new LottoAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000의 배수가 이니면 예외가 발생한다.")
    @Test
    void createLottoAmountByNotThousandMultiple() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new LottoAmount("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
