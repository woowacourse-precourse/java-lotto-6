package lotto;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("구입 금액이 1000원 미만이거나 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyLessThanThousand() {
        assertThatThrownBy(() -> Validators.validateMoneyIsThousands(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputWinningNumberNotInteger() {
        assertThatThrownBy(() -> Validators.validateStringIsIntegerConvertable("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void inputDuplicatedWinningNumber() {
        assertThatThrownBy(() -> Validators.validateDuplicated(List.of(1,2,2,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 구분되고 6개가 아니면 예외가 발생한다.")
    @Test
    void inputOverSizeWinningNumber() {
        assertThatThrownBy(() -> Validators.validateSixNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validators.validateSixNumbers("1#2#3#4#5#6#"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45 사이에 있지 않으면 예외가 발생한다.")
    @Test
    void winningNumberOutOfRange() {
        assertThatThrownBy(() -> Validators.validateNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validators.validateNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validators.validateNumberRange(77))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void bonusIsContainedInWinningNumber() {
        assertThatThrownBy(() -> Validators.validateBonusNumberDuplicated(3 ,List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void bonusNotInteger() {
        assertThatThrownBy(() -> Validators.validateStringIsIntegerConvertable("$^%3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 올바르게 비교하는 지 확인한다.")
    @Test
    void checkCompareLottoAndWinningNumbers() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        List<Integer> winningNumbers = List.of(1,2,3,10,11,12);
        int count = Prize.compare(lottoNumbers,winningNumbers);
        assertThat(Integer.toString(count)).isEqualTo("3");
    }
}