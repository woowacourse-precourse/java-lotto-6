package lotto.model;

import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨_로또_테스트")
class WinningLottoTest {

    @Test
    @DisplayName("올바른_생성_테스트")
    void correctCase() {
        String lottoInput = "1,2,3,4,5,6";
        String bonus = "7";

        Assertions.assertThatCode(() -> new WinningLotto(lottoInput, bonus))
                .doesNotThrowAnyException();

    }

    @Test
    @DisplayName("당첨_로또_문자_에외")
    void WinnerLottoEx1() {
        String lottoInput = "1,a,3,4,5,6";
        String bonus = "7";

        Assertions.assertThatThrownBy(() -> new WinningLotto(lottoInput, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 양의 정수만 입력해주세요.");
    }

    @Test
    @DisplayName("보너스_번호_로또_범위_예외")
    void WinnerLottoEx2() {
        String lottoInput = "1,2,3,4,5,6";
        String bonus = "52";

        Assertions.assertThatThrownBy(() -> new WinningLotto(lottoInput, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 " + LOTTO_MIN_NUMBER + "이상" + LOTTO_MAX_NUMBER + "이하인 값만 입력하세요");
    }

    @Test
    @DisplayName("보너스_번호_당첨_중복_예외")
    void WinnerLottoEx3() {
        String lottoInput = "1,2,3,4,5,6";
        String bonus = "2";

        Assertions.assertThatThrownBy(() -> new WinningLotto(lottoInput, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 숫자는 당첨 번호에 포함되지 않은 숫자를 선택해야 합니다.");
    }

}