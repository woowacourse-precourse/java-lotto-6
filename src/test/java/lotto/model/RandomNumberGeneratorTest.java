package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    void 랜덤값_범위_확인() {
        RandomNumberGenerator lottoNumberGenerater = new RandomNumberGenerator();
        List<Integer> numberList = lottoNumberGenerater.createNumber();

        for(int i = 0; i < 6; i++){
            assertTrue(0 < numberList.get(i) && numberList.get(i) <= 45);
        }
    }
}
