package lotto.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoRepositoryTest {
    private Lotto lotto;
    private List<UserLotto> userLottos;
    private Lotto userLotto;
    private int bonusNumber;
    private LottoRepository lottoRepository;

    @BeforeEach
    void init() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        userLottos = new ArrayList<>(List.of(new UserLotto(userLotto)));
        lottoRepository = new LottoRepository(lotto, bonusNumber, userLottos);
    }

    @Test
    void 로또_번호_비교() {
        lottoRepository.compareNumbers();

        assertThat(userLottos.get(0).getCorrectCnt()).isEqualTo(5);
        assertThat(userLottos.get(0).getBonusCnt()).isEqualTo(1);
    }
}
