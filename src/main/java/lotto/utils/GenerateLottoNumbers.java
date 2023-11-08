package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumbers {

    public static List<UserLotto> generateLottoNumbers(int buyingPrice) {
        List<UserLotto> lottos = buyingLottos(getBuyingQuantity(buyingPrice));
        return lottos;
    }

    public static int getBuyingQuantity(int buyingPrice) {
        return buyingPrice / Constants.LOTTO_PRICE;
    }

    public static List<UserLotto> buyingLottos(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_RANGE_NUMBER, Constants.MAX_RANGE_NUMBER, Constants.DESIGNATED_LOTTO_LENGTH);
            lottos.add(new UserLotto(sortedList(lottoNumbers)));
        }
        return lottos;
    }

    public static List<Integer> sortedList(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        return sortedList;
    }
}
