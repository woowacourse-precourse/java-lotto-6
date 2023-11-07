package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    private WinningLotto lotto;

    @BeforeEach
    void init() {
        this.lotto = new WinningLotto(List.of("1", "2", "3", "4", "5", "6"));
    }

    @DisplayName("글자를 입력하거나 터무니 없는 값을 입력하면 예외가 발생한다.")
    @Test
    void createWinningLottoByNotNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("199388020895830204", "테스트", "111", "403", "3", "9")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("숫자 입력 시, 공백이 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByBlank() {
        assertThatThrownBy(() -> new WinningLotto(List.of(" 3", "12", "20", "21 ", "30, 31")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호의 숫자가 45보다 크면 안 된다.")
    @Test
    void createWinningLottoByOverNumberRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "4", "44", "56", "43", "23")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호의 숫자가 1보다 작으면 안 된다.")
    @Test
    void createWinningLottoByUnderNumberRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "-6", "30", "29", "32")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotSixSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "3", "4", "5", "6", "7")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 개수는 6개여야만 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "3", "4", "5", "5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복된 숫자를 고를 수 없습니다.");
    }

    @DisplayName("보너스 번호 입력 시 글자를 입력하거나 터무니 없는 값을 입력하면 예외가 발생한다.")
    @Test
    void plusBonusByNotNumber() {
        assertThatThrownBy(() -> lotto.plusBonusNumber(List.of("테스트!")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호는 45보다 커선 안 된다.")
    @Test
    void plusBonusByOverRange() {
        assertThatThrownBy(() -> lotto.plusBonusNumber(List.of("500")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호는 1보다 작아선 안 된다.")
    @Test
    void plusBonusByUnderRange() {
        assertThatThrownBy(() -> lotto.plusBonusNumber(List.of("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백 없이 1~45까지의 숫자를 입력해주세요.");
    }

    @DisplayName("당첨 번호와 보너스 번호는 중복되어선 안 된다.")
    @Test
    void plusBonusByDuplicateNumber() {
        assertThatThrownBy(() -> lotto.plusBonusNumber(List.of("1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("넘겨받은 로또의 당첨 여부를 확인해서 등수를 담은 리스트를 반환한다.")
    @Test
    void returnRankResultList() {
        WinningLotto winningLotto = new WinningLotto(List.of("3", "7", "12", "16", "35", "38"));
        List<Lotto> allLotto = new ArrayList<>();

        winningLotto.plusBonusNumber(List.of("20"));

        Lotto fifthLotto = new Lotto(List.of(1, 3, 6, 7, 29, 35));
        Lotto loseLotto = new Lotto(List.of(5, 9, 20, 31, 39, 41));

        allLotto.add(fifthLotto);
        allLotto.add(loseLotto);

        List<Rank> result = winningLotto.judgeLottoGame(allLotto);

        assertThat(result.size()).isEqualTo(2);
    }
}