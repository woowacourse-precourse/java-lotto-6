package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @Test
    void changeNumbersTest() {

    }

    @Test
    void validateSizeTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,a,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRangeTest() {

        assertThatThrownBy(() -> new WinLotto("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,46,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDuplicateTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumTest() {

        WinLotto winLotto = new WinLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> winLotto.setBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumSpaceTest() {

        WinLotto winLotto = new WinLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> winLotto.setBonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumNullTest() {

        WinLotto winLotto = new WinLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> winLotto.setBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumDuplicateTest() {

        WinLotto winLotto = new WinLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> winLotto.setBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareLottoTest() {

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6");
        winLotto.setBonusNumber("7");

        int rank = winLotto.compareLotto(lotto);
        assertEquals(6, rank);
    }

    @Test
    void compareBonusLottoTest() {

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto("1,2,3,4,5,7");
        winLotto.setBonusNumber("6");

        int rank = winLotto.compareLotto(lotto);
        assertEquals(5, rank);
    }
}
