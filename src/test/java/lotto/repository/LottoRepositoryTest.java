package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.util.generator.LottoGenerator;
import org.junit.jupiter.api.Test;

public class LottoRepositoryTest {
    private LottoRepository lottoRepository = new LottoRepository();

    @Test
    void 로도_생성_이후_저장하기() {
        Lotto lotto = LottoGenerator.generateLotto(
                () -> Arrays.asList(1, 2, 3, 4, 5, 6)
        );

        lottoRepository.saveLotto(lotto);

        assertThat(lottoRepository.checkRepositorySize()).isEqualTo(1);
    }


    @Test
    void 로또_전체_조회() {
        Lotto firstLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = Lotto.from(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto thirdLotto = Lotto.from(Arrays.asList(13, 14, 15, 16, 17, 18));

        lottoRepository.saveLotto(firstLotto);
        lottoRepository.saveLotto(secondLotto);
        lottoRepository.saveLotto(thirdLotto);

        assertThat(lottoRepository.checkRepositorySize()).isEqualTo(3);

        assertThat(lottoRepository.getAllLottos()).containsExactly(
                firstLotto, secondLotto, thirdLotto
        );
    }

}
