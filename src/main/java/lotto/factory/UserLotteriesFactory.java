package lotto.factory;

import static lotto.constants.LottoNumber.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotteries;

public class UserLotteriesFactory {

    private final LottoFactory lottoFactory;

    public UserLotteriesFactory(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public UserLotteries createFromPurchaseAmount(Integer purchaseAmount) {
        Integer countOfPurchasedLotto = calculateCountOfPurchasedLotto(purchaseAmount);
        List<Lotto> userLotteries = createUserLotteries(countOfPurchasedLotto);
        return new UserLotteries(userLotteries);
    }

    private List<Lotto> createUserLotteries(Integer countOfPurchasedLotto) {
        List<Lotto> userLotteries = new ArrayList<>();
        for (int i = 0; i < countOfPurchasedLotto; i++) {
            userLotteries.add(lottoFactory.createLotto());
        }
        return userLotteries;
    }

    public static Integer calculateCountOfPurchasedLotto(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
