package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BonusTest {

    Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
    @Test
    @DisplayName("보너스 번호가 범위를 벗어난 숫자일 경우 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어난_숫자인지_검증(){
        Assertions.assertThatThrownBy(()-> new Bonus(lotto,"200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 문자일 경우 예외가 발생한다.")
    void 보너스_번호가_숫자인지_검증(){
        Assertions.assertThatThrownBy(()-> new Bonus(lotto,"t"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 기존 입력한 로또 번호와 중복일 경우 예외가 발생한다.")
    void 보너스_번호가_중복인지_검증(){

        Assertions.assertThatThrownBy(() -> {
            new Bonus(lotto, "2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}