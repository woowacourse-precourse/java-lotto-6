package lotto.unit.calculate;

import static org.assertj.core.api.Assertions.*;

import lotto.dto.calculate.GetReturnRateDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.result.GetLottoResultDto;
import lotto.service.calculate.Calculator;
import lotto.service.calculate.LottoReturnRateCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoReturnRateCalculatorUnitTest {
    private Calculator calculator;

    @BeforeEach
    void init(){
        calculator = new LottoReturnRateCalculator();
    }

    @DisplayName("수익률 계산 정상 실행")
    @Test
    void lottoReturnRateCalculatorNormalCase(){
        //given
        GetLottoResultDto getLottoResultDto = new GetLottoResultDto(0, 0, 1, 0, 0);

        GetLottoCountDto getLottoCountDto = new GetLottoCountDto(10);

        //when
        GetReturnRateDto getReturnRateDto = calculator.calculateLottoReturnRate(getLottoResultDto, getLottoCountDto);

        //then
        assertThat(getReturnRateDto.lottoReturnRate()).isEqualTo(15000.0);
    }
}
