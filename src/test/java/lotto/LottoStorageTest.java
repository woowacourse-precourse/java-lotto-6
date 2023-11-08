package lotto;

import lotto.model.Lotto;
import lotto.model.LottoStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStorageTest {
    @DisplayName("로또 저장소에 저장한 로또는 변형없이 그대로 보관된다.")
    @Test
    void keepLottoInStorage() {

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoStorage.addLotto(lotto1);
        LottoStorage.addLotto(lotto2);

        List<Lotto> lottoStorage = LottoStorage.getLotto();

        assertThat(lottoStorage).isEqualTo(List.of(lotto1, lotto2));
    }
}
