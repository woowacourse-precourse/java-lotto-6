package lotto.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.List;




class RandomNumberGeneratorTest {

    @Test
    @RepeatedTest(100)
    void create_생성된_수가_범위내에_있다() {
        int count = 6;
        int start = 1;
        int end = 45;
        List<Integer> actual = RandomNumberGenerator.create(count,start, end);

        for(int num: actual){
            assertTrue(num >= start);
            assertTrue(num <= end);
        }
    }

    @Test
    @RepeatedTest(100)
    void create_중복되지_않는다(){
        int count = 6;
        int start = 1;
        int end = 45;
        List<Integer> actual = RandomNumberGenerator.create(count,start, end);

        // 테스트 조건: 생성된 리스트는 중복된 요소를 포함하지 않아야 함
        for (int i = 0; i < actual.size(); i++) {
            for (int j = i + 1; j < actual.size(); j++) {
                assertNotEquals(actual.get(i), actual.get(j));
            }
        }
    }
}