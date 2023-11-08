package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    @DisplayName("로또 금액이 숫자가 아닐경우 예외처리한다.")
    @Test
    void putLetterAtMoney() {
        assertThatThrownBy(() -> new LottoService().setMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 숫자가 요구된 단위가 아닐경우 예외처리한다.")
    @Test
    void checkAmountOfMoney() {
        assertThatThrownBy(() -> new LottoService().setMoney("5560"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 값만큼의 로또를 구매한다.")
    @Test
    void purchaseLotto() {
        LottoService lottoService = new LottoService();
        lottoService.setMoney("5000");
        lottoService.buyLotto();
        assertThat(lottoService.getUser().getLottos().size())
                .isEqualTo(5);
    }

    @DisplayName("로또를 맞춘 갯수에 따라 금액을 배정한다.")
    @Test
    void matchLotto() {
        LottoService lottoService = new LottoService();
        lottoService.getUser()
                .setLottos(new ArrayList(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))));
        lottoService.setWinningNumbers("1,2,3,4,5,6");
        lottoService.setBonusNumber("7");
        assertThat(lottoService.getNumberMatches().get(Prizes.First)).isEqualTo(1);
    }
    
}
