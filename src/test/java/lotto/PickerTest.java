package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PickerTest extends NsTest{

    @DisplayName("당첨 숫자 입력은 ,로 구분되어야 한다.")
    @Test
    void generateWinNumbersByIsComma() {
        assertThatThrownBy(
                () -> {
                    runException("123456");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자는 숫자여야 한다.")
    @Test
    void generateWinNumbersByIsDigit() {
        assertThatThrownBy(
                () -> {
                    runException("1,2,3,4,5,h");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자는 45이하 숫자여야 한다.")
    @Test
    void generateWinNumbersByInRangeUnder45() {
        assertThatThrownBy(
                () -> {
                    runException("46,2,3,4,5,6");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자는 1이상 숫자여야 한다.")
    @Test
    void generateWinNumbersByInRangeUpper1() {
        assertThatThrownBy(
                () -> {
                    runException("-1,2,3,4,5,6");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자는 공백이 없어야 한다.")
    @Test
    void generateWinNumbersByIsSpace() {
        assertThatThrownBy(
                () -> {
                    runException("1, 2,3,4,5,6");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자는 6개이어야 한다.")
    @Test
    void generateWinNumbersByCount6() {
        assertThatThrownBy(
                () -> {
                    runException("1,2,3,4,5,6,7");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 보너스 숫자는 숫자여야 한다.")
    @Test
    void generateWinBonusNumbersByIsDigit() {
        assertThatThrownBy(
                () -> {
                    runException("h");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 보너스 숫자는 45이하 숫자여야 한다.")
    @Test
    void generateWinBonusNumbersByInRangeUnder45() {
        assertThatThrownBy(
                () -> {
                    run("46");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 보너스 숫자는 1이상 숫자여야 한다.")
    @Test
    void generateWinBonusNumbersByInRangeUpper1() {
        assertThatThrownBy(
                () -> {
                    run("-1");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    public void runMain() {
        Picker picker = new Picker();
        picker.generateWinNumbers();
    }


    public void run() {
        Picker picker = new Picker();
        picker.generateWinBonusNumber();
    }
}