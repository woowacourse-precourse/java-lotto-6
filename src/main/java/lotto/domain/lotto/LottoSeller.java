package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.money.Money;
import lotto.domain.money.Wallet;

/**
 * 사용자가 Money로 로또를 구매할 수 있는 로또 판매점을 표현
 */
public final class LottoSeller {

    /**
     * 로또 장당 가격
     */
    public static final Money LOTTO_PRICE = Money.from(1_000);

    /**
     * 판매하기 위한 랜덤 로또 생성기 현재는 자동 발행 방식만 사용
     */
    private final LottoGenerator lottoGenerator;

    /**
     * LottoSeller 생성자, LottoGenerator interface type instance를 외부에서 주입받아야 하며, 용도에 따라 교체될 수 있습니다.
     */
    public LottoSeller(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    /**
     * 사용자의 소지금으로 로또를 전부 구매합니다. 구매한 로또는 Lottos 일급 컬렉션에 넣어 반환합니다.
     */
    public Lottos buyUntilOutOfMoney(final Wallet wallet) {
        final List<Lotto> lottos = _buyUntilOutOfMoney(new ArrayList<>(), wallet);
        return new Lottos(lottos);
    }

    /**
     * 소지금이 떨어져 로또를 더 이상 살 수 없을 때까지 계속해서 재귀 호출하며 로또를 리스트에 추가합니다.
     */
    private List<Lotto> _buyUntilOutOfMoney(
            final List<Lotto> lottos,
            final Wallet wallet
    ) {
        if (canBuyLotto(wallet)) {
            lottos.add(buyLotto(wallet));
            return _buyUntilOutOfMoney(lottos, wallet);
        }
        return lottos;
    }

    /**
     * 로또 한 장을 구매하고 소지금에서 1,000원을 제합니다.
     */
    private Lotto buyLotto(final Wallet wallet) {
        wallet.spend(LOTTO_PRICE);
        return lottoGenerator.generate();
    }

    /**
     * 로또를 살 소지금이 충분한지 판단합니다.
     */
    private boolean canBuyLotto(final Wallet wallet) {
        return wallet.hasEqualOrMoreThan(LOTTO_PRICE);
    }
}
