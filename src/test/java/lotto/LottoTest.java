package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {

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

    @DisplayName("로또 생성에 성공한다.")
    @Test
    void createLotto() {
        Application application = new Application();
        assertThatCode(() -> application.createLotto())
                .doesNotThrowAnyException();
    }

    @DisplayName("구매 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void createLottosByPurchaseAmount() {
        int purchaseAmount = 8000;

        List<Lotto> lottos = Application.createLottos(purchaseAmount);

        assertThat(lottos.size()).isEqualTo(purchaseAmount / LottoNumbers.PURCHASE_AMOUNT_UNIT);
    }

    @DisplayName("구매한 로또 개수를 출력한다.")
    @Test
    void printPurchaseCount() {
        Application application = new Application();
        int purchaseCount = 8;

        application.printPurchaseCount();

        assertThat(output()).contains("개를 구매했습니다.");
    }

    @Override
    protected void runMain() {

    }
}