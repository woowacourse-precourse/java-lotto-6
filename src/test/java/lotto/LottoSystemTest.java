package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void 입력받은_보너스_번호가_45보다_큰경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String bonusNumber = "46";
        assertThatThrownBy(() -> lottoSystem.getBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_보너스_번호가_당첨된_번호와_중복되는_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 1;
        assertThatThrownBy(() -> lottoSystem.bonusNumberOverlap(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 구매한_로또_중_순위_별로_당첨된_로또의_개수(){
        LottoSystem lottoSystem = new LottoSystem();
        List<Integer> winNumber = List.of(4,5,6,10,11,12);
        int bonus = 3;
        ArrayList<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottoNumbers.add(new Lotto(List.of(4,5,6,7,8,9)));
        int[] answer = lottoSystem.lottoWinCheck(lottoNumbers, winNumber, bonus);

        assertThat(answer).containsExactly(2,0,0,0,0);
    }

    @Test
    void 구매한_로또_중_2등이_포함되어있는_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        List<Integer> winNumber = List.of(4,5,6,10,11,12);
        int bonus = 7;
        ArrayList<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottoNumbers.add(new Lotto(List.of(4,5,6,7,10,11)));
        int[] answer = lottoSystem.lottoWinCheck(lottoNumbers, winNumber, bonus);

        assertThat(answer).containsExactly(1,0,0,1,0);
    }

    @Test
    void 구매한_로또_번호와_당첨된_로또_번호가_같은_번호의_개수(){
        LottoSystem lottoSystem = new LottoSystem();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lottoSystem.lottoEqualNumber(3, lotto, 6))
                .isEqualTo(0);
    }

    @Test
    void 구매한_로또_번호와_당첨된_로또_번호의_개수가_5개_일_때_보너스_번호가_구매번호에_포함되어_있는_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lottoSystem.lottoEqualBonusNumber(5, lotto, 6))
                .isEqualTo(3);
    }

    @Test
    void 구매한_로또_번호와_당첨된_로또_번호의_개수가_5개_일_때_보너스_번호가_구매번호에_없는_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lottoSystem.lottoEqualBonusNumber(5, lotto, 7))
                .isEqualTo(2);
    }

    @Test
    void 당첨된_로또의_총_상금(){
        LottoSystem lottoSystem = new LottoSystem();
        int[] winLotto = {1,1,1,0,0};
        assertThat(lottoSystem.winningTotalMoney(winLotto))
                .isEqualTo(1555000);
    }
}

