package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"d", " ", "\n"})
    void 보너스번호_숫자아닌값_예외처리_테스트(String input) {
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "0"})
    void 보너스번호_범위밖인값_예외처리_테스트(String input) {
        assertThatThrownBy(() -> new BonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_당첨번호_중복_예외처리_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("2");
        assertThat(lotto.contains(bonusNumber)).isTrue();
        assertThatThrownBy(() -> new WinningNumber(List.of("1", "2", "3", "4", "5", "6"), "2")).isInstanceOf(IllegalArgumentException.class);
    }
}
