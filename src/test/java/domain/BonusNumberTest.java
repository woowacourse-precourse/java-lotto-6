package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName    : domain
 * fileName       : BonusNumberTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class BonusNumberTest {

    private static final Lotto lotto = new Lotto("1,2,3,4,5,6");

    @DisplayName("보너스 번호가 정상 값 입력한 경우에 대해 검증합니다.")
    @Test
    void createBonusNumber(){
        BonusNumber bonusNumber = new BonusNumber("7", lotto);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 빈 값 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkInputIsNotEmpty(){
        assertThatThrownBy(() -> new BonusNumber("", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 띄어쓰기만 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkInputIsSpace(){
        assertThatThrownBy(() -> new BonusNumber(" ", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 문자열 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkListString(){
        assertThatThrownBy(() -> new BonusNumber("a", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 숫자와 문자열 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkListDigitWithString(){
        assertThatThrownBy(() -> new BonusNumber("12a", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 45 초과 값 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkOutOfRangeNumber(){
        assertThatThrownBy(() -> new BonusNumber("1000", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 1 미만 값 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkOutOfRangeNumber2(){
        assertThatThrownBy(() -> new BonusNumber("-2", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 두 개의 값 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkBonusNumbersCount(){
        assertThatThrownBy(() -> new BonusNumber("2 5", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 두 개의 값 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkBonusNumbersCount2(){
        assertThatThrownBy(() -> new BonusNumber("2,5", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력에 대해 검증합니다. 당첨 번호에 있는 값 입력 시, 예외를 발생시킵니다.")
    @Test
    void checkBonusNumberInWinningNumbers(){
        assertThatThrownBy(() -> new BonusNumber("5", lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
