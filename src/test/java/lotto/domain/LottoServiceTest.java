package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    Buyer buyer;
    LottoNumber lottoNumber = new LottoNumber();
    LottoService lottoService = new LottoService();
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,8); // 구매자 로또 번호
    Lotto lotto = new Lotto(numbers);
    List<Lotto> buyerLottoTickets = new ArrayList<>();

    @BeforeEach
    void beforeEachTest() {
        buyerLottoTickets.add(lotto);
    }

    @DisplayName("구매자의 로또 번호와 당첨 번호를 비교하여 일치하는 번호를 확인한다.")
    @Test
    void confirmMatchNumbersByCompareWiningNumbers() {
        buyer = new Buyer(1000, 1, buyerLottoTickets);
        lottoNumber.drawWiningNumbers("1,2,3,4,5,6"); // 당첨 번호
        lottoNumber.drawBonusNumber("7"); // 보너스 번호

        lottoService.compareLottoNumber(buyer, lottoNumber);

        assertThat(lottoService.getMatchNumbers()).containsExactly(1,2,3,4,5); // 일치하는 번호 확인
    }

    @DisplayName("구매자의 로또 번호와 당첨 번호를 비교하여 일치하지 않는 번호를 확인한다.")
    @Test
    void checkNotMatchNumbersByCompareWiningNumbers() {
        buyer = new Buyer(1000, 1, buyerLottoTickets);
        lottoNumber.drawWiningNumbers("1,2,3,4,5,6"); // 당첨 번호
        lottoNumber.drawBonusNumber("7"); // 보너스 번호

        lottoService.compareLottoNumber(buyer, lottoNumber);

        assertThat(lottoService.getNotMatchNumbers()).containsExactly(8); // 일치하지 않는 번호 확인
    }

    @DisplayName("일치하지 않는 번호가 하나일 때 보너스 번호와 일치 하는지 확인한다.")
    @Test
    void checkMatchBonusNumber() {
        buyer = new Buyer(1000, 1, buyerLottoTickets);
        lottoNumber.drawWiningNumbers("1,2,3,4,5,6"); // 당첨 번호
        lottoNumber.drawBonusNumber("8"); // 보너스 번호

        lottoService.compareLottoNumber(buyer, lottoNumber);

        assertThat(lottoService.getNotMatchNumbers().size()).isEqualTo(1); // 일치하지 않는 번호 하나 확인
        assertThat(lottoService.getBonusMatch()).isEqualTo(true); // 보너스 번호 일치 여부 확인
    }

    @DisplayName("보너스 번호가 일치하지 않을 경우 false를 반환한다.")
    @Test
    void checkBonusMatchFalse() {
        buyer = new Buyer(1000, 1, buyerLottoTickets);
        lottoNumber.drawWiningNumbers("1,2,3,4,5,6"); // 당첨 번호
        lottoNumber.drawBonusNumber("7"); // 보너스 번호

        lottoService.compareLottoNumber(buyer, lottoNumber);

        assertThat(lottoService.getBonusMatch()).isEqualTo(false); // 보너스 번호 false 여부 확인
    }

    @DisplayName("당첨 번호와 보너스 일치 여부를 확인해서 해당되는 당첨 기준을 카운트 한다.")
    @Test
    void countRankByCompareLottoNumbers() {
        buyer = new Buyer(1000, 1, buyerLottoTickets);
        lottoNumber.drawWiningNumbers("1,2,3,4,5,6"); // 당첨 번호
        lottoNumber.drawBonusNumber("8"); // 보너스 번호

        lottoService.compareLottoNumber(buyer, lottoNumber);

        assertThat(lottoService.getWiningDetails().get(WiningRank.SECOND)).isEqualTo(1); // 2등 당첨 카운트 확인
    }
}