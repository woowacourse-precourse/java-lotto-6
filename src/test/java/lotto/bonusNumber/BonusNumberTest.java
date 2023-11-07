package lotto.bonusNumber;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {
    @Test
    void validate_1에서_45_사이의_중복_없는_6자리는_참이다() {
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThat(bonusNumber.getNumber()).isEqualTo(1);
    }
    @Test
    void validate_범위를_벗어나면_거짓을_반환한다() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new BonusNumber(-1));
    }
}
