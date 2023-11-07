package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.enums.LottoStatus;
import lotto.service.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    @DisplayName("Lotto리스트를 LottoDto리스트로 잘 반환하는지 확인한다")
    void convertToDto() {
        Lottos lottos = new Lottos();
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLotto(Arrays.asList(4, 7, 13, 28, 35, 40));
        List<LottoDto> lottoDtos = lottos.toDto();

        assertThat(lottoDtos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("lottos리스트에 Lotto가 잘 추가되는지 확인한다")
    void addLotto() {
        List<Integer> lottoNumbers = Arrays.asList(3, 8, 12, 21, 37, 45);
        Lottos lottos = new Lottos();
        lottos.addLotto(lottoNumbers);

        assertThat(lottos.toDto().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("lottos의 로또들과 당첨 번호를 비교했을 때 순위가 잘 저장되는지 확인한다")
    void compareLotto() {
        List<Integer> winningLottoNumbers = Arrays.asList(3, 8, 15, 21, 31, 42);
        Lotto winningLotto = new Lotto(winningLottoNumbers);

        Lottos lottos = new Lottos();
        lottos.addLotto(Arrays.asList(3, 8, 12, 21, 37, 45));
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLotto(Arrays.asList(3, 8, 15, 21, 31, 42));

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, 7);

        List<LottoStatus> lottoStatuses = lottos.compareLotto(winningNumbers);

        assertThat(lottoStatuses.get(0)).isEqualTo(LottoStatus.FIFTH);
        assertThat(lottoStatuses.get(1)).isEqualTo(LottoStatus.SIXTH);
        assertThat(lottoStatuses.get(2)).isEqualTo(LottoStatus.FIRST);
    }

}
