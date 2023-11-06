package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    public List<Integer> initLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Numbers.INIT_NUMBER_START.getNumber(),Numbers.INIT_NUMBER_END.getNumber(), Numbers.INIT_NUMBER_COUNT.getNumber());
        return numbers;
    }


}
