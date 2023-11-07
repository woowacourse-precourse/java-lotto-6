package lotto.util;


import lotto.util.NumberGenerator.INumberGenerator;

import java.util.List;

public class FakeNumberGenerator implements INumberGenerator {

    private final List<Integer> list;

    public FakeNumberGenerator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> generateNumbers() {
        return list;
    }

}