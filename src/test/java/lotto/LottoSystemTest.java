package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoSystemTest {
    @Test
    void 구입한_금액이_1000으로_나누었을_떄_나머지가_있는_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String money = "1100";
        assertThatThrownBy(() -> lottoSystem.buyLottoTicket(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_금액이_0인_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String money = "0";
        assertThatThrownBy(() -> lottoSystem.buyLottoTicket(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_금액이_잘못된_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String money = "1000j";
        assertThatThrownBy(() -> lottoSystem.buyLottoTicket(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_당첨_로또_번호가_6개보다_적은_경우() {
        LottoSystem lottoSystem = new LottoSystem();
        String number = "1,2,3,4,5";

        assertThatThrownBy(() -> lottoSystem.getWinningNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_당첨_로또_번호가_잘못된_경우() {
        LottoSystem lottoSystem = new LottoSystem();
        String number = "1,2,3,4,5,six";

        assertThatThrownBy(() -> lottoSystem.getWinningNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_당첨_로또_번호가_6개보다_많은_경우() {
        LottoSystem lottoSystem = new LottoSystem();
        String number = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> lottoSystem.getWinningNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_당첨_로또_번호에_띄어쓰기가_있는_경우() {
        LottoSystem lottoSystem = new LottoSystem();
        String number = "1, 2, 3, 4, 5, 6";

        assertThatThrownBy(() -> lottoSystem.getWinningNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_보너스_번호가_잘못된_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String bonusNumber = "A";

        assertThatThrownBy(() -> lottoSystem.getBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_보너스_번호가_1보다_작은_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String bonusNumber = "0";
        assertThatThrownBy(() -> lottoSystem.getBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

