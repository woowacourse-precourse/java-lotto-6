package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    @DisplayName("로또 개수만큼 로또를 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 8})
    void createLottos(int lottoCount) {
        assertThat(LottoGenerator.createLottos(lottoCount).size()).isEqualTo(lottoCount);
    }

    @DisplayName("당첨 번호를 입력 받아 당첨 로또 생성")
    @Test
    void createWinningLotto() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThat(LottoGenerator.createWinningLotto("1,2,3,4,5,6").getNumbers())
                .isEqualTo(lotto.getNumbers());
    }

    @DisplayName("입력된 당첨 번호가 숫자가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e,f", "1,,3,4,5,6", "1, ,3,4,5,6"})
    void createWinningLottoByNotNumber(String lottoNumber) {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호가 양수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "-1,2,3,4,5,6", "1.5,2,3,4,5,6"})
    void createWinningLottoByNotPositiveNumber(String lottoNumber) {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호 마지막에 콤마가 있을 때, 예외 처리")
    @Test
    void createWinningLottoByNotNumber() {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호가 로또 번호 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "100,2,3,4,5,6", "41,42,43,44,45,46"})
    void createWinningLottoByNotRange(String lottoNumber) {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호 앞에 0이 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01,2,3,4,5,6", "1,2,03,04,005,00006"})
    void createWinningLottoByFirstNumberZero(String lottoNumber) {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호 개수가 6개가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void createWinningLottoByNotEqualSize(String lottoNumber) {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호가 중복될 때, 예외 처리")
    @Test
    void createWinningLottoByDuplication() {

        assertThatThrownBy(() -> LottoGenerator.createWinningLotto("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 입력 받아 보너스 번호 생성")
    @Test
    void createBonusNumber() {

        // given
        Lotto winningLotto = LottoGenerator.createWinningLotto("1,2,3,4,5,6");

        // when
        Integer bonusNumber = LottoGenerator.createBonusNumber(winningLotto, "7");

        // then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("입력된 보너스 번호가 숫자가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", "", " "})
    void createBonusNumberByNotNumber(String bonusNumber) {

        // given
        Lotto winningLotto = LottoGenerator.createWinningLotto("1,2,3,4,5,6");

        // when, then
        assertThatThrownBy(() -> LottoGenerator.createBonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호가 양수가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "1.5"})
    void createBonusNumberByNotPositiveNumber(String bonusNumber) {

        // given
        Lotto winningLotto = LottoGenerator.createWinningLotto("1,2,3,4,5,6");

        // when, then
        assertThatThrownBy(() -> LottoGenerator.createBonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호가 로또 번호 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "100"})
    void createBonusNumberByNotRange(String bonusNumber) {

        // given
        Lotto winningLotto = LottoGenerator.createWinningLotto("1,2,3,4,5,6");

        // when, then
        assertThatThrownBy(() -> LottoGenerator.createBonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호가 당첨 번호와 중복될 때, 예외 처리")
    @Test
    void createBonusNumberByDuplication() {

        // given
        Lotto winningLotto = LottoGenerator.createWinningLotto("1,2,3,4,5,6");

        // when, then
        assertThatThrownBy(() -> LottoGenerator.createBonusNumber(winningLotto, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호 앞에 0이 있을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01", "00045"})
    void createBonusNumberByFirstNumberZero(String bonusNumber) {

        // given
        Lotto winningLotto = LottoGenerator.createWinningLotto("1,2,3,4,5,6");

        // when, then
        assertThatThrownBy(() -> LottoGenerator.createBonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}