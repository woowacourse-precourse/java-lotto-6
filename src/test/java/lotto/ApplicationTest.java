package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
    }

    @Test
    void 예외_테스트() {
    }

    @Override
    public void runMain() {
    }

    private void run(String money, String answerNumbers, String bonusNumber) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ByteArrayInputStream inContent = new ByteArrayInputStream(
                String.format("%s%n%s%n%s%n", money, answerNumbers, bonusNumber).getBytes()
        );
        System.setIn(inContent);

        Application.main(new String[]{});

        System.setIn(System.in);
        System.setOut(System.out);

        String output = outContent.toString();
        System.out.print(output);
    }

    private void runException(String input) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        Application.main(new String[]{});

        System.setIn(System.in);
        System.setOut(System.out);

        String output = outContent.toString();
        assertThat(output).contains(ERROR_MESSAGE);
    }
}
