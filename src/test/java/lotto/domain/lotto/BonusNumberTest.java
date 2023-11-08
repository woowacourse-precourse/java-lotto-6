package lotto.domain.lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BonusNumber 클래스")
class BonusNumberTest {

    @DisplayName("리스트에 보너스 번호가 있다면 참을 반환한다")
    @Test
    void returnTrueIfBonusNumberInList() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = BonusNumber.from(3);
        Assertions.assertThat(bonusNumber.isIn(numbers)).isTrue();
    }
}