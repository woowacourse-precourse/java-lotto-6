package lotto;

import model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {

    @DisplayName("당첨 번호와 중복된 번호가 입력되면 오류가 발생한다.")
    @Test
    void inputBonus_Duplicated(){
        assertThatThrownBy(() -> new Bonus(List.of(1,2,3,4,5,6), 6)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위보다 작은 수가 입력되면 오류가 발생한다.")
    @Test
    void inputBonusUnderScope(){
        assertThatThrownBy(() -> new Bonus(List.of(1,2,3,4,5,6), 0)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위보다 큰 수가 입력되면 오류가 발생한다.")
    @Test
    void inputBonusOverScope(){
        assertThatThrownBy(() -> new Bonus(List.of(1,2,3,4,5,6), 46)).
                isInstanceOf(IllegalArgumentException.class);
    }
}
