package lotto.collaboration.lottos;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.io.lottos.DuplicateLottosRandoms;
import lotto.io.lottos.NotSixLottosRandoms;
import lotto.io.lottos.SuccessLottosRandoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// COMMENT : 이 코드를 참고하라고 했지 변경하지 말라고는 안했으니까 변경해도 되겠지?
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

    @Test
    void make를_통해서_로또번호_생성가능() {
        assertThatNoException()
                .isThrownBy(() -> Lotto.make(new SuccessLottosRandoms()));
    }

    @Test
    void make를_통해서_중복에대해_예외처리가능() {
        assertThatThrownBy(() -> Lotto.make(new DuplicateLottosRandoms()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void make를_통해서_숫자개수가맞지않는경우에대해_예외처리가능() {
        assertThatThrownBy(() -> Lotto.make(new NotSixLottosRandoms()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}