package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 객체 생성시 로또 번호 오름차순 정렬")
    @Test
    void success_SortAscending() {
        // give
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        // when
        List<Integer> lottoNumber = lotto.getNumbers();
        // then
        for (int i = 0; i < lottoNumber.size(); i++) {
            assertThat(lottoNumber.get(i)).isEqualTo(i + 1);
        }
    }
}