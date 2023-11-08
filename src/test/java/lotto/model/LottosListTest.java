package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosListTest {

    private LottosList lottosList;

    @BeforeEach
    public void setUp() {
        lottosList = new LottosList();

    }

    @DisplayName("로또 번호 중복되지 않는 6개 번호 만들기")
    @Test
    void generateUniqueNumbers() {
        LottosList lottosList = new LottosList();
        List<Integer> list = lottosList.generateUniqueNumbers();
        HashSet<Integer> set = new HashSet<>(list);
        assertThat(list.size()).isEqualTo(set.size());
    }

    @DisplayName("입력 받은 구입 금액에 해당하는 로또 개수 생성")
    @Test
    public void createLottos() {
        lottosList.createLottos(5);
        assertThat(lottosList.getLottosList().size()).isEqualTo(5);

    }
}