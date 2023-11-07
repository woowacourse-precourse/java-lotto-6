package lotto.util.validate;

import static lotto.lotto.model.LottoConstant.*;

import java.util.List;

import lotto.lotto.model.Lotto;
import lotto.util.error.CustomError;

public class LottoValidate {
    public static void checkLottos(List<Lotto> lottos){
        try{
            for(Lotto lotto : lottos){
                checkLottoCount(lotto);
                checkLottoAsc(lotto);
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    private static void checkLottoCount(Lotto lotto){
        if(lotto.length() != MAX_INPUT_NUMBER)
            throw new IllegalArgumentException(CustomError.INPUT_MAX_NUMBER.getError());
    }

    private static void checkLottoAsc(Lotto lotto){
        int temp = 0;
        for(int i=0;i<lotto.length();i++){
            int number = lotto.get(i);
            if(temp > number)
                throw new IllegalArgumentException(CustomError.LOTTO_IS_NOT_ASCENDING.getError());
            temp = lotto.get(i);
        }
    }
}
