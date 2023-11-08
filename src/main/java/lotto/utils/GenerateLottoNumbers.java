package lotto.utils;

import lotto.Constants;
import lotto.domain.UserLotto;

import java.util.List;

public class GenerateLottoNumbers {

    public static List<UserLotto> generateLottoNumbers(int buyingPrice) {
        List<UserLotto> lottos = buyingLottos(getBuyingQuantity(buyingPrice));
        return lottos;
    }

    public static int getBuyingQuantity(int buyingPrice) {
        return buyingPrice / Constants.LOTTO_PRICE;
    }
}
