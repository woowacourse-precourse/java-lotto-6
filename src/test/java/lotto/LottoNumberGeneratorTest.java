package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest extends NsTest {
    private static final int START = 1;
    private static final int END = 45;
    private static final int SIZE = 6;

    @DisplayName("숫자 생성기가 1~45 사이 정수 6개를 생성하는지 확인한다.")
    @Test
    public void createNumbers_test() {
        assertThat(LottoNumberGenerator.createNumbers()).hasSize(SIZE)
                .allMatch(number -> number >= START && number <= END);
    }

    @Override
    protected void runMain() {Application.main(new String[]{});}
}
