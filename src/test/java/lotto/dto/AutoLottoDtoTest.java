package lotto.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.AutoLottos;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

class AutoLottoDtoTest {

    @Test
    void fromEntity는_로또를_정렬해_리스트로반환한다() {
        // given
        AutoLottos autoLottos = new AutoLottos();
        autoLottos.createAutoLottos(3, new LottoGenerator());
        // when
        AutoLottoDto dto = AutoLottoDto.fromEnity(autoLottos);
        // then
        for (int i = 0; i < autoLottos.getLottos().size(); i++) {
            List<Integer> lotto = dto.getAutoLottoDto().get(i);
            assertThat(lotto).isNotEqualTo(autoLottos.getLottos().get(i));
            assertThat(lotto).isEqualTo(autoLottos.getLottos().get(i).getLotto().stream().sorted().toList());
        }
    }
}