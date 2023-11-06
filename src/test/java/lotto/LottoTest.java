package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("잘못된 금액을 입력하면 예외가 발생한다.")
    @Test
    void validateCorrectPrice() {
        assertThatThrownBy(() -> Integer.parseInt("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지는 금액을 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputThousandPrice() {
        assertThatThrownBy(() -> InputView.validateNum(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 1부터 45 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void validateLottoNumBetween() {
        assertThatThrownBy(() -> InputView.validateLottoNum("1,2,3,4,5,48"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}