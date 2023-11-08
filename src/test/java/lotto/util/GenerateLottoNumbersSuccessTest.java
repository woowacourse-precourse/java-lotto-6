package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GenerateLottoNumbersSuccessTest implements RandomUtils {

    @Override
    public List<Integer> generateRandomNumbers() {
        return List.of(1,2,3,4,5,6);
    }
}