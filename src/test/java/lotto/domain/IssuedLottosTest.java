package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IssuedLottosTest {

    @DisplayName("로또 번호 생성 - 유니크한 로또 생성")
    @Test
    void createDifferentIssuedLottos() {
        int quantity = 10;
        IssuedLottos issuedLottos = new IssuedLottos(quantity);

        long distinctCount = issuedLottos.getIssuedLottos().stream().distinct().count();
        assertThat(distinctCount == issuedLottos.getIssuedLottos().size()).isTrue();
    }

    @DisplayName("로또 번호 생성 - 유효성 검사 성공")
    @Test
    void createRandomLottoNumbers() {
        int quantity = 10;
        IssuedLottos issuedLottos = new IssuedLottos(quantity);
        List<Lotto> lottos = issuedLottos.getIssuedLottos();

        int size = lottos.size();
        for (int index = 0; index < size; index++) {
            List<Integer> lotto = lottos.get(index).getNumbers();

            assertEquals(quantity, lottos.size());
            assertThat(lotto.stream().distinct().count() == lotto.size()).isTrue();
            assertThat(lotto.stream().allMatch(number -> number >= LottoPolicy.LOTTO_START_NUMBER
                    && number <= LottoPolicy.LOTTO_END_NUMBER)).isTrue();
        }
    }

}