package lotto;

import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.manager.LottoManager;
import lotto.utils.ParseUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호가 1~45 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 입력된 값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByType() {
        ParseUtils parseUtils = new ParseUtils();
        assertThatThrownBy(() -> parseUtils.parseStringToInt("가"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 겹칠 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicate() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningLotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 투입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createPayMoneyByType() {
        ParseUtils parseUtils = new ParseUtils();
        assertThatThrownBy(() -> parseUtils.parseStringToInt("한글"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 투입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createPayMoneyByUnit() {
        int payMoney = 1200;
        LottoManager lottoManager = new LottoManager();
        assertThatThrownBy(() -> lottoManager.setBuyLottos(payMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("투입한 금액에 맞게 로또가 구매되는지 확인")
    @Test
    void buyLotto() {
        LottoManager lottoManager = new LottoManager();

        int payMoney = 10000;
        lottoManager.setBuyLottos(payMoney);

        Assertions.assertEquals(payMoney/ Value.LOTTO_TICKET_PRICE, lottoManager.getBuyLottos().size());
    }

    @DisplayName("로또 결과가 정상적으로 출력되는 지 화깅ㄴ")
    @Test
    void resultTest() {
//        winning을 buyLotto에서 3가지 값만 가져와서 저장하고 나머지는 0으로 세팅...이 안되네
//        안겹치는 값으로 세팅해서 확인하자...싯팔...
    }

}