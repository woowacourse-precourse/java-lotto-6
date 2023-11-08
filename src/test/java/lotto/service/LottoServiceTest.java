package lotto.service;

import lotto.constant.LottoRank;
import lotto.domain.DefualtLottoNumbersGenerator;
import lotto.domain.Lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @Test
    @DisplayName("구입되는 로또의 수량은 구매금액에서 로또가격을 나눈 값이어야 한다.")
    void buyLotto() {
        LottoService lottoService = new LottoService(new LottoFactory(new DefualtLottoNumbersGenerator()));
        int money = 5000;

        List<Lotto> lottos = lottoService.buyLotto(5000);
        assertThat(lottos.size()).isEqualTo(money / LOTTO_PRICE);
    }

    @Test
    @DisplayName("로또 게임의 결과가 올바르게 반환되는지 테스트1 : 로또구입 갯수 확인")
    void getResultOfLottos() {
        LottoService lottoService = new LottoService(new LottoFactory(new DefualtLottoNumbersGenerator()));
        lottoService.buyLotto(LOTTO_PRICE * 10); //로또 10장 구입

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoGameResult result = lottoService.getResultOfLottos(winningLotto, bonusNumber);

        int lottoCount = 0;
        for (LottoRank rank : LottoRank.values()) {
            lottoCount += result.getCountOfRank(rank);
        }

        assertThat(lottoCount).isEqualTo(10); // 10장 구입
    }

    @Test
    @DisplayName("로또 게임의 결과가 올바르게 반환되는지 테스트2 : 로또 적중 확인")
    void getResultOfLottos2() {
        //로또 번호가 1,2,3,4,5,6만 생성되는 서비스
        LottoService lottoService = new LottoService(new LottoFactory(()-> List.of(1,2,3,4,5,6)));

        int lottoCount = 5;
        lottoService.buyLotto(LOTTO_PRICE * lottoCount); // [1,2,3,4,5,6] 로또 5장 구입
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 44, 45)); // 4개 일치-> 4등 : 50,000 * 5 = 25만원 수익
        int bonusNumber = 5;

        LottoGameResult lottoGameResult = lottoService.getResultOfLottos(winningLotto, bonusNumber);

        int numberOfFourth = lottoGameResult.getCountOfRank(LottoRank.FOURTH);
        int numberOfFifth = lottoGameResult.getCountOfRank(LottoRank.FIFTH);
        long totalProfit = (int) (numberOfFourth * LottoRank.FOURTH.getRewardMoney());

        assertThat(numberOfFourth).isEqualTo(lottoCount);
        assertThat(numberOfFifth).isEqualTo(0);
        assertThat(totalProfit).isEqualTo(25_0000);
    }
}