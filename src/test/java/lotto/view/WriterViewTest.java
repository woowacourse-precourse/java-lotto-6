package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WriterViewTest {

    @DisplayName("입력받은 문자가 양의 정수 또는 0이다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "111a", "-1", "-99"})
    void convertToInt(String input) {
        // given
        InputView inputView = new InputView(new TestWriter(input));

        // when then
        Assertions.assertThatThrownBy(inputView::enterMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INTEGER.getMessage());
    }

    @DisplayName("입력받은 문자를 ,로 분할하여 반환할 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoNumberProvider")
    void convertToIntegerList(String input, int count, List<Integer> answer) {
        // given
        InputView inputView = new InputView(new TestWriter(input));

        // when
        List<Integer> lottos = inputView.enterLotto();

        // then
        assertThat(lottos).hasSize(count)
                .isEqualTo(answer);
    }

    static Stream<Arguments> lottoNumberProvider() {
        return Stream.of(
                arguments("7,8,9,10,11,12", 6, List.of(7, 8, 9, 10, 11, 12)),
                arguments("1,7,8,9,10,11", 6, List.of(1, 7, 8, 9, 10, 11)),
                arguments("1,2,7,8,9,10", 6, List.of(1, 2, 7, 8, 9, 10)),
                arguments("1,2,3,7,8,9", 6, List.of(1, 2, 3, 7, 8, 9))
        );
    }

    static class TestWriter implements Writer {

        String input;

        public TestWriter(String input) {
            this.input = input;
        }

        @Override
        public String getInput() {
            return input;
        }

        @Override
        public void close() {
        }
    }

}