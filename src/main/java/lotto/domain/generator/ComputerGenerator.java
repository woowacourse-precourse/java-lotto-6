package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.constant.RangeConstant.*;

public class ComputerGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange
                (START_NUM.getNumber(), END_NUM.getNumber(), SIZE_NUM.getNumber());
    }
}
