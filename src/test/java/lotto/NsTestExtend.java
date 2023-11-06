package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

public class NsTestExtend extends NsTest {

    private void runTest(String input) {
        super.init();
        super.run(input);
        super.printOutput();
    }

    public void inputTestValue(String input) {
        runTest(input);
    }

    public void inputTestValue(int input) {
        runTest(String.valueOf(input));
    }


    @Override
    protected void runMain() {

    }
}