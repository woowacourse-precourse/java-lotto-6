package lotto.handler;

import static lotto.generator.RandomNumberGenerator.generateUniqueRandomValues;
import static lotto.message.SystemMessage.OUTPUT_PURCHASE_LOTTO_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.OutputUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputHandlerTest {


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
    @DisplayName("2개의 로또가 있으면, 예상한 출력처럼 출력이 나와야한다.")
    void test(){
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(generateUniqueRandomValues()));
        lottos.add(new Lotto(generateUniqueRandomValues()));

        //when
        OutputHandler.outputLottosInfo(lottos);

        //given
        String expectedOutput = OutputUtil.formatMessageWithNumber(
                OUTPUT_PURCHASE_LOTTO_AMOUNT,lottos.size()) + "\n"
                + lottos.get(0) + "\n"
                + lottos.get(1);

        assertThat(output()).isEqualTo(
                expectedOutput);
    }

    private String output() {
        return captor.toString().trim();
    }

}