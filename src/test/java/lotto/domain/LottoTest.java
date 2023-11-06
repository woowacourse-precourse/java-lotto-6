package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45밖의 숫자를 입력시 예외가 발생한다.")
    @Test
    void createLottoByNotInRange() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(46))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 존재한다면 True를 반환한다.")
    void containSuccess() {
        List<LottoNumber> lottoNumber = List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));
        Lotto lotto = new Lotto(lottoNumber);

        assertThat(lotto.contain(new LottoNumber(4))).isTrue();
    }

    @Test
    @DisplayName("번호가 존재하지 않는 다면 False를 반환한다.")
    void containFail() {
        List<LottoNumber> lottoNumber = List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));
        Lotto lotto = new Lotto(lottoNumber);

        assertThat(lotto.contain(new LottoNumber(6))).isFalse();
    }

    @Test
    @DisplayName("로또의 중복되는 값의 갯수를 반환한다.")
    void calcSameItemCount() {
        List<LottoNumber> lottoNumber1 = List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));
        Lotto lotto1 = new Lotto(lottoNumber1);

        List<LottoNumber> lottoNumber2 = List.of(
                new LottoNumber(6), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(45));
        Lotto lotto2 = new Lotto(lottoNumber2);

        assertThat(lotto1.calcSimilarity(lotto2)).isEqualTo(5);
    }
}
