package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoListTest {
    @DisplayName("생성된 로또 번호를 삽입")
    @Test
    void insertLottoInList() {
        LottoList lottoList = new LottoList();
        lottoList.insertLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThat(lottoList.getSize()).isEqualTo(1);
    }

    @DisplayName("모든 로또를 반환")
    @Test
    void returnAllLotto() {
        LottoList lottoList = new LottoList();
        lottoList.insertLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.insertLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.insertLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> allLotto = lottoList.getAllLotto();
        Assertions.assertThat(allLotto.size()).isEqualTo(3);
    }
}
