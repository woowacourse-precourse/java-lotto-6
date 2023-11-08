package lotto.util.convert;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertUtilTest {

    @DisplayName("입력된 String이 int로 변환이 불가능하면 예외 발생")
    @Test
    void 문자열_정수_변환_확인(){
        assertThatThrownBy(() -> ConvertUtil.stringToInt("a123"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ConvertUtil.stringToInt("12 34"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
