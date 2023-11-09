package lotto.utils.numbergenerators;


import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private List<Integer> testLottoNumber;

    public TestNumberGenerator(List<Integer> testLottoNumber) {
        this.testLottoNumber = testLottoNumber;
    }

    @Override
    public List<Integer> generateNumber() {
        return testLottoNumber;
    }
}
