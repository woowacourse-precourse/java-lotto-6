package lotto.view;

import static lotto.view.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.view.ErrorMessage.LESS_MONEY;
import static lotto.view.ErrorMessage.NOT_DIVISIBLE_MONEY;
import static lotto.view.ErrorMessage.NOT_EQUAL_NUM_OF_NUMBERS;
import static lotto.view.ErrorMessage.NOT_LIST;
import static lotto.view.ErrorMessage.NOT_NUMBER;
import static lotto.view.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS;
import static lotto.view.OutputView.printErrorMessage;
import static lotto.view.OutputView.printGainPercentage;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printNumOfTickets;
import static lotto.view.OutputView.printSystemMessage;
import static lotto.view.OutputView.printWinningLottosInfo;
import static lotto.view.SystemMessage.ASK_BONUS;
import static lotto.view.SystemMessage.ASK_MONEY;
import static lotto.view.SystemMessage.ASK_WINNING_NUMBERS;
import static lotto.view.SystemMessage.WINNING_RESULT;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Rank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("시스템 메세지 출력 테스트")
    @ParameterizedTest
    @MethodSource("provideSystemMessage")
    void 출력테스트_printSystemMessage(SystemMessage systemMessage) {
        //given
        String expect = systemMessage.getMessage() + "\n";
        //when
        printSystemMessage(systemMessage);
        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    private static Stream<Arguments> provideSystemMessage() {
        return Stream.of(
                Arguments.of(ASK_MONEY),
                Arguments.of(ASK_WINNING_NUMBERS),
                Arguments.of(ASK_BONUS),
                Arguments.of(WINNING_RESULT)
        );
    }

    @DisplayName("에러 메세지 출력 테스트")
    @ParameterizedTest
    @MethodSource("provideErrorMessage")
    void 출력테스트_printErrorMessage(ErrorMessage errorMessage) {
        //given
        String expect = errorMessage.getMessage() + "\n";
        //when
        printErrorMessage(new IllegalArgumentException(errorMessage.getMessage()));
        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    private static Stream<Arguments> provideErrorMessage() {
        return Stream.of(
                Arguments.of(NOT_NUMBER),
                Arguments.of(LESS_MONEY),
                Arguments.of(NOT_DIVISIBLE_MONEY),
                Arguments.of(NOT_LIST),
                Arguments.of(NOT_EQUAL_NUM_OF_NUMBERS),
                Arguments.of(OUT_OF_RANGE_LOTTO_NUMBERS),
                Arguments.of(DUPLICATED_NUMBER)
        );
    }

    @DisplayName("티켓 개수 출력 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 2000000})
    void 출력테스트_printNumOfTickets(long input) {
        //given
        String expect = "\n" + input + "개를 구매했습니다.\n";
        //when
        printNumOfTickets(input);
        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    @DisplayName("로또 번호 출력 테스트")
    @Test
    void 출력테스트_printNumOfTickets() {
        //given
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        String expect = "[1, 2, 3, 4, 5, 6]\n";
        //when
        printLottoNumbers(input);
        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    @DisplayName("당청된 로또 정보 출력 테스트")
    @Test
    void 출력테스트_printWinningLottosInfo() {
        //given
        Rank rank = Rank.SECOND;
        long cnt = 23;
        String expect = rank.getMessage() + " - 23개\n";

        //when
        printWinningLottosInfo(rank, cnt);
        //then
        assertThat(output.toString()).isEqualTo(expect);
    }

    @DisplayName("수익률 출력 테스트")
    @ParameterizedTest
    @ValueSource(doubles = {1.3, 2.2, 3.5, 4.1, 5.9, 2000000.2})
    void 출력테스트_printGainPercentage(double input) {
        //given
        String expect = "총 수익률은 " + input + "%입니다.\n";
        //when
        printGainPercentage(input);
        //then
        assertThat(output.toString()).isEqualTo(expect);
    }
}
