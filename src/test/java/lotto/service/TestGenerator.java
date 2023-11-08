package lotto.service;

import java.util.List;

public class TestGenerator implements Generator {
    private List<Integer> testNumbers;

    public TestGenerator(List<Integer> testNumbers) {
        this.testNumbers = testNumbers;
    }

    @Override
    public List<Integer> generate() {
        return testNumbers;
    }
}
