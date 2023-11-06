package lotto.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.LottoService;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberService {
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public LottoNumberService(){
    }
    public List<LottoNumber> pickAutoNumbers(){
        return Randoms.pickUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE, LOTTO_NUMBERS_SIZE)
                .stream().map(LottoNumber::fromAutoLotto)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> raffleLottoNumbers(){
        return LottoNumber::
    }

}
