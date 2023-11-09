package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinLottoTest {
    @DisplayName(",로 구분되어 있는지 확인한다.")
    @Test
    void checkSortWithComma(){
        InputStream in = new ByteArrayInputStream("1.2.3.4.5.6.".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new WinLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값이 당첨 번호와 중복인지 확인한다.")
    @Test
    void checkDuplicateBonus(){
        InputStream inWinLotto = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(inWinLotto);

        WinLotto winLotto = new WinLotto();

        assertThatThrownBy(() -> winLotto.validDuplicateBonus(1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값의 범위가 알맞은 지 확인한다.")
    @Test
    void checkBonusRange(){

        InputStream inWinLotto = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(inWinLotto);

        WinLotto winLotto = new WinLotto();

        assertThatThrownBy(() -> winLotto.validRange(47)).isInstanceOf(IllegalArgumentException.class);
    }

}
