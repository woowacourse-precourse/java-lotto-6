package lotto.domain;

import lotto.domain.number.NumberUtil;

import java.util.List;

public class FakeNumberGenerator implements NumberUtil {
    @Override
    public List<Integer> generateNumbers() {
        return List.of(1,2,3,4,5,6);
    }
}
