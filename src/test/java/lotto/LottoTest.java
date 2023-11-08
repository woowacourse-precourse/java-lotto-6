package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;
import controller.UserController;
import model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class LottoTest {
    UserController userController = new UserController();

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복된 숫자가 있습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 티켓이 사용자가 구입한 개수만큼 정상적으로 생성되는지 테스트")
    @Test
    void generateLottos() {
        LottoController lottoController = new LottoController();
        // test case
        int lottoMount = 5;

        List<Lotto> generatedLottos = lottoController.generateLottos(lottoMount);
        assertEquals(lottoMount, generatedLottos.size());
    }

    @DisplayName("로또 구입 가격을 입력하는 기능 테스트")
    @Test
    void testInvalidInputPurchasePrice() {
        assertThatThrownBy(() -> userController.inputPriceHowManyLottos())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 1,000원 단위로 입력해야 합니다.")
                .hasMessage("로또 구입 금액은 0보다 커야 합니다.")
                .hasMessage("로또 구입 금액은 숫자로만 입력해야 합니다.");
    }

    @DisplayName("사용자가 유효한 로또 번호를 입력하는 기능 테스트")
    @Test
    void testValidInput() {
        assertThatThrownBy(() -> userController.generateUserLottoNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이여야 합니다.")
                .hasMessage("로또 번호는 숫자여야 합니다.")
                .hasMessage("로또 번호는 중복 될 수 없습니다.");
    }

    @DisplayName("사용자가 유효한 로또 보너스 번호를 입력하는 기능 테스트")
    @Test
    void testValidInputBonus() {
        assertThatThrownBy(() -> userController.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이여야 합니다.")
                .hasMessage("로또 번호는 숫자여야 합니다.")
                .hasMessage("로또 번호는 중복 될 수 없습니다.");
    }
}