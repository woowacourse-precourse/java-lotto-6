package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetryTest {

    @Test
    void 예외가_발생하지_않을때_까지_반복돤다(){
        //given
        Supplier<String> operation = () -> {
            if (Randoms.pickNumberInRange(0, 10) < 5) {
                throw new IllegalArgumentException("5보다 큰 숫자여야 합니다.");
            }
            return "success";
        };
        // when
        String result = Retry.retryOnException(operation);
        // then
        assertEquals("success", result);
    }
}
