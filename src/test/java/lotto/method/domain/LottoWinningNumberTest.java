package lotto.method.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoWinningNumberTest {

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    @Test
    @DisplayName("로또 번호와 보너스 번호가 겹치지 않으면 정상적으로 값이 저장된다.")
    void setLottoWinningNumber() {
        lottoWinningNumber.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
        lottoWinningNumber.setBonusNumber(7);
        Assertions.assertThat(lottoWinningNumber.getBonusNumber()).isEqualTo(7);
        Assertions.assertThat(lottoWinningNumber.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("입력시 로또 번호와 보너스 번호가 중복되면 예외를 발생한다. (로또 입력 -> 보너스 번호 입력)")
    void DuplicationBetweenLottoNumberAndBonusNumber() {
        Assertions.assertThatThrownBy(() -> {
            lottoWinningNumber.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
            lottoWinningNumber.setBonusNumber(6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력시 로또 번호와 보너스 번호가 중복되면 예외를 발생한다. (보너스 번호 입력 -> 로또 입력)")
    void DuplicationBetweenLottoNumberAndBonusNumberReverse() {
        Assertions.assertThatThrownBy(() -> {
            lottoWinningNumber.setBonusNumber(6);
            lottoWinningNumber.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호의 범위 밖이면 예외가 발생한다.")
    void inputBonusNumberOutOfRange() {
        Assertions.assertThatThrownBy(() -> {
            lottoWinningNumber.setBonusNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
