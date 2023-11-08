package lotto.domain;

import static lotto.constant.ErrorMessageConstant.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("로또 숫자, 보너스 숫자 간 중복 여부 확인")
    void 중복_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("1등 확인")
    void _1등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(result).isEqualTo(LottoResult.FIRST);
    }

    @Test
    @DisplayName("2등 확인")
    void _2등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(result).isEqualTo(LottoResult.SECOND);
    }

    @Test
    @DisplayName("3등 확인")
    void _3등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        assertThat(result).isEqualTo(LottoResult.THIRD);
    }

    @Test
    @DisplayName("4등 확인")
    void _4등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        assertThat(result).isEqualTo(LottoResult.FOURTH);
    }

    @Test
    @DisplayName("5등 확인")
    void _5등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        assertThat(result).isEqualTo(LottoResult.FIFTH);
    }

    @Test
    @DisplayName("꼴등 확인")
    void _꼴등_확인_1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        assertThat(result).isEqualTo(LottoResult.MISS);
    }

    @Test
    @DisplayName("꼴등 확인")
    void _꼴등_확인_2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(1, 7, 8, 9, 10, 11)));

        assertThat(result).isEqualTo(LottoResult.MISS);
    }

    @Test
    @DisplayName("꼴등 확인")
    void _꼴등_확인_3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        LottoResult result = winningLotto.matchLotto(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        assertThat(result).isEqualTo(LottoResult.MISS);
    }
}