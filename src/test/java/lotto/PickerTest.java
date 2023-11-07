package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PickerTest {

    @DisplayName("딩첨 번호는 6개이다.")
    @Test
    void generateWinNumbersTest() {
        Picker picker = new Picker();
        List<Integer> winNumbers = picker.generateWinNumbers();
        int winNumbersSize = winNumbers.size();
        assertThat(winNumbersSize).isEqualTo(6);
    }

    @DisplayName("당첨 보너스 번호가 범위 안에서 생성된다.")
    @Test
    void generateWinBonusNumberTest() {
        Picker picker = new Picker();
        int startNumber = 1;
        int endNumber = 45;
        int winBonusNumber = picker.generateWinBonusNumber();
        assertTrue(startNumber <= winBonusNumber, "[Error] lottoNumber is too low");
        assertTrue(endNumber >= winBonusNumber, "[Error] lottoNumber is too high");
        System.out.println("Test passed: " + winBonusNumber + " is within " + startNumber + " and " + endNumber);
    }

}