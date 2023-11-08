package lotto.core.numbergenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomNumberGeneratorTest {

    @Test
    void createRandomUniqueNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> randomUniqueNumber = randomNumberGenerator.createRandomUniqueNumber();
        Assertions.assertThat(randomUniqueNumber.size()).isEqualTo(6);
    }

    @Test
    void name() {
        RandomNumberGenerator mockRandomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
        Mockito.when(mockRandomNumberGenerator.createRandomUniqueNumber()).thenReturn(List.of(1,2,34,5,6));
    }
}