package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DrawTest {
    Draw draw;
    String input;

    @BeforeEach
    void setUp() {
        draw = new Draw();
    }

    @DisplayName("6자리 초과 당첨 번호 입력시 IllegalArgumentException과 에러 메시지를 출력한다.")
    @Test
    void 당첨_번호_6자리_초과() {
        input = "1,2,3,4,5,6,7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> draw.winningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6자리 중복 당첨 번호 입력시 IllegalArgumentException과 에러 메시지를 출력한다.")
    @Test
    void 당첨_번호_6자리_중복() {
        input = "1,2,3,3,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> draw.winningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }
}