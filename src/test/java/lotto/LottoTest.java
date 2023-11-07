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

    @DisplayName("대괄호 안에 로또 번호를 쉼표, 띄어쓰기로 구분하여 출력한다.")
    @Test
    void printLottos() {
        Application application = new Application();

        List<Lotto> lottos = List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)));

        application.printLottos(lottos);

        assertThat(output()).isEqualTo("[8, 21, 23, 41, 42, 43]\r\n" + "[3, 5, 11, 16, 32, 38]\r\n"
                + "[7, 11, 16, 35, 36, 44]\r\n" + "[1, 8, 11, 31, 41, 42]");
    }

    @DisplayName("로또 번호를 오름차순으로 정렬해 보여준다.")
    @Test
    void sortListByAscending() {
        List<Integer> numbers = List.of(21, 8, 23, 43, 42, 41);
        Lotto lotto = new Lotto(numbers);

        String result = lotto.toString();

        assertThat(result).isEqualTo("[8, 21, 23, 41, 42, 43]");
    }

    @Override
    protected void runMain() {

    }
}