package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    LottoController lottoController = new LottoController(new LottoService(), InputView.getInstance(),
            OutputView.getInstance());
    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    public LottoControllerTest() {
        System.setIn(createInputStream());
    }

    @BeforeEach
    void setUp() {
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private String getOutput(){
        return outputStream.toString();
    }

    private InputStream createInputStream() {
        List<InputStream> inputStreams = Arrays.asList(
                createUserInput("8000\n"),
                createUserInput("1,2,3,4,5,6\n"),
                createUserInput("7\n")
        );
        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

    @Test
    void playLottoGame() {
        lottoController.playLottoGame();
        Assertions.assertThat(getOutput()).contains(
                "구입금액을 입력해 주세요.",
                "개를 구매했습니다.",
                "당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요.",
                "당첨 통계",
                "총 수익률은");
    }

    public static InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }


}