package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class LottoControllerTest {
    ByteArrayOutputStream outputStream;
    LottoController lottoController;
    LottoStorage lottoStorage;
    LottoService lottoService;
    Communicator communicator;

    @BeforeEach
    void setUp() {
        communicator = new Communicator();
        lottoStorage = new LottoStorage();
        lottoService = new LottoService(lottoStorage);
        lottoController = new LottoController(communicator, lottoService);
    }

    @AfterEach
    void cleanUp() {
        System.setIn(System.in);
        System.setOut(System.out);
        Console.close();
    }

    @Test
    @DisplayName("로또 구입 후 생성된 로또들을 출력한다.")
    void test_Run_PrintLotteriesBought() {
        //given
        String input = "2000";
        setIn(input);
        setOut();

        //when
        lottoController.run();
        String output = output();

        //then
        int numberOfLotteries = new BigDecimal(input).divide(new BigDecimal(1000), RoundingMode.UNNECESSARY)
                .intValueExact();
        assertThat(output).contains("%s개를 구매했습니다.".formatted(numberOfLotteries));
    }

    @Test
    @DisplayName("로또의 생성 번호를 오름차순으로 나열한다.")
    void test_Run_PrintLottoNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    //given
                    String input = "1000";
                    setIn(input);
                    setOut();

                    //when
                    lottoController.run();
                    String output = output();

                    //then
                    assertThat(output).contains("[1, 2, 3, 4, 5, 6]");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("로또의 생성 번호를 로또 수 만큼 출력한다.")
    void test_Run_PrintAllLotteries() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    //given
                    String input = "2000";
                    setIn(input);
                    setOut();

                    //when
                    lottoController.run();
                    String output = output();

                    //then
                    assertThat(output).contains("[1, 2, 3, 4, 5, 6]");
                    assertThat(output).contains("[10, 15, 20, 25, 30, 35]");
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(10, 15, 20, 25, 30, 35)
        );
    }

    void setIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    void setOut() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    String output() {
        System.setOut(new PrintStream(outputStream));
        return outputStream.toString();
    }
}
