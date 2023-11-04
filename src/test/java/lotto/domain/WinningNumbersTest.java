package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    String input;

    @DisplayName("1~45 의 서로 다른 6개의 당첨번호를 생성한다.")
    @Test
    void createWinningNumbers() {
        // given
        input = "1,2,3,4,5,6";

        // when
        WinningNumbers winningNumbers = WinningNumbers.create(input);

        // then
        assertThat(winningNumbers.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("당첨번호가 공백이면 에외 발생")
    @Test
    void cannotCreateWinningLottos_blank() {
        // given
        input = " ";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 쉼표로 시작하면 에외 발생")
    @Test
    void cannotCreateWinningLottos_startsWithDelimiter() {
        // given
        input = ",1";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 쉼표로 끝나면 에외 발생")
    @Test
    void cannotCreateWinningLottos_endsWithDelimiter() {
        // given
        input = "1,";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 쉼표만 있으면 에외 발생")
    @Test
    void cannotCreateWinningLottos_onlyContainsDelimiter() {
        // given
        input = ",,";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 쉼표가 아닌 다른 기호로 구분된 경우 예외 발생")
    @Test
    void cannotCreateWinningLottos_noDelimiters() {
        // given
        input = "1.2.3.4.5.6";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 숫자로 구성되어 있지 않으면 예외 발생")
    @Test
    void cannotCreateWinningLottos_notNumeric() {
        // given
        input = "r,w,3,4";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 숫자로 구성되어 있지만 공백이 있는 경우 예외 발생")
    @Test
    void cannotCreateWinningLottos_numericButContainsBlank() {
        // given
        input = "1,2,3 ,4";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 서로 다른 6개의 숫자가 아니면 예외 발생")
    @Test
    void cannotCreateWinningLottos_duplicate() {
        // given
        input = "1,1,2,3,4,5";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 서로 다른 6개의 숫자의 범위가 1~45가 아닌 경우(음수를 포함하는 경우) 예외 발생")
    @Test
    void cannotCreateWinningLottos_invalidRangeBelow() {
        // given
        input = "-1,4,5,6,7,8";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 서로 다른 6개의 숫자의 범위가 1~45가 아닌 경우(46 이상인 경우) 예외 발생")
    @Test
    void cannotCreateWinningLottos_invalidRangeAnove() {
        // given
        input = "1,46,3,4,5,6";

        // when, then
        assertThatThrownBy(() -> WinningNumbers.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void splitTest() {
        String input = "";
        String[] split = input.split(",");
        assertThat(split.length).isEqualTo(1);

        String input1 = " ";
        String[] split1 = input1.split(",");
        assertThat(split1.length).isEqualTo(1);

        String input2 = ",";
        String[] split2 = input2.split(",");
        assertThat(split2.length).isEqualTo(0);

        String input3 = ",,";
        String[] split3 = input3.split(",");
        assertThat(split3.length).isEqualTo(0);

        String input4 = ",1,";
        String[] split4 = input4.split(",");
        assertThat(split4.length).isEqualTo(2);
        System.out.println(split4[0]);  //""
        System.out.println(split4[1]);  //1

        String input5 = ",,1";
        String[] split5 = input5.split(",");
        assertThat(split5.length).isEqualTo(3);
        System.out.println(split5[0]);  //""
        System.out.println(split5[1]);  //""
        System.out.println(split5[2]);  //1

        String input6 = "1,";
        String[] split6 = input6.split(",");
        assertThat(split6.length).isEqualTo(1);
        System.out.println(split5[0]);  //1

        String input7 = "1,2,3,4,5,6";
        String[] split7 = input7.split(",");
        List<String> list = Arrays.asList(split7);

    }
}