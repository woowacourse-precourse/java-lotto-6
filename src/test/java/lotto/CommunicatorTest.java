package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommunicatorTest {

    @Test
    @DisplayName("시작 문구 입력을 출력한다.")
    void test_PrintStart() {
        //given
        Communicator communicator = new Communicator();

        //when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        communicator.printStart();
        String output = outputStream.toString();

        //then
        assertThat(output).contains("구입금액을 입력해주세요.");

        //clean
        System.setOut(System.out);
    }
}
