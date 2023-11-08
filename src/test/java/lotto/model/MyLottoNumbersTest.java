package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyLottoNumbersTest {
    @DisplayName("숫자가 아닌 입력값이 있을 경우 예외처리")
    @Test
    void 입력값_숫자확인() {
        assertThatThrownBy(() -> new MyLottoNumbers("1,e,3,A,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다");
    }

    @DisplayName("입력값이 주어진 범위를 벗어날 경우 예외처리")
    @Test
    void 입력값_범위확인() {
        assertThatThrownBy(() -> new MyLottoNumbers("0,1,2,3,4,500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45의 숫자들만 입력 가능합니다");
    }

    @DisplayName("입력번호들의 개수가 6개가 아닐 경우 예외처리")
    @Test
    void 입력값_개수확인() {
        assertThatThrownBy(() -> new MyLottoNumbers("1,2,3,4,5,6,7,8,9,10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자로 구성되어야 합니다");
    }

    @DisplayName("중복된 숫자가 있을 경우 예외처리")
    @Test
    void 입력값_중복검사() {
        assertThatThrownBy(() -> new MyLottoNumbers("1,2,2,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재합니다");
    }
    
    @DisplayName("보너스 입력값 숫자가 아닐 경우 예외처리")
    @Test
    void 보너스_입력검사() {
        MyLottoNumbers numbers = new MyLottoNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> numbers.setBonusNumber("$"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다");
    }

    @DisplayName("보너스 입력값 숫자가 이미 존재할 경우 예외처리")
    @Test
    void 보너스_중복검사() {
        MyLottoNumbers numbers = new MyLottoNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> numbers.setBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재합니다");
    }
}