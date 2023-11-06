package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GeneratorTest {
    @Test
    void generator로_생성된_수가_1에서_45사이인지_확인(){
        Generator generator = new Generator();
        int generatedNum = generator.generateRandomNumber();
        boolean output = (generatedNum >= 0 && generatedNum <= 45);
        assertEquals(true, output);
    }
}
