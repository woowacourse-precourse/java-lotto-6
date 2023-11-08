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

}