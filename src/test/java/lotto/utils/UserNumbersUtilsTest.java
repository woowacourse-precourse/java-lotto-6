package lotto.utils;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNumbersUtilsTest {
    @DisplayName("로또 번호 변환 테스트")
    @Test
    void testConvertNumbers() {
        assertThat(UserNumbersUtils.convert("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("로또 번호 띄어쓰기 포함 변환 테스트")
    @Test
    void testSpaceConvertNumbers() {
        assertThat(UserNumbersUtils.convert(" 1 ,2   ,3 , 4 , 5  ,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("로또 번호 정렬 테스트")
    @Test
    void testSortNumbers() {
        assertThat(UserNumbersUtils.sort(List.of(6,5,4,3,2,1))).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
