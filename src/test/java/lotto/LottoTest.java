package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Model.Lotto;
import lotto.Model.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("사용자 당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createUserLottoByDuplicatedNumber(){
        assertThatThrownBy(() -> new UserLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("사용자 보너스번호가 당첨번호에 중복된 숫자가 존재하는 경우 예외 발생 및 출력메시지")
    @Test
    void createUserLottoBonusDuplicatedNumber(){
        assertThatThrownBy(() ->
                new UserLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}