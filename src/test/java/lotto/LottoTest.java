package lotto;

import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Test
    @DisplayName("발행한 로또 수량 및 번호를 출력한다.")
    void printLottoNumbers() {
        OutputView.printPurchaseQuantityMessage(8);
        OutputView.printLottoNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("당첨내역을 출력한다.")
    void printWinningStatistics() {
        OutputView.printWinningStatistics(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
    }
}