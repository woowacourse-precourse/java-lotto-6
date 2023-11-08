package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.LottoMachine;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class LottoMachineTest {
    @Test
    void 받은_금액만큼_로또티켓_생성여부_검사() {
        LottoMachine.setMoney(5000);
        LottoMachine.givingLottoTickets();
        List<Lotto> totalLottoTickets = LottoMachine.getTotalLottoTickets();
        assertThat(totalLottoTickets).hasSize(5);
    }

    @Test
    void 로또번호_생성메소드_개수와_범위_검사() {
        List<Integer> numbers = LottoMachine.pickRandomLottoNumbers();
        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(n -> n >= 1 && n <= 45);
    }

    @Test
    void 로또번호_생성메소드_중복여부_검사() {
        List<Integer> numbers = LottoMachine.pickRandomLottoNumbers();
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    void 입력된_금액의_단위_유효성_검사() {
        boolean result = LottoMachine.validateMoney("5500");
        assertThat(result).isFalse();
    }

    @Test
    void 입력된_금액의_범위_유효성_검사() {
        boolean result = LottoMachine.validateMoney("-1000");
        assertThat(result).isFalse();
    }
    @Test
    void 입력된_금액이_숫자가_아닌_경우_검사() {
        boolean result = LottoMachine.validateFormat("hello");
        assertThat(result).isFalse();
    }
}
