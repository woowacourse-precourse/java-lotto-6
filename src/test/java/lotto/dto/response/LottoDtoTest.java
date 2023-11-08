package lotto.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import lotto.model.Lotto;

class LottoDtoTest {

    @Test
    void 뷰에_전달할_로또_번호들은_오름차순으로_정렬되어야_한다() {
        Lotto lotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));
        LottoDto lottoDto = LottoDto.from(lotto);

        List<Integer> sortedNumbers = lottoDto.getSortedNumbers();

        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
