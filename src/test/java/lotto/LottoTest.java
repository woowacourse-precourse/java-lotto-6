package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends TestFunc {
    private static final String ERROR_MESSAGE = "[ERROR]";
    LottoInput lottoInput = new LottoInput();
    PlayLotto playLotto = new PlayLotto();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByNotSize6() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45사이의 값이 아니라면 예외가 발생한다.")
    @Test
    void createLottoByOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottoByUnder1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 빈칸이나 문자같은 옳지않은 형식의 값이 들어가면 예외가 발생한다.")
    @Test
    void createLottoByBlank() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottoByBlank2() {
        assertSimpleTest(() -> {
            runWinningException("1, ,3,4, ,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void createLottoByLetter() {
        assertSimpleTest(() -> {
            runWinningException("1,b,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호에 마지막이 ','로 끝나면 예외가 발생한다.")
    @Test
    void createLottoByLastComma() {
        assertSimpleTest(() -> {
            runWinningException("1,2,3,4,5,6,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호의 형식이 옳지 못한 경우 예외가 발생한다.")
    @Test
    void createLottoByWrongFormat() {
        assertSimpleTest(() -> {
            runWinningException("abcd");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    public void runPrice() {
        lottoInput.getLottoPrice(new String[]{});
    }

    public void runWinning() {
        lottoInput.getWinningNum(new String[]{});
    }
    public void runBonus() {
        lottoInput.getBonusNum(new String[]{});
    }
    public void runBonus2(List<Integer> a1 , int a){
        playLotto.CheckWinningAndBonus(a1, a);
    }
}