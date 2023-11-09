package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void split_일반적인_경우() {
        String input = "1,2";
        String[] split = input.split(",");
        Assertions.assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void split_한_원소만_있을_경우() {
        String input = "1";
        String[] split = input.split(",");
        Assertions.assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하는지에 대한 학습 테스트.")
    void split_괄호_제거_후() {
        String input = "(1,2)";
        String purityInput = input.substring(1, input.length() - 1);
        String[] split = purityInput.split(",");
        Assertions.assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지에 대한 학습 테스트\n"
            + "테스트를 구현한다.")
    void charAt_각_문자를_가져오기() {
        String input = "abc";
        int idx = 1;
        char idxOneValue = input.charAt(idx);
        Assertions.assertThat(idxOneValue).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면\n"
            + "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    void charAt_위치_값을_벗어나면_예외_발생() {
        String input = "abc";
        int idx = input.length();
        Assertions.assertThatThrownBy(() -> {
                    input.charAt(idx);
                }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
