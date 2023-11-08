package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.Input;
import org.junit.jupiter.api.AfterEach;

public class InputTest {
    Input input = new Input();

    @AfterEach
    private void consoleClose(){
        Console.close();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
