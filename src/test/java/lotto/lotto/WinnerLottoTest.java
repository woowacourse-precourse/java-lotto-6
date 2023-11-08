package lotto.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerLottoTest {
    @DisplayName("범위를 벗어난 보너스번호 입력시 예외가 발생")
    @Test
    public void inputNotInRangeTest(){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            list.add(i);
        }
        Lotto lotto = new Lotto(list);
        assertThatThrownBy(() -> new WinnerLotto(lotto,100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
