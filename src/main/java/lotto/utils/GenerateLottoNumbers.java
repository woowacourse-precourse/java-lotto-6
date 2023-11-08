package lotto.utils;

import lotto.domain.UserLotto;

import java.util.List;

public class GenerateLottoNumbers {

    public static List<UserLotto> generateLottoNumbers(int buyingPrice) {
        List<UserLotto> lottos = buyingLottos(getBuyingQuantity(buyingPrice));
        return lottos;
    }
}
