package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {


    @AfterEach
    public void consoleClose() {
        Console.close();
    }


    @Test
    @DisplayName("당첨 번호 입력 - 성공")
    public void input_winner_numbers_success() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        String input = "11,22,33,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> inputNumbers = Arrays.stream(input.split(",")).toList();

        //when
        winningNumber.inputWinnerNumbers();

        //then
        IntStream.range(0, winningNumber.getWinnerNumbers().size())
                .forEach(i -> assertThat(winningNumber.getWinnerNumbers().get(i))
                        .isEqualTo(Integer.parseInt(inputNumbers.get(i))));
    }


    @Test
    @DisplayName("보너스 번호 입력 - 성공")
    public void input_bonus_number_success() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        winningNumber.inputBonusNum();

        //then
        assertThat(winningNumber.getBonusNumber()).isEqualTo(Integer.parseInt(input));
    }


    @Test
    @DisplayName("당첨 번호 입력(6개가 아닐 때) - 실패 후 성공")
    public void input_winning_numbers_no_size_fail() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        ByteArrayOutputStream outputStream = initOutputStream();
        String input = "11,22,33,4,5\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        winningNumber.inputWinnerNumbers();

        //then
        assertThat(outputStream.toString()).contains(ErrorMessage.NO_COUNT_LOTTO_NUMBERS.getMessage());
        IntStream.range(0, winningNumber.getWinnerNumbers().size())
                .forEach(i -> assertThat(winningNumber.getWinnerNumbers().get(i))
                        .isEqualTo(inputNumbers.get(i)));
    }


    @Test
    @DisplayName("당첨 번호 입력(숫자가 아닐 때) - 실패 후 성공")
    public void input_winning_numbers_no_digit_fail() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        ByteArrayOutputStream outputStream = initOutputStream();
        String input = "1,2,soa,23,fwo,6\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        winningNumber.inputWinnerNumbers();

        //then
        assertThat(outputStream.toString()).contains(ErrorMessage.NO_PARSE_TO_NUMBER.getMessage());
        IntStream.range(0, winningNumber.getWinnerNumbers().size())
                .forEach(i -> assertThat(winningNumber.getWinnerNumbers().get(i))
                        .isEqualTo(inputNumbers.get(i)));
    }


    @Test
    @DisplayName("당첨 번호 입력(범위에서 벗어날 때) - 실패 후 성공")
    public void input_winning_numbers_out_range_fail() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        ByteArrayOutputStream outputStream = initOutputStream();
        String input = "1,2,50,23,6,7\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        winningNumber.inputWinnerNumbers();

        //then
        assertThat(outputStream.toString()).contains(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        IntStream.range(0, winningNumber.getWinnerNumbers().size())
                .forEach(i -> assertThat(winningNumber.getWinnerNumbers().get(i))
                        .isEqualTo(inputNumbers.get(i)));
    }

    @Test
    @DisplayName("당첨 번호 입력(중복된 번호가 있을 때) - 실패 후 성공")
    public void input_winning_numbers_duplicate_fail() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        ByteArrayOutputStream outputStream = initOutputStream();
        String input = "1,2,3,5,5,7\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        winningNumber.inputWinnerNumbers();

        //then
        assertThat(outputStream.toString()).contains(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        IntStream.range(0, winningNumber.getWinnerNumbers().size())
                .forEach(i -> assertThat(winningNumber.getWinnerNumbers().get(i))
                        .isEqualTo(inputNumbers.get(i)));
    }


    @Test
    @DisplayName("보너스 번호 입력(범위에서 벗어날 때 & 숫자가 아닌 문자 입력) - 실패 후 성공")
    public void input_bonus_num_out_range_no_digit_fail() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        ByteArrayOutputStream outputStream = initOutputStream();
        String input = "60\nNoDigit\n5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        winningNumber.inputBonusNum();

        //then
        assertThat(outputStream.toString()).contains(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        assertThat(outputStream.toString()).contains(ErrorMessage.NO_PARSE_TO_NUMBER.getMessage());
        assertThat(winningNumber.getBonusNumber()).isEqualTo(5);
    }


    @Test
    @DisplayName("보너스 번호 입력(중복된 번호가 있을 때) - 실패 후 성공")
    public void input_bonus_num_duplicate_fail() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        ByteArrayOutputStream outputStream = initOutputStream();
        String input = "1,2,3,4,5,6\n6\n20";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        winningNumber.inputWinnerNumbers();
        winningNumber.inputBonusNum();

        //then
        assertThat(outputStream.toString()).contains(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        assertThat(winningNumber.getBonusNumber()).isEqualTo(20);
    }


    private ByteArrayOutputStream initOutputStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

}