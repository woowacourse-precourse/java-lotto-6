package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.record.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("getBonusNumber는 BonusNumber 객체 생성시의 BonusNumber와 같다.")
    @Test
    void getBonusNumber() {
        assertSimpleTest(() -> assertThat(new BonusNumber(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), "7")
                .getBonusNumber()).isEqualTo(7));
    }
}