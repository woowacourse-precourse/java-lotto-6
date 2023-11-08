package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.controller.exception.DuplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("개수가 6개가 맞느지 확인")
    @Test
    public void 로또생성() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isNotNull();

        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidLottoNumbers));
    }

    @DisplayName("중복된 숫자가 있는지 검사")
    @Test
    public void 중복검사() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 2, 4, 5, 6);
        assertThrows(DuplicationException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("포함되어 있는 숫자를 검색")
    @Test
    public void 포함된숫자() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.numberContain(3)).isTrue();
        assertThat(lotto.numberContain(7)).isFalse();
    }

    @DisplayName("객체가 정상적으로 제대로 만들어졌는지 확인")
    @Test
    public void 로또데이터조회() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> checkNumbers = lotto.getNumbers();
        assertThat(checkNumbers).isNotNull();
        assertThat(checkNumbers).isEqualTo(lottoNumbers);
    }
}