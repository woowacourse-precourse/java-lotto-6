package lotto.SimpleTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // 표준 출력 스트림을 캡처하기 위해 변경합니다.
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // 테스트가 끝난 후 표준 출력 스트림을 원래대로 복원합니다.
        System.setOut(originalOut);
    }
    //입출력 검증, 문자열[1, 2, 3]이 실제 리스트 자료형을 출력하는것과 동일한지 테스트
    @Test
    public void testSystemOut() {
        // given
        String expectedOutput = "[1, 2, 3]";
        List<Integer> sample = new ArrayList<>();
        sample.add(1);
        sample.add(2);
        sample.add(3);
        // when
        System.out.println(sample);

        // then
        assertThat(outContent.toString().trim())
                .isEqualTo(expectedOutput);
    }

}
