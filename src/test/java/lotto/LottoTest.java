package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.raffle(List.of(LottoNumber.pickNormalNumber("4"), LottoNumber.pickNormalNumber("5"),
                LottoNumber.pickNormalNumber("6"), LottoNumber.pickNormalNumber("3"), LottoNumber.pickNormalNumber("7"),
                LottoNumber.pickNormalNumber("1"), LottoNumber.pickNormalNumber("2"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.raffle(List.of(LottoNumber.pickNormalNumber("1"), LottoNumber.pickNormalNumber("1"),
                        LottoNumber.pickNormalNumber("1"), LottoNumber.pickNormalNumber("1"),
                        LottoNumber.pickNormalNumber("1"), LottoNumber.pickNormalNumber("2"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 중복된 숫자 입력하면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber(){
        Lotto lotto = Lotto.raffle(List.of(LottoNumber.pickNormalNumber("5"), LottoNumber.pickNormalNumber("1"),
                        LottoNumber.pickNormalNumber("2"), LottoNumber.pickNormalNumber("4"),
                        LottoNumber.pickNormalNumber("3"), LottoNumber.pickNormalNumber("6")));

        assertThatThrownBy(() -> lotto.addBonusNumber(LottoNumber.pickBonusNumber("3")))
                .isInstanceOf(IllegalArgumentException.class);  }
}