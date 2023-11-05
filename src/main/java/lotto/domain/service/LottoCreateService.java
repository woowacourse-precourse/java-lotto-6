package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.entity.Order;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import lotto.domain.util.generator.LottoNumberGenerator;

public class LottoCreateService {
    /**
     * 구매 금액을 통해 구매할 수 있는 개수만큼 로또 발행(번호는 랜덤)
     *
     * @param order 주문 정보
     * @return 발행된 로또들
     */
    public List<Lotto> purchaseLottos(Order order) {
        int purchasedLottoNumber = order.getNumberOfPurchaseLotto();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasedLottoNumber; i++) {
            List<Integer> numbers = LottoNumberGenerator.createRandom();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    /**
     * 당첨 번호 생성
     *
     * @param numbers
     * @param bonusNumber 보너스 번호
     * @return 당첨 번호
     */
    public WinningLotto createWinningLotto(List<Integer> numbers, Integer bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
}
