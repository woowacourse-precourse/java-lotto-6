package lotto.results.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 당첨 번호에 중복이 있다면 예외를 발생시킨다.")
    @Test
    void 중복된_로또_당첨_번호() {
        String input = "2,2,4,8,16,32\n1,2,4,8,16,32";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Results results = new Results();
        results.insultWinningNumbers();

        assertThat(out.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 당첨 번호에 범위를 벗어난 수가 있다면 예외를 발생시킨다.")
    @Test
    void 범위_밖_로또_당첨_번호() {
        String input = "2,4,8,16,32,64\n1,2,4,8,16,32";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Results results = new Results();
        results.insultWinningNumbers();

        assertThat(out.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 당첨 번호에 숫자가 아닌 입력이 있다면 예외를 발생시킨다.")
    @Test
    void 숫자가_아닌_로또_당첨_번호() {
        String input = "1,2,4,8,16,32b\n1,2,4,8,16,32";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Results results = new Results();
        results.insultWinningNumbers();

        assertThat(out.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 당첨 번호 6자리와 보너스 숫자가 중복된다면 예외를 발생시킨다.")
    @Test
    void 당첨_번호_보너스_번호_중복() {
        String input = "1,2,4,8,16,32\n32\n33";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Results results = new Results();
        results.insultWinningNumbers();
        results.insultBonus();

        assertThat(out.toString()).contains("[ERROR]");
    }

}
