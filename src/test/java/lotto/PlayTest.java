package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayTest {

    public Play play = new Play();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자입력_테스트() {
        assertThatThrownBy(() -> play.isNumeric("a"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 천원단위입력_테스트() {
        play.money = 10001;
        assertThatThrownBy(() -> play.isThousand())
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 보너스번호중복입력_테스트() {
        play.winNumber = List.of(1, 2, 3, 4, 5, 6);
        play.bonusNumber = 5;
        play.money = 10001;
        assertThatThrownBy(() -> play.isDuplicate())
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 보너스번호_유효한값입력_테스트() {

        play.bonusNumber = 99;
        play.check = false;
        assertThatThrownBy(() -> play.isValidBonus())
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 로또번호_입력_테스트() {
        assertThatThrownBy(() -> play.isCount(new String[]{"1,2,3,4,5,5"}))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 유효한_로또번호_입력_테스트() {
        play.check = false;
        assertThatThrownBy(() -> play.isValidLotto(new int[]{99, 2, 3, 4, 5, 5}))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 로또번호_중복입력_테스트() {
        play.check = false;
        assertThatThrownBy(() -> play.isDuplicateLotto(new int[]{99, 2, 3, 4, 5, 5}))
                .isInstanceOf(IllegalArgumentException.class);

    }

}