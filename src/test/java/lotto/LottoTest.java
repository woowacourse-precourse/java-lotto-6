package lotto;

import lotto.Message.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45의 숫자가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 99})
    void createLottoByNotLottoNumber(int lottoNumber) {
        //given
        List<Integer> lottoNumbers = List.of(lottoNumber, 1, 2, 3, 4, 5);
        // when //then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45의 숫자가 아닌 숫자가 있으면 예외가 발생한다. ")
    @ParameterizedTest
    @ValueSource(ints = {0, 55, 72})
    void createBonusByNotLottoNumber(int lottoNumber) {
        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = lottoNumber;
        // when //then
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호와 보너스 번호에는 음수가 들어가면 안 된다. ")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void createMinusNumberWithBonusAndLottoNumber(int lottoNumber) {
        //given
        List<Integer> lottoNumbers = List.of(lottoNumber, 2, 3, 4, 5, 6);
        int bonusNumber = lottoNumber;
        // when //then
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈은 1000원 단위가 들어와야 한다. ")
    @ParameterizedTest
    @ValueSource(ints = {1111,1113,1114})
    void createMinusNumberWithBonusAndLottoNumber(int lottoNumber) {
        //given
        List<Integer> lottoNumbers = List.of(lottoNumber, 2, 3, 4, 5, 6);
        int bonusNumber = lottoNumber;
        // when //then
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}