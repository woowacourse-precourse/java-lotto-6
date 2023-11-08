package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    private static final Lotto lotto = new Lotto("1,2,3,4,5,6");

    @DisplayName("정상 값이 들어오면 성공")
    @Test
    void createBonusNumbersSuccess() {
        BonusNumber bonusNumber = new BonusNumber("8", lotto);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(8);

    }

    @DisplayName("char 값이 들어오면 예외 발생")
    @Test
    void createStringBonusNumbers() {
        assertThatThrownBy(() -> new BonusNumber("a,b,x", lotto))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("두개 이상의 값이 들어오면 예외 발생")
    @Test
    void createBonusNumbers() {
        assertThatThrownBy(() -> new BonusNumber("3,5,6", lotto))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("Char이랑 숫자인 값이 들어오면 예외 발생")
    @Test
    void createCharAndIntBonusNumbers() {
        assertThatThrownBy(() -> new BonusNumber("a6", lotto))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("로또 번호랑 중복인 값이 들어오면 예외 발생")
    @Test
    void createDuplicateBonusNumbers() {
        assertThatThrownBy(() -> new BonusNumber("3", lotto))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("45보다 큰 값이 들어오면 예외 발생")
    @Test
    void createExceededBonusNumbers() {
        assertThatThrownBy(() -> new BonusNumber("46", lotto))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("1보다 작은 값이 들어오면 예외 발생")
    @Test
    void createZeroBonusNumbers() {
        assertThatThrownBy(() -> new BonusNumber("0", lotto))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("로또 당첨 번호 입력 - 빈 값을 입력한 경우 예외 발생")
    @Test
    void checkInputIsNotEmpty() {
        assertThatThrownBy(() -> new BonusNumber("", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 띄어쓰기만 입력한 경우 예외 발생")
    @Test
    void checkInputIsSpace() {
        assertThatThrownBy(() -> new Lotto("    "))
                .isInstanceOf(IllegalArgumentException.class);
    }

}