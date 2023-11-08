package lotto.util.convert;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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

    @DisplayName("입력된 String이 int로 변환이 가능하면 성공")
    @Test
    void 문자열_정수_변환_성공(){
        int number = ConvertUtil.stringToInt("1000");
        assertThat(number).isEqualTo(1000);
    }

    @DisplayName("입력된 ','로 구분되어 있는 String을 List<Integer>로 변환이 불가능하면 예외 발생")
    @Test
    void 문자열_정수_배열_반환_확인(){
        assertThatThrownBy(() -> ConvertUtil.stringToIntArr("1, 2, 3, 4, 5, 6"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ConvertUtil.stringToInt("1,2,a,3,4,5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 ','로 구분되어 있는 String을 List<Integer>로 변환이 가능하면 성공")
    @Test
    void 문자열_정수_배열_변환_성공(){
        List<Integer> numbers = ConvertUtil.stringToIntArr("1,2,3,4,5,6");
        assertThat(numbers).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("입력된 금액을 통해 로또를 몇 장 뽑을 수 있는지 반환")
    @Test
    void 로또_뽑기_횟수(){
        assertThat(ConvertUtil.moneyToCount(10000)).isEqualTo(10);
    }
}
