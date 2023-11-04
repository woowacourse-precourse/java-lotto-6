package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class LottoNumberGeneratorTest {

    private final LottoNumberGenerator lottoNumberGenerator= new LottoNumberGenerator();

    @DisplayName("중복되지 않는 6개의 숫자가 생성되는지 확인")
    @Test
    void checkThereIsNoDuplicateNumber() {
        List<Integer> numbers = lottoNumberGenerator.createLottoNumber();
        List<Integer> distinctNumber = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        Assertions.assertEquals(numbers.size(),distinctNumber.size());
    }
}