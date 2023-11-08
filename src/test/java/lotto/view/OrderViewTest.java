package lotto.view;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderViewTest {
    private ByteArrayOutputStream outputStreamCaptor;
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setup() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

    @DisplayName("구입할 로또의 금액을 입력하여 문자열을 반환한다.")
    @Test
    void askOrderPriceTest() {
        systemIn("8000");
        String result = OrderView.askOrderPrice();
        assertThat(result).isEqualTo("8000");
    }

    @DisplayName("로또 리스트를 출력한다.")
    @Test
    void printOrderLottosTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(List.of(3, 18, 27, 39, 19, 21))));

        OrderView.printOrderLottos(lottos);
        assertThat(getOutput()).contains(
                "[1, 2, 3, 4, 5, 6]",
                "[3, 18, 27, 39, 19, 21]");

    }
}