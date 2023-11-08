package lotto.Service;

import static lotto.config.LottoConfig.LOTTO_AMOUNT;

import lotto.domain.Lottos;

/**
 * 로또 진행 과정에 필요한 작업을 진행하는 클래스
 */
public class LottoService {

    /**
     * 구매 금액을 받아 Lotto 객체를 반환
     * @param amount 로또 구입 금액
     * @return 구입 개수만큼 생성된 Lotto 객체들
     */
    public Lottos getLottos(Integer amount) {
        Integer lottoCount = amount / LOTTO_AMOUNT.getValue();

        return new Lottos(lottoCount);
    }
}
