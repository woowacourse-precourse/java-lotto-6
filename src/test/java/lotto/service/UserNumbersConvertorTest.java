package lotto.service;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNumbersConvertorTest {
    @DisplayName("로또 번호 변환 테스트")
    @Test
    void testConvertNumbers() {
        assertThat(UserNumbersConvertor.convert("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("로또 번호 띄어쓰기 포함 변환 테스트")
    @Test
    void testSpaceConvertNumbers() {
        assertThat(UserNumbersConvertor.convert(" 1 ,2   ,3 , 4 , 5  ,6")).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
