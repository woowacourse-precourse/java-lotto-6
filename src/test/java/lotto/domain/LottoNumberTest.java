package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    private static List<Integer> lottoNumberList;

    @DisplayName("로또 숫자 생성")
    @Test
    void lottoNumberGenerate() {
        LottoNumber lottoNumbers = new LottoNumber();
        lottoNumberList = lottoNumbers.setLottoNumber();

        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}