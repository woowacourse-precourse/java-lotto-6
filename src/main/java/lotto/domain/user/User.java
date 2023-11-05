package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;

import java.util.List;

/**
 * 사용자 클래스
 */
public class User {
    LottoEnvelop lottoEnvelop;

    /**
     * 로또를 받는다.
     *
     * @param lottoEnvelop 로또들의 모임
     */
    public void takeLottoEnvelop(LottoEnvelop lottoEnvelop) {
        this.lottoEnvelop = lottoEnvelop;
    }


    /**
     * 로또를 보여준다.
     *
     * @param lottoEnvelop 현제 로또들의 모임
     * @return
     */
    public List<Integer> showLottos(List<Lotto> lottoEnvelop) {
        return null;
    }

    /**
     * 로또결과의 당첨에 대한 통계를 한다.
     *
     * @param successLottos 당첨된 로또들의 모임
     * @return
     */
    public List<Integer> doStatisticLottoResult(List<Lotto> successLottos) {

        return null;
    }

    /**
     * 로또결과의 당첨에 대한 총 수익률을 계산한다.
     *
     * @param successLottos 당첨된 로또들의 모임
     * @return
     */
    public Double calculateTotalRate(List<Lotto> successLottos) {
        return null;
    }
}
