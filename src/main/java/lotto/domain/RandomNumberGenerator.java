package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * @author 민경수
 * @description random number generator
 * @since 2023.11.04
 **********************************************************************************************************************/
public class RandomNumberGenerator {

    private final LottoProperty lottoProperty;

    public RandomNumberGenerator(LottoProperty lottoProperty) {
        this.lottoProperty = lottoProperty;
    }

    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                lottoProperty.lottoMinimumRangeFrom(),
                lottoProperty.lottoMaximumRangeTo(),
                lottoProperty.lottoSize()
        );
    }

}