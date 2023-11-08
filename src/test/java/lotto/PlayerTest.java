package lotto;

import lotto.controller.LottoMakingController;
import lotto.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @DisplayName("입력 금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void createLotto() {
        int payment = 1234555;
        assertThatThrownBy(() -> new Player(payment)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
