package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest extends NsTest {

    LottoResultService lottoResultService;
    WinningLotto winningLotto;
    List<Lotto> buyLottos;

    @BeforeEach
    void setWinningLotto() {
        lottoResultService = new LottoResultService();
        winningLotto = new WinningLotto(List.of(1,2,3,4,5,6));
        winningLotto.setBonusNumber(7);
        lottoResultService.setWinningLotto(winningLotto);

        buyLottos = new ArrayList<>();
    }

    @DisplayName("1개의 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankByNoRankOne() {
        buyLottos.add(new Lotto(List.of(1,2,7,8,9,10)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 0%입니다."
        );
    }


    @DisplayName("2개의 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankByNoRankTwo() {
        buyLottos.add(new Lotto(List.of(1,2,7,8,9,10)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 0%입니다."
        );
    }

    @DisplayName("3개의 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankByFIFTH() {
        buyLottos.add(new Lotto(List.of(1,2,3,7,8,9)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 500%입니다."
        );
    }

    @DisplayName("4개의 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankByFourth() {
        buyLottos.add(new Lotto(List.of(1,2,3,4,8,9)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 5000%입니다."
        );
    }

    @DisplayName("5개의 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankByThird() {
        buyLottos.add(new Lotto(List.of(1,2,3,4,5,9)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 150000%입니다."
        );
    }

    @DisplayName("5개의 번호와 보너스 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankBySecond() {
        buyLottos.add(new Lotto(List.of(1,2,3,4,5,7)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 3000000%입니다."
        );
    }

    @DisplayName("6개의 번호가 일치될 경우 로또 결과 확인")
    @Test
    void createLottoResultRankByOne() {
        buyLottos.add(new Lotto(List.of(1,2,3,4,5,6)));

        lottoResultService.showRank(buyLottos);
        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 200000000%입니다."
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
