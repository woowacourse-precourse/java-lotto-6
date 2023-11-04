package lotto.view;

import static lotto.view.InputView.inputData;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @DisplayName("출력테스트")
    @Test
    void 테스트_inputData() {
        //given
        InputStream inputStream = new ByteArrayInputStream("1423".getBytes());
        System.setIn(inputStream);
        String expect = "1423";

        //when
        String input = inputData();

        //then
        assertThat(expect).isEqualTo(input);
    }
}
