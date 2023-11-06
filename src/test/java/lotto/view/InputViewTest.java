package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.OrderAmount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private final InputStream systemIn = System.in;

    private void input(String inputData) {
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
    }

    @BeforeEach
    public void init() {
        System.setIn(systemIn);
    }

    @AfterEach
    public void afterInit() {
        Console.close();
    }
    @Test
    @DisplayName("로또 금액을 정상적인 가격으로 입력")
    void orderNormalPrice(){
        input("8000");
        int order = InputView.makeOrder();
        assertThat(order).isEqualTo(8000);
    }

}