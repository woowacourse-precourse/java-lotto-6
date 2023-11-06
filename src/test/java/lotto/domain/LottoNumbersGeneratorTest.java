package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("발급된 로또 번호 오름차순 정렬 기능 테스트")
    void 발급된_로또_번호_오름차순_정렬_확인() {
        List<Integer> generateLottoNumbers = LottoNumbersGenerator.ascendingGenerate();
        List<Integer> copyLottoNumbers = new ArrayList<>();
        for (Integer lottoNumber : generateLottoNumbers) {
            copyLottoNumbers.add(lottoNumber);
        }
        Collections.sort(generateLottoNumbers);

        assertThat(generateLottoNumbers.equals(copyLottoNumbers)).isTrue();
    }

    @Test
    @DisplayName("발급된 로또 번호 쉼표와 공백으로 구분 테스트")
    void 발급된_로또_번호_쉼표_공백_구분_확인() {
        List<Integer> generateLottoNumbers = LottoNumbersGenerator.ascendingGenerate();
        String regex = "\\[\\d+(, \\d+)*\\]";

        assertThat(generateLottoNumbers.toString().matches(regex)).isTrue();
    }
}
