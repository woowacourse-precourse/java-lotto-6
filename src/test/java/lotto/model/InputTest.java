package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력_모델_변환_테스트")
class InputTest {

    @Test
    @DisplayName("올바른_생성_테스트")
    void correctCase() {
        Input inputNums = new Input("1,2,3,4,5,6");
        Input inputBonus = new Input("7");
        Assertions.assertThatCode(() -> {
                    List<Integer> nums = inputNums.ofNums();
                    int bonus = inputBonus.ofBonus(nums);
                    new WinningLotto(new Lotto(nums), bonus);
                })
                .doesNotThrowAnyException();

    }

    @Test
    @DisplayName("당첨_로또_문자_에외")
    void WinnerLottoEx1() {
        Input inputNums = new Input("1,a,3,4,5,6");
        Input inputBonus = new Input("7");
        Assertions.assertThatThrownBy(() -> {
                    List<Integer> nums = inputNums.ofNums();
                    int bonus = inputBonus.ofBonus(nums);
                    new WinningLotto(new Lotto(nums), bonus);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Input.INPUT_POSITIVE_ERROR);
    }

    @Test
    @DisplayName("보너스_번호_로또_범위_예외")
    void WinnerLottoEx2() {
        Input inputNums = new Input("1,2,3,4,5,6");
        Input inputBonus = new Input("52");
        Assertions.assertThatThrownBy(() -> {
                    List<Integer> nums = inputNums.ofNums();
                    int bonus = inputBonus.ofBonus(nums);
                    new WinningLotto(new Lotto(nums), bonus);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Input.LOTTO_RANGE_ERROR);
    }

    @Test
    @DisplayName("보너스_번호_당첨_중복_예외")
    void WinnerLottoEx3() {
        Input inputNums = new Input("1,2,3,4,5,6");
        Input inputBonus = new Input("2");
        Assertions.assertThatThrownBy(() -> {
                    List<Integer> nums = inputNums.ofNums();
                    int bonus = inputBonus.ofBonus(nums);
                    new WinningLotto(new Lotto(nums), bonus);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Input.BONUS_DUPLICATE_ERROR);
    }

}