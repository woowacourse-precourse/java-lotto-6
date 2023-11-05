package study;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SystemInTest {

    @Test
    void 리드라인_테스트() {

        String tmp = "123";
        byte[] bytes = tmp.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);

        String read = Console.readLine();

        Assertions.assertThat(read).isEqualTo("123");
    }
}
