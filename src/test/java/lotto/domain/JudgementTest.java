package lotto.domain;

import lotto.exception.Exception;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {
    private Exception exception;
    private Buy buy;
    private Draw draw;

    @BeforeEach
    void setUp() {
        exception = new Exception();
        buy = new Buy();
        draw = new Draw();
    }


}