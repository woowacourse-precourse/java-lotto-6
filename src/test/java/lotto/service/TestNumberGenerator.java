package lotto.service;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {
    private List<Integer> testNumbers;

    public TestNumberGenerator(List<Integer> testNumbers) {
        this.testNumbers = testNumbers;
    }

    @Override
    public List<Integer> generateLotto() {
        return testNumbers;
    }
}
