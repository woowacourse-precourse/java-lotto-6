package lotto.domain;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void 정상_입력값을_받았을_때() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> result = lotto.getNumbers();

        assertThat(numbers).isEqualTo(result);
    }

    @Test
    void 개수가_6개가_넘었을_떄_예외_처리() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_번호를_입력_받았을_떄_예외_처리() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_밖의_번호를_입력_받았을_땨_예외_처리() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 49);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백을_입력_받았을_때_예외_처리() {
        String sample = "1,2,,9,5,6";
        try {
            List<Integer> numbers = Arrays.stream(sample.split(","))
                    //.filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            fail("공백이 있음에도 예외처리 안됨");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals("For input string: \"\"", e.getMessage());
        }
    }

}