package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @Test
    @DisplayName("숫자 리스트로 변환")
    void toIntegerList() {
        List<Integer> sut = StringUtils.toIntegerList("1,2,3,4,5,6");
        assertThat(sut).containsExactly(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("숫자 리스트로 변환 - 예외")
    void toIntegerList_예외() {
        assertThatThrownBy(() -> StringUtils.toIntegerList("1,2,3,4,,,5,6,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1,2,3,4,5,6 형식으로 입력해 주세요.");
    }

    @Test
    @DisplayName("숫자로 변환")
    void toInt() {
        int sut = StringUtils.toInt("1000");
        assertThat(sut).isEqualTo(1000);
    }

    @Test
    @DisplayName("숫자로 변환 - 예외")
    void toInt_예외() {
        assertThatThrownBy(() -> StringUtils.toInt("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해 주세요.");
    }
}