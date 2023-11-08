package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000의 자리 수인지 확인하여 예외 발생")
    @Test
    void moneyFormatCheck() {
        // 1000원 단위가 아닌 금액이므로 IllegalArgumentException 예외 발생
        assertThrows(IllegalArgumentException.class, () -> Validator.moneyValidator(2500));
    }
    @DisplayName("사용자가 중복된 보너스 번호 입력시 예외 발생")
    @Test
    void bonusNumberCheck(){
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThrows(IllegalArgumentException.class, () -> Validator.validateBonusNumberDuplicate(bonusNumber, lottoNumbers));
    }

}
