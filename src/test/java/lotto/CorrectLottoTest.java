package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CorrectLottoTest {
    CorrectLotto correctLotto = new CorrectLotto();

    @DisplayName("당첨 번호에 입력값이 비어있는 부분이 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_입력값_비어있는지_확인() {
        // given
        String input_numbers1 = "";
        String input_numbers2 = "1,,3,4,5,6";
        String input_numbers3 = "1,2,3,4,5,6,";
        String input_numbers4 = ",1,2,3,4,5,6";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            correctLotto.convertStringToInteger(input_numbers1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            correctLotto.convertStringToInteger(input_numbers2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            correctLotto.convertStringToInteger(input_numbers3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            correctLotto.convertStringToInteger(input_numbers4);
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스번호_중복_확인() {
        // given
        int bonus = 1;
        String input_numbers = "1,2,3,4,5,6";
        correctLotto.inputCorrectLotto(input_numbers);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            correctLotto.checkNumberDuplicate(bonus);
        });
    }

    @DisplayName("당첨 번호와 보너스 번호가 정상적으로 입력되는지 확인한다.")
    @Test
    void 당첨번호_보너스번호_정상_입력_확인() {
        // given
        String input_numbers = "1,2,3,4,5,6";
        String input_number = "7";

        // when
        correctLotto.inputCorrectLotto(input_numbers);
        correctLotto.inputBonus(input_number);

        // then
        assertEquals(List.of(1,2,3,4,5,6), correctLotto.getCorrect_lotto().getNumbers());
        assertEquals(7, correctLotto.getBonus());
    }
}