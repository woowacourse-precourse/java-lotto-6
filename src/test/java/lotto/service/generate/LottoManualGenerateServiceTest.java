package lotto.service.generate;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoManualGenerateServiceTest {

    @Test
    @DisplayName("로또 1개를 수동으로 생성하는 테스트")
    void generateLottoManually() throws LottoException {
        LottoManualGenerateService manualGenerateService = LottoManualGenerateService.getInstance();
        List<String> inputNumbers = List.of("1", "2", "3", "4", "5", "6");

        Lotto lotto = manualGenerateService.generate(inputNumbers);

        List<Integer> lottoNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::value)
                .toList();

        assertEquals(inputNumbers.size(), lottoNumbers.size());
        for (String inputNumber : inputNumbers) {
            assertTrue(lottoNumbers.contains(Integer.parseInt(inputNumber)));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "A,2,3,4,5,A",
            "1,2,3,4,5,6,7",
            "1,2,3,4"
    })
    @DisplayName("잘못된 입력값으로 로또 생성 시 예외가 발생하는 테스트")
    void generateLottoWithInvalidInput(String inputNumbers) {
        LottoManualGenerateService manualGenerateService = LottoManualGenerateService.getInstance();
        assertThrows(LottoException.class, () -> manualGenerateService.generate(List.of(inputNumbers.split(","))));
    }
}
