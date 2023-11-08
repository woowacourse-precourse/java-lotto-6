package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BonusNumberTest {

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createBonusNumberByDuplicatedNumber() throws Exception {
        //given & when & then
        assertThatThrownBy(() -> new BonusNumber(7, new Lotto(List.of(1, 2, 3, 4, 5, 7))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}