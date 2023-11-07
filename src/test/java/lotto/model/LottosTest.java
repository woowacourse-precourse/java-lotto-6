package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.service.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    @DisplayName("Lotto리스트를 LottoDto리스트로 잘 반환하는지 확인")
    void convertToDto() {
        Lottos lottos = new Lottos();
        lottos.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLotto(Arrays.asList(4, 7, 13, 28, 35, 40));
        List<LottoDto> lottoDtos = lottos.toDto();

        assertThat(lottoDtos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("lottos리스트에 Lotto가 잘 추가되는지 확인")
    void addLotto() {
        List<Integer> lottoNumbers = Arrays.asList(3, 8, 12, 21, 37, 45);
        Lottos lottos = new Lottos();
        lottos.addLotto(lottoNumbers);

        assertThat(lottos.toDto().size()).isEqualTo(1);
    }

}
