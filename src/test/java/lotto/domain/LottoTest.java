package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    private final List<Integer> numbers = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6});
    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(numbers);
    }

    @Test
    @DisplayName("입력한 로또 번호와 다른 양식의 문자열 반환 시 실패")
    void getLottoString() {
        Assertions.assertEquals(lotto.getLottoString(), "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("입력한 로또 번호와 다른 리스트 반환 시 실패")
    void getNumbers() {
        Assertions.assertEquals(lotto.getNumbers(), numbers);
    }
}