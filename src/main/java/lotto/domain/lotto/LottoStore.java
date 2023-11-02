package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.money.Money;

/**
 * 사용자가 Money로 로또를 구매할 수 있는 로또 판매점을 표현
 */
public final class LottoStore {

    /**
     * 로또 장당 가격
     */
    private static final int LOTTO_PRICE = 1_000;

    /**
     * 판매하기 위한 랜덤 로또 생성기 현재는 자동 발행 방식만 사용
     */
    private final RandomLottoGenerator lottoGenerator;

    public LottoStore(final RandomLottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    /**
     * 사용자의 소지금으로 로또를 전부 구매합니다. 구매한 로또는 Lottos 일급 컬렉션에 넣어 반환합니다.
     */
    public Lottos buyUntilOutOfMoney(final Money money) {
        final List<Lotto> lottos = _buyUntilOutOfMoney(new ArrayList<>(), money);
        return new Lottos(lottos);
    }

    /**
     * 소지금이 떨어져 로또를 더 이상 살 수 없을 때까지 계속해서 재귀 호출하며 로또를 리스트에 추가합니다.
     */
    private List<Lotto> _buyUntilOutOfMoney(
            final List<Lotto> lottos,
            final Money money
    ) {
        if (cannotBuyLotto(money)) {
            return lottos;
        }
        lottos.add(buyLotto(money));
        return _buyUntilOutOfMoney(lottos, money);
    }

    /**
     * 로또 한 장을 구매하고 소지금에서 1,000원을 제합니다.
     */
    private Lotto buyLotto(final Money money) {
        money.spend(LOTTO_PRICE);
        return lottoGenerator.generate();
    }

    /**
     * 로또를 살 소지금이 충분한지 판단합니다.
     */
    private boolean cannotBuyLotto(final Money money) {
        return money.isLessThan(LOTTO_PRICE);
    }
}
