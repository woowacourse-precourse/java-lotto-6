package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BonusNumberTest {

    @DisplayName("보너스 번호 불변객체 테스트 - 값 변경 시도 - 오류")
    @Test
    void isImmutableBonusNumber() {
        Integer testBonusNumber = 30;
        Integer expectedResult = 30;
        int a = 10;
        BonusNumber bonusNumber = new BonusNumber(testBonusNumber);

        tryModification(bonusNumber.getBonusNumber());
        tryModification(a);
        System.out.println(a);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(expectedResult);
    }

    private void tryModification(int immutableField1) {
        immutableField1 = 1000;
    }

    @DisplayName("보너스 번호 유효성 검사 테스트 - 1~45 범위 외 데이터 - 오류")
    @Test
    void validateBonusNumberTest() {
        int testBonusNumber = 46;

        assertThatThrownBy(() -> new BonusNumber(testBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1~45의 숫자를 입력해주세요.");
    }
}
