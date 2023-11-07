package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserLottoTest {

    OutputStream out = new ByteArrayOutputStream();
    InputStream in = System.in;

    @BeforeEach
    private final void init() {
        System.setOut(new PrintStream(out));
    }

    @DisplayName("size 메서드 테스트")
    @Nested
    class Size {
        @ParameterizedTest(name = "{0}이 입력으로 들어왔을 때")
        @CsvSource(value = {"8000, 8", "1000, 1", "0, 0", "2000, 2"})
        void 로또_개수를_잘_반환하는지_테스트(String target, int expected) {
            ByteArrayInputStream in = new ByteArrayInputStream(target.getBytes());
            System.setIn(in);
            UserLotto userLotto = new UserLotto();

            assertThat(userLotto.size()).isEqualTo(expected);
        }
    }
}