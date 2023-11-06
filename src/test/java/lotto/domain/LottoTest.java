package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_생성_테스트() {
        Lotto lotto = Lotto.generateLottery();
        Assertions.assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    void getNumbers() {
        Lotto lotto = Lotto.generateLottery();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertTrue(numbers instanceof List);
    }
}