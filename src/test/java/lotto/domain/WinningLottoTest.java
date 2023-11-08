package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("띄어쓰기 무시하는지 확인")
    @Test
    void createLottoIgnoreSpace() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "10");
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertEquals(expectedResult, winningLotto.getWinninglotto().getNumbers());
    }

    @DisplayName("보너스 숫자 중복인지 확인")
    @Test
    void createLottoDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 6개 이상")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,7", "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 6개 미만")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 45초과")
    @Test
    void createLottoOver45() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,46", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 1미만")
    @Test
    void createLottoUnder1() {
        assertThatThrownBy(() -> new WinningLotto("0,2,3,4,5,6", "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복")
    @Test
    void createLottoDuplicateNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 빈숫자")
    @Test
    void createLottoEmpty() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,,5,6", "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 Blank")
    @Test
    void createLottoBlank() {
        assertThatThrownBy(() -> new WinningLotto(" ", "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 Blank")
    @Test
    void createLottoNull() {
        assertThatThrownBy(() -> new WinningLotto("", "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 문자")
    @Test
    void createLottoNotNumeric() {
        assertThatThrownBy(() -> new WinningLotto("a,2,3,4,5,6", "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 빈칸")
    @Test
    void createBonusNumberBlank() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", " "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 Null")
    @Test
    void createBonusNumberNull() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", ""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 문자")
    @Test
    void createBonusNumberNotNumeric() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 1미만")
    @Test
    void createBonusNumberUnder0() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 45초과")
    @Test
    void createBonusNumberOver45() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}