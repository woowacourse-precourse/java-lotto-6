package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("보너스 번호는 1~45 사이의 숫자이어야 합니다.")
    @Test
    void createWinningNumberByOverRange(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> new WinningNumber(lotto,60))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 중복입니다.")
    @Test
    void createWinningNumberByDuplicatedNumber(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(()-> new WinningNumber(lotto,1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
