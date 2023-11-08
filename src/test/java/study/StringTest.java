package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void checkStringContainingDelimiterIsWellSplited() {
        String testString = "1,2";
        assertThat(testString.split(",")).containsAll(new ArrayList<>(List.of("1", "2")));
    }

    @DisplayName("1을 ,로 split 했을 때 1만이 포함되는 배열이 반환되는지 확인한다.")
    @Test
    void checkResultWhenStringNotContainingDelimiterSplitedToOriginal() {
        String testString = "1";
        assertThat(testString.split(",")).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring() 메소드를 통해 \"1,2\"를 반환하는지 확인한다.")
    @Test
    void checkSubStringMethodToEraseWantedInnerString() {
        String testString = "(1,2)";
        String outputString = testString.substring(1, 4);
        assertThat(outputString).isEqualTo("1,2");
    }

    @DisplayName("\"abc\"값이 주어졌을 때 charAt() 메소드를 통해 특정 위치의 문자를 가져온다.")
    @Test
    void checkCharAtMethodToGetWantedPositionCharacterInString() {
        String testString = "abc";
        assertThat(testString.charAt(0)).isEqualTo('a');
        assertThat(testString.charAt(1)).isEqualTo('b');
        assertThat(testString.charAt(2)).isEqualTo('c');
    }

    @DisplayName("\"abc\"값이 주어졌을 때 charAt() 메소드에 대해 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void checkCharAtMethodThrowsExceptionWhenTryToGetCharacterOutOfBound() {
        String testString = "abc";
        assertThatThrownBy(() -> testString.charAt(100))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}