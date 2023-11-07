package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Amount;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
	@DisplayName("1000원 단위가 아니면 오류가 발생한다.")
    @Test
    void createAmountNotThousandUnits() {
        assertThatThrownBy(() -> new Amount(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("0만 네자리 이상이더라도 오류가 발생한다.")
    @Test
    void createAmountNotZero() {
        assertThatThrownBy(() -> new Amount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}