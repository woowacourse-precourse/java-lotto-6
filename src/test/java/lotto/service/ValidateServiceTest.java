package lotto.service;

import lotto.view.GameView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidateServiceTest {

    private GameView gameView = new GameView();
    private ValidateService validateService = new ValidateService();

    @Test
    @DisplayName("1000원 단위의 숫자 정상 입력")
    void 로또_구매_숫자_1000원_단위_정상_입력() {
        int buyPrice = validateService.validateBuyLottoInput("14000");
        assertThat(buyPrice).isEqualTo(14000);
    }

    @Test
    @DisplayName("1000원 단위의 숫자 바정상 입력")
    void 로또_구매_숫자_1000원_단위_비정상_입력() {
        assertThatThrownBy(() -> validateService.validateBuyLottoInput("14350"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구매_문자_입력() {
        assertThatThrownBy(() -> validateService.validateBuyLottoInput("문자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_정상_입력() {
        List<Integer> winNumbers = validateService.createWinNumbers("1,2,3,4,5,6");
        assertThat(winNumbers.size()).isEqualTo(6);
        assertThat(winNumbers).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨_번호_5개_입력() {
        assertThatThrownBy(() -> validateService.createWinNumbers("1,2,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_7개_입력() {
        assertThatThrownBy(() -> validateService.createWinNumbers("1,2,3,5,6,8,9"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_중복_입력() {
        assertThatThrownBy(() -> validateService.createWinNumbers("1,2,3,5,9,9"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}