package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @Test
    void 구입_금액에_해당하는_로또_수량_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        int numberOfLotto = 5;
        int purchaseAmount = numberOfLotto * lottoMachine.LOTTO_PRICE;
        List<Lotto> lottoTickets = lottoMachine.purchaseLottos(purchaseAmount);

        assertEquals(numberOfLotto, lottoTickets.size());
    }

    @Test
    void 로또_티켓_중복값_없는_6개의_번호_생성_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lottoTicket = lottoMachine.generateLotto();

        long uniqueNumbers = lottoTicket.getNumbers().stream().distinct().count();

        assertEquals(6, uniqueNumbers);
    }
}