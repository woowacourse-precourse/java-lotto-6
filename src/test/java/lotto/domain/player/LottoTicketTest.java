package lotto.domain.player;

import static lotto.domain.player.LottoTicket.makeZeroLottoTicket;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.playermoney.PlayerWallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    private LottoTicket lottoTicket;
    private PlayerWallet playerWallet;
    private Lotto boughtLotto;
    private LottoBundle lottoBundle;

    /** 테스트 Given 상황 : 0개의 LottoTicket, 10,000원 초기 금액의 PlayerWallet 생성 후
     *                   10,000을 소비해 티켓 구매
     *                   구매할 Lotto 및 Lotto를 저장할 LottoBundle 생성
     */
    @BeforeEach
    void initData() {
        lottoTicket = makeZeroLottoTicket();
        playerWallet = new PlayerWallet(10000);
        playerWallet.consumeMoneyToLottoTicket(10000);
        boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBundle = new LottoBundle();
    }

    @DisplayName("playerWallet 에서 10,000원을 소비하면 lottoTicket 10장을 발행한다.")
    @Test
    void lottoTicketTest_1() {
        // when
        lottoTicket = lottoTicket.issueLottoTicket(playerWallet);
        // Then
        assertThat(lottoTicket.getLottoTicket()).isEqualTo(10);
    }

    @DisplayName("lottoTicket 10장을 Lotto 로 바꿔 LottoBundle 에 넣으면, 티켓은 0장이 된다.")
    @Test
    void lottoTicketTest_2() {
        // given
        lottoTicket = lottoTicket.issueLottoTicket(playerWallet);
        // when
        lottoTicket = lottoTicket.changeAllTicketToLotto(() -> boughtLotto, lottoBundle);
        // then
        assertThat(lottoTicket.getLottoTicket()).isEqualTo(0);
    }

    @DisplayName("로또 구매후 lottoBundle 를 lottoData 로 변환하면, lottoData 에는 로또 10개가 있으며 구매한 로또를 포함한다.")
    @Test
    void lottoTicketTest_3() {
        // given
        lottoTicket = lottoTicket.issueLottoTicket(playerWallet);
        // when
        lottoTicket = lottoTicket.changeAllTicketToLotto(() -> boughtLotto, lottoBundle);
        List<Lotto> lottoData = lottoBundle.makeLottoBundleDto().getLottoBundleData();
        // then
        assertThat(lottoData.size()).isEqualTo(10);
        assertThat(lottoData).contains(boughtLotto);
    }
}
