package util;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


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
}