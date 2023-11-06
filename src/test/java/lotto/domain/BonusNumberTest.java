package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 숫자는 1에서 45 이하의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(ints = {0, 46, 50})
    void BonusNumber_Constructor_ThrowsException_For_NumberOutOfRange(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("isMatch 메서드는 보너스 번호가 구매자 로또 번호에 포함되어 있으면 true를 반환한다.")
    void isMatch_Method_Return_BonusNumber_Contains_BuyerLotto_True() {
        List<Integer> buyerLotto = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(6);

        assertTrue(bonusNumber.isMatch(buyerLotto));
    }
}
