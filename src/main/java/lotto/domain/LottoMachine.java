package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.ConstantValue.*;

public class LottoMachine {

    public static List<Lotto> generateLottoByPurchaseAmount(Integer purchaseAmount){
        List<Lotto> lottos = new ArrayList<>();
        int count = convertPurchaseAmountToCount(purchaseAmount);
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private static int convertPurchaseAmountToCount(Integer purchaseAmount){
        return purchaseAmount / LOTTO_PRICE;
    }

    private static List<Integer> generateLottoNumbers(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBERS_SIZE);
        return lottoNumbers.stream().sorted().toList();
    }
}
