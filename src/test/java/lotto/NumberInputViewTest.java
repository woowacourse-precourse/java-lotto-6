package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class NumberInputViewTest extends NsTest {

    @Nested
    @DisplayName("[InputView Test] - numbers of lotto")
    class parseLottoNumbersTest {

        @Test
        void given_correct_input_when_instance_numberInputView_then_pass_through() {
            // given
            String input = "1,2,3,4,5,6";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            // when
            NumberInputView numberInputView = new NumberInputView();
            // then
            Integer[] numbers = {1, 2, 3, 4, 5, 6};
            List<Integer> expected_output = Arrays.asList(numbers);
            Assertions.assertThat(numberInputView.getValidNumbers()).isEqualTo(expected_output);
            Console.close();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}