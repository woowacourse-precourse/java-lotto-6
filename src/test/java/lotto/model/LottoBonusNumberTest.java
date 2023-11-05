package lotto.model;

import static lotto.util.TestUtil.ERROR_PREFACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusNumberTest {

    @DisplayName("보너스 번호가 잘 저장되고 반환된다.")
    @Test
    void successSaveLottoBonusNumber() {
        String number = "25";
        LottoBonusNumber bonusNumber = new LottoBonusNumber(number);

        int saveNumber = bonusNumber.getBonusNumber();
        assertThat(String.valueOf(saveNumber)).isEqualTo(number);
    }

    @DisplayName("숫자가 아닌경우 예외 반환")
    @Test
    void createLottoBonusNumberThrowCase1() {
        String number = "이십오";

        assertThatThrownBy(() -> new LottoBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

    @DisplayName("범위가 아닌 경우 예외 반환: 음수")
    @Test
    void createLottoBonusNumberThrowCase2() {
        String number = "-10";

        assertThatThrownBy(() -> new LottoBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

    @DisplayName("범위가 아닌 경우 예외 반환: 0")
    @Test
    void createLottoBonusNumberThrowCase3() {
        String number = "0";

        assertThatThrownBy(() -> new LottoBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

    @DisplayName("범위가 아닌 경우 예외 반환: 45 초과")
    @Test
    void createLottoBonusNumberThrowCase4() {
        String number = "46";

        assertThatThrownBy(() -> new LottoBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

}