package lotto.config;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;

public class IntegrationTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
