package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("입력한 로또 번호와 다른 양식의 문자열이 나올 시 예외 발생")
    void getLottoString() {
        Lotto lotto = new Lotto(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6}));
        Assertions.assertEquals(lotto.getLottoString(), "[1, 2, 3, 4, 5, 6]");
    }
}