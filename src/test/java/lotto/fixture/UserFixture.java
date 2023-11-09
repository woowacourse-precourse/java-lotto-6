package lotto.fixture;

import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.User;

import java.util.List;

import static lotto.fixture.LottoFixture.NONE;
import static lotto.fixture.LottoFixture.WINNING;
import static lotto.fixture.PurchaseFixture.두장;
import static lotto.fixture.PurchaseFixture.세장;

public enum UserFixture {
    총_2장_구매_당첨_X_유저(List.of(NONE, NONE), 두장),
    총_3장_구매_1등_한장_유저(List.of(NONE, NONE, WINNING), 세장);

    private final List<LottoFixture> lottoFixtures;
    private final PurchaseFixture purchaseFixture;

    UserFixture(final List<LottoFixture> lottoFixtures, final PurchaseFixture purchaseFixture) {
        this.lottoFixtures = lottoFixtures;
        this.purchaseFixture = purchaseFixture;
    }

    public User 생성() {
        final List<Lotto> lottos = lottoFixtures.stream()
                .map(LottoFixture::생성)
                .toList();

        final Purchase purchase = purchaseFixture.생성();
        return new User(lottos, purchase);
    }
}
