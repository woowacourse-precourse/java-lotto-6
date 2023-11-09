package lotto.model;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    BonusNumber bonusNumber;
    private List<Integer> winningNumbers;

    @BeforeEach
    void beforeEach() {
        this.bonusNumber = new BonusNumber();
        this.winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ", "!", "ㅁ"})
    void 보너스_번호_입력_양식(String input) {
        assertThatCode(() -> bonusNumber.inputBonusNumber("7", winningNumbers)).doesNotThrowAnyException();
        assertThatThrownBy(() -> bonusNumber.inputBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 보너스_번호_범위(String input) {
        assertThatCode(() -> bonusNumber.inputBonusNumber("7", winningNumbers)).doesNotThrowAnyException();
        assertThatThrownBy(() -> bonusNumber.inputBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1부터 45까지의 숫자만 사용됩니다.");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복인지_확인() {
        assertThatCode(() -> bonusNumber.inputBonusNumber("7", winningNumbers)).doesNotThrowAnyException();
        assertThatThrownBy(() -> bonusNumber.inputBonusNumber("1", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 번호가 존재합니다. 다른 번호를 입력해주세요.");
    }
}