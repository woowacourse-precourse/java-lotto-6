package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    @Test
    @RepeatedTest(100)
    void generator로_생성된_숫자가_6개인지_확인(){
        Generator generator = new Generator();
        assertEquals(6, generator.generate6Nums().size());

        List<Integer> generateNums = generator.generate6Nums();
        System.out.println(generateNums);
        assertEquals(true, (generateNums.size() == new HashSet<>(generateNums).size()));
    }
}
