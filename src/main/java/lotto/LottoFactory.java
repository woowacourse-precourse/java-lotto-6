package lotto;

import camp.nextstep.edu.missionutils.*;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static List<Lotto> getLottoListByPrice(int price){
        validatePrice(price);
        int numOfLottos = price % Lotto.PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numOfLottos; i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE, Lotto.SIZE );
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
    private static void validatePrice(int price){
        Validator.validateNatural(price);
        Validator.validateMultiplesOfK(price, Lotto.PRICE);
    }
}
