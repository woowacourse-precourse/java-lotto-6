package lotto;

import static lotto.validation.Validation.isNumberInList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.service.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("구입금액이 숫자가 아닌 경우")
    @Test
    void isInvalidNumberTest() {
        assertThatThrownBy(() -> new LottoAmount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 숫자가 0 인 경우")
    @Test
    void isZeroInputTest() {
        assertThatThrownBy(() -> new LottoAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("구입금액이 1,000원으로 나누어떨어지지 않는 경우")
    @Test
    void isNotDivisibleByThousandTest() {
        assertThatThrownBy(() -> new LottoAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1~45 사이의 값이 아닌 경우")
    @Test
    void validateNumberRangeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 56)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 이 숫자가 아닌 경우")
    @Test
    void validateNumbersTest() {
        Service service = new Service();
        assertThatThrownBy(() -> service.splitStringToIntegerList("1,a,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호 중 중복인 경우")
    @Test
    void isNumberInListTest() {

        int validNumber = 5;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> isNumberInList(winningNumbers, validNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

