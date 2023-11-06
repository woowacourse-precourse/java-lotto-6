package lotto.util;

import static lotto.message.SystemMessage.OUTPUT_PURCHASE_LOTTO_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputUtilTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    @DisplayName("로또의 개수가 주어졌을 때, 헤당 개수와 출력 메시지가 나와야한다.")
    void testOutputLottoAmount() {
        //given
        int amount = 5;

        //when
        OutputUtil.outputLottoAmount(amount);

        //then
        String expectedOutput = String.format(
                OUTPUT_PURCHASE_LOTTO_AMOUNT.getMessage()
                , amount);

        assertThat(output()).isEqualTo(
                expectedOutput
        );
    }

    private String output() {
        return captor.toString().trim();
    }

}