package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertTest {

    @DisplayName("문자열을 쉼표 기준으로 정수형 리스트로 변환한다.")
    @Test
    void stringToIntegerList() {
        List<Integer> integers = Convert.stringToIntegerList("1,2,3,4,5,6");

        assertThat(integers.size()).isEqualTo(6);
        assertThat(integers.get(0)).isEqualTo(1);
        assertThat(integers.get(1)).isEqualTo(2);
        assertThat(integers.get(2)).isEqualTo(3);
        assertThat(integers.get(3)).isEqualTo(4);
        assertThat(integers.get(4)).isEqualTo(5);
        assertThat(integers.get(5)).isEqualTo(6);
    }
}
