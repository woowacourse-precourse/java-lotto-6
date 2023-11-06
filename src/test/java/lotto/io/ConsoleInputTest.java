package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.ConsoleTestSuper;
import org.junit.jupiter.api.Test;

class ConsoleInputTest extends ConsoleTestSuper {


    @Test
    void consoleLine() {
        String message = "테스트 문구입니다.";

        String input = enterInput(message);
        setIn(input);
        String userInput = new ConsoleInput().line();

        assertThat(userInput).isEqualTo(message);
    }

    @Test
    void consoleNumber테스트() {
        String testNumberString = "420";
        int testNumber = Integer.parseInt(testNumberString);

        String input = enterInput(testNumberString);
        setIn(input);
        int userInput = new ConsoleInput().number();

        assertThat(userInput).isEqualTo(testNumber);
    }

    @Test
    void 기본consoleNumbers테스트() {
        String testNumberString = "429";
        List<Integer> testNumbers = List.of(4, 2, 9);

        String input = enterInput(testNumberString);
        setIn(input);
        List<Integer> numbers = new ConsoleInput().numbers();

        assertThat(numbers).isEqualTo(testNumbers);
    }

    @Test
    void 구분자가_들어간_consoleNumbers테스트() {
        String testNumberString = "4,2,9";
        List<Integer> testNumbers = List.of(4, 2, 9);

        String input = enterInput(testNumberString);
        setIn(input);
        List<Integer> numbers = new ConsoleInput().numbers(",");

        assertThat(numbers).isEqualTo(testNumbers);
    }

    @Test
    void 기본_consoleStrings_테스트() {
        String testString = "안녕하세요 세상아";
        String[] expectedStrings = {"안", "녕", "하", "세", "요", " ", "세", "상", "아"};

        String input = enterInput(testString);
        setIn(input);
        List<String> actualStringList = new ConsoleInput().strings();

        assertThat(actualStringList).containsExactly(expectedStrings);

    }

    @Test
    void 구분자가주어지는_consoleStrings_테스트() {
        String testString = "안녕하세요,세상아";
        String[] expectedStrings = {"안녕하세요", "세상아"};

        String input = enterInput(testString);
        setIn(input);
        List<String> actualStringList = new ConsoleInput().strings(",");

        assertThat(actualStringList).containsExactly(expectedStrings);

    }

}