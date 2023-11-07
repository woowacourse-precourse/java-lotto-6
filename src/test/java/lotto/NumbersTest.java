package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Numbers.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @DisplayName("로또 번호가 정상적으로 생성된다")
    @Test
    void makeRandomNumber() {
        assertThat(setRandomNumbers().size()).isEqualTo(6);
    }
    @DisplayName("생성된 로또 번호가 구매 장수에 맞춰 저장된다")
    @Test
    void makeLotto() {
        assertThat(makeLottoTicket(5).size()).isEqualTo(5);
    }
}
