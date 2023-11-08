package lotto.input.provider.impl;

import java.io.IOException;
import java.util.List;
import lotto.input.provider.NumberProvider;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProvider implements NumberProvider {


    @Override
    public Integer getSingle() throws IllegalArgumentException, IOException {
        return Randoms.pickNumberInRange(1, 46);
    }

    @Override
    public List<Integer> getMultiple(int number) throws IllegalArgumentException, IOException {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
