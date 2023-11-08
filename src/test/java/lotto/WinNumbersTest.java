package lotto;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinNumbersTest {

    @DisplayName("숫자가 아닌 값을 입력할 때, 예외를 발생한다")
    @Test
    void 숫자가_아닌_입력값() {
        String[] firstUserInput = {"1", "2", "a", "4", "5", "6"};
        String[] secondUserInput = {"1", "2.3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinNumbers(firstUserInput))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbers(secondUserInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 6개를 입력하지 않으면, 예외를 발생한다")
    @Test
    void 당첨번호_개수_테스트() {
        String[] userInput = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> new WinNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_중복_테스트() {
        String[] userInput = {"1", "2", "3", "4", "5", "3"};
        assertThatThrownBy(() -> new WinNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 정렬 테스트")
    @Test
    void 당첨번호_정렬_테스트() {
        //given
        String[] userInput = {"1", "2", "3", "4", "5", "6"};
        //when
        List<Integer> winNumbers = new WinNumbers(userInput).getWinNumbers();
        //then
        for(int i = 0; i < 6; i++){
            assertThat(winNumbers.get(i))
                    .isEqualTo(i+1);
        }

    }

    @DisplayName("1~45이외의 값을 입력하면 예외가 발생한다.")
    @Test
    void 당첨번호_범위_테스트() {
        String[] userInput = {"1", "44", "45", "47", "42", "3"};
        assertThatThrownBy(() -> new WinNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
