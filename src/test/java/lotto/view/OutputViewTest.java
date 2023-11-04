package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp(){
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @DisplayName("로또를 몇개 구매 했는지 출력한다.")
    @Test
    void printPurchaseMessage(){
        //given
        OutputView outputView = new OutputView();
        int quantity = 8;

        //when
        outputView.printPurchaseMessage(quantity);

        //then
        Assertions.assertThat(output.toString()).contains("8개를 구매했습니다.");
    }

}