package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.IssuedLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssuedLottoTest {

    @DisplayName("로또번호를 무작위로 6개를 뽑는다.")
    @Test
    void createAutoLottoNumbers() {
        assertThatCode(() -> new IssuedLotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }
    @DisplayName("예상한 로또 번호가 맞는지 확인한다.")
    @Test
    void findAllLottoNumbers(){
        List<Integer> expectedLottoNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        IssuedLotto lottoGeneration = new IssuedLotto(List.of(1,2,3,4,5,6));
        List<Integer> lottoNumbers = lottoGeneration.findAll();
        assertThat(lottoNumbers).isEqualTo(expectedLottoNumbers);
    }
}
