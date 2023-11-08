package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutputViewTest {
    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 일반_출력_테스트() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        String str = "테스트입니다.";
        OutputView.print(str);

        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo(str);
    }

    @Test
    void 줄바꾸기_출력_테스트() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        String str = "테스트입니다.\n";
        OutputView.print(str);

        Assertions.assertThat(byteArrayOutputStream.toString()).isEqualTo(str);
    }
}