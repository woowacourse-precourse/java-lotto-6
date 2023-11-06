package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    private LottoService service;

    @BeforeEach
    void setUp() {
        service = new LottoService();
    }

//    @Test
//    void 로또_입력값이_숫자가_아니면_예외처리() {
//        String input = "three";
//
//        assertThatThrownBy(() -> service.convertStringToInt(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
//    }
}
