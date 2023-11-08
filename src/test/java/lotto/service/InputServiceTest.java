package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputServiceTest {

    @Test
    @DisplayName("로또 구입 금액을 입력받는 기능.")
    public void input1() {
        InputService inputService = new InputService();
        String input = "14000";

        inputService.readPrice(input);
        Assertions.assertThat(inputService.price).isEqualTo("14000");
    }

}
