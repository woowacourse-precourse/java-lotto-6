package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
class LottoUtilsTest {
    @Test
    @DisplayName("입력받은 숫자 문자열을 로또 번호 리스트로 변환한다")
    void convertStringToLottoNumberList() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = LottoUtils.convertStringToLottoNumberList(input);
        assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("올바르지 않은 형식의 문자열 변환 시 예외 발생")
    public void invalidStringConversion() {
        String input = "8, two, 19, 34, forty-one, 13";
        assertThrows(NumberFormatException.class, () -> {
            LottoUtils.convertStringToLottoNumberList(input);
        });
    }

    @Test
    @DisplayName("정해진 수의 로또를 생성")
    public void generateLottoPaper() {
        int howManyLotto = 5;
        List<Lotto> lottoPapers = LottoUtils.generateLottoPaper(howManyLotto);
        assertThat(lottoPapers).hasSize(howManyLotto);
        for (Lotto lotto : lottoPapers) {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        }
    }
}
