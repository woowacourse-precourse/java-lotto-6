package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 숫자 문자열을 숫자 타입으로 변환한다.")
    @Test
    void convertToInt() {
        //When
        int number = inputView.convertToInt("5000");
        //Then
        assertThat(number).isEqualTo(5000);
    }

    @DisplayName("입력 받은 값이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void convertToIntByNotNumber() {
        assertThatThrownBy(() -> inputView.convertToInt("aaa1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하실 수 있습니다.");
    }

    @DisplayName("입력 받은 값이 콤마로 구분된 숫자라면 숫자 리스트를 반환한다.")
    @Test
    void getIntegerListByComma() {
        //When
        List<Integer> numbers = inputView.convertToIntegerList("1,2,3,4,5,6");
        //Then
        assertThat(numbers).hasSameElementsAs(List.of(1,2,3,4,5,6));
    }

    @DisplayName("입력 받은 값이 콤마로 구분된 숫자가 아니라면 예외가 발생한다.")
    @Test
    void enterWinningByNotSeparatedComma() {
        assertThatThrownBy(() -> inputView.isCommaValidate("1-2-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 콤마로 구분하여 입력해주세요.");
    }

    @DisplayName("입력 받은 값이 빈 값이라면 예외가 발생한다.")
    @Test
    void enterByEmpty() {
        assertThatThrownBy(() -> inputView.isEmptyValidate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 값을 입력하실 수 없습니다.");
    }
}