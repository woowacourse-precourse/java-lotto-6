package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    @Test
    void 로또_번호가_정상적으로_생성되는가() {
        assertThat(new LottoNumberGenerator().generateLottoNumbers())
                .doesNotHaveDuplicates()
                .hasSize(6);
    }

    @Test
    void 로또_번호가_정렬되어_생성되는가() {
        assertThat(new LottoNumberGenerator().generateLottoNumbers())
                .isSorted();
    }
}
