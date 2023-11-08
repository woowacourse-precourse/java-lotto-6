package lotto.service;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputServiceTest {
    InputService inputService;


    @BeforeEach
    public void init() {
        inputService=new InputService();
    }

    @Test
    @DisplayName("로또 구입 금액을 입력받는 기능.")
    public void input1() {
        String input = "14000";

        inputService.readPrice(input);
        assertThat(inputService.price).isEqualTo("14000");
    }

    @Test
    @DisplayName("당첨번호를 입력받는기능.")
    public void input2() {
        String input = "1,2,3,4,5,6";
        inputService.readAnswer(input);
        assertThat(inputService.answer).isEqualTo("1,2,3,4,5,6");

    }

}
