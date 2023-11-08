package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1~ 45 범위가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverSize() {
        assertThatThrownBy(() -> new BonusNumber(55))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusNumberInRange() {
        BonusNumber bonusNumber = new BonusNumber(10);
        assertEquals(10, bonusNumber.getBonusNumber());
    }

}