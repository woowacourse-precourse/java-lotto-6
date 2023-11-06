package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.dto.LottoResponseDtos.LottoResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    @DisplayName("로또 번호와 당첨 번호, 보너스 번호를 비교하여 등수를 찾는다.")
    public void findRanking() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));
        List<LottoResponseDto> lottoResponseDtos = lottos.toResponseDto().getLottoResponseDtos();

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,45", "6");

        // when
        Result result = new Result(lottoResponseDtos, winningNumber);
        List<Integer> lottoNumbers = lottoResponseDtos.get(0).getLottoNumbers();
        Ranking ranking = result.findRanking(lottoNumbers, winningNumber);

        // then
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
}