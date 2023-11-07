package lotto.domain;

import org.assertj.core.error.AbstractShouldHaveTextContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JackpotTest {

    @DisplayName("보너스 번호와 잭팟 번호 사이에 중복이 있으면 안 된다")
    @Test
    void createJackpotByDuplicatedBonumNumber() {
        assertThatThrownBy(() -> new Jackpot(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잭팟 번호 사이에 중복이 있으면 안 된다")
    @Test
    void createJackpotByDuplicatedNumber() {
        assertThatThrownBy(() -> new Jackpot(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
