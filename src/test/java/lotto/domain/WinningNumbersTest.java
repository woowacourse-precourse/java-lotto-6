package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @DisplayName("로또 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void 문자가_포함된_로또_생성() {
        assertThatThrownBy(() -> WinningNumbers.from("1,2,3,4,5,lotto"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 넘는 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 범위를_벗어난_숫자가_포함된_로또_생성() {
        assertThatThrownBy(() -> WinningNumbers.from("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}