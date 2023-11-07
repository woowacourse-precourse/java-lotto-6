package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @DisplayName("로또 번호가 1-45 사이의 숫자 이고 6자리인 로또 생성 검증하기")
    @Test
    public void testGenerateLotto() {
        Lotto lotto = LottoFactory.generateLotto();
        List<Integer> numbers = lotto.getNumbers();
        assertEquals(6, numbers.size());
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @DisplayName("로또가 요청한 갯수 만큼 생성되는지 검증하기")
    @Test
    public void testGenerateLottoList() {
        int count = 5;
        List<Lotto> lottos = LottoFactory.generateLotto(count);
        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("로또 리스트 가 요청한 개수 만큼 생성 되는지 검증 하기")
    @Test
    public void testGenerateLotties() {
        int count = 3;
        Lotties lotties = LottoFactory.generateLotties(count);
        assertThat(lotties.size()).isEqualTo(count);
    }

}