package lotto.fixture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.BonusBall;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningTicket;
import lotto.model.purchase.LottoPurchase;
import lotto.model.purchase.LottoPurchaseAmount;

public class LottoFixture {
    private LottoFixture() {
    }

    public static LottoPurchaseAmount createLottoPurchaseAmount(String amount) {
        return LottoPurchaseAmount.from(Integer.parseInt(amount));
    }

    public static LottoPurchaseAmount createLottoPurchaseAmount(int amount) {
        return LottoPurchaseAmount.from(amount);
    }

    public static Lotto createLotto(int n1, int n2, int n3, int n4, int n5, int n6) {
        return new Lotto(Arrays.asList(n1, n2, n3, n4, n5, n6));
    }

    public static List<Lotto> createLottos(int size) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(lotto);
        }
        return lottos;
    }

    public static LottoPurchase createLottoPurchase(LottoPurchaseAmount amount, List<Lotto> lottos) {
        return new LottoPurchase(amount, lottos);
    }

    public static BonusBall createBonusBall(int number) {
        return new BonusBall(number);
    }

    public static WinningTicket createWinningLotto(Lotto lotto, BonusBall bonusBall) {
        return new WinningTicket(lotto, bonusBall);
    }
}
