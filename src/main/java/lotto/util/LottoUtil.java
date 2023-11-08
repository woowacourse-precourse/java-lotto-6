package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;

import static lotto.constant.LottoConstant.*;

public class LottoUtil {

public static List<Lotto> generateMultiple(int count){
    List<Lotto> lottos = new ArrayList<>();
    for (int i=0; i<count; i++){
        lottos.add(generate());
    }
    return lottos;
}

public static Lotto generate(){
    return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue(), LOTTO_SIZE.getValue()));
}

public static boolean isNumberInRange(int number){

    return (number >= LOTTO_NUMBER_MIN.getValue() && number <= LOTTO_NUMBER_MAX.getValue());
}
}
