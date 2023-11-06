package lotto.unit.generate;

import lotto.dto.generate.GetGeneratedLottosDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.service.generate.Generator;
import lotto.service.generate.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorUnitTest {
    private Generator generator;
    @BeforeEach
    void init(){
        generator = new LottoGenerator();
    }

    @DisplayName("로또 생성 정상 실행")
    @Test
    void hi(){
        //given
        GetLottoCountDto getLottoCountDto = new GetLottoCountDto(10);
        //when
        GetGeneratedLottosDto getGeneratedLottosDto = generator.generateLottos(getLottoCountDto);
        //then
        Assertions.assertThat(getGeneratedLottosDto.getLottos().lottos().size()).isEqualTo(10);
    }

}
