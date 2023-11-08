package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private static final String PURCHASE_PRICE = "1000";
    private static final String LOTTO_NUM_INPUT = "1,2,3,4,5,6";
    private static final String BONUS_NUM_INPUT = "7";
    private static final String expectedResult =
            "당첨 통계\n"
                    + "---\n"
                    + "3개 일치 (5,000원) - 0개\n"
                    + "4개 일치 (50,000원) - 0개\n"
                    + "5개 일치 (1,500,000원) - 0개\n"
                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                    + "6개 일치 (2,000,000,000원) - 1개\n"
                    + "총 수익률은 200000000.0%입니다.";
    private final OutputStream originalOutputStream = System.out;
    private final InputStream originalInputStream = System.in;
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setup() {
        outputStream = new ByteArrayOutputStream();
        inputStream = new ByteArrayInputStream(
                String.join("\n", PURCHASE_PRICE, LOTTO_NUM_INPUT, BONUS_NUM_INPUT).getBytes());
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
    }

    @AfterEach
    void cleanup() {
        System.setIn(originalInputStream);
        System.setOut(new PrintStream(originalOutputStream));
        Console.close();
    }

    @Test
    @DisplayName("게임을 진행하고 적절한 결과를 출력한다")
    void play() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoController lottoController = new LottoController();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoController.play();

                    assertThat(outputStream.toString()).contains(expectedResult);
                },
                lottoNumbers
        );
    }
}