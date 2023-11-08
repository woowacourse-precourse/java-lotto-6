package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoWinningTest {
    @DisplayName("LottoWinning은 문자열이 들어가면 에러처리한다.")
    @Test
    void createLottoWinningByNotNumber() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,12,43,w"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoWinning 1~45 범위를 넘어서면 에러처리한다.")
    @Test
    void createLottoWinningByOutOfRange() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,12,43,67"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoWinning 중복되면 에러처리한다.")
    @Test
    void createLottoWinningByDuplicate() {
        assertThatThrownBy(() -> new LottoWinning("2,32,33,2,43,67"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus번호는 숫자가 아니면 에러처리한다.")
    @Test
    void setBonusNumberByString() {
        assertThatThrownBy(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,67");
            lottoWinning.setBonusNumber("w");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus번호는 1~45 사이 숫자가 아니면 에러처리한다.")
    @Test
    void setBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,67");
            lottoWinning.setBonusNumber("89");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bonus번호는 LottoWinning이랑 중복되면 에러처리한다.")
    @Test
    void setBonusNumberByDuplicate() {
        assertThatThrownBy(() -> {
            LottoWinning lottoWinning = new LottoWinning("2,32,33,1,43,67");
            lottoWinning.setBonusNumber("33");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
