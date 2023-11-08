package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    RandomNumberGenerator randomNumber = new RandomNumberGenerator();

    @DisplayName("6개의 숫자가 생성되는가")
    @Test
    void 숫자_길이_6() {
        assertThat(randomNumber.createSortedLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("리스트가 오름차순인가")
    @Test
    void 리스트_오름차순() {
        List<Integer> testNumbers = randomNumber.createSortedLottoNumbers();
        for (int i = 0; i < testNumbers.size() - 1; i++) {
            if (testNumbers.get(i) > testNumbers.get(i + 1)) {
                assertThat(testNumbers.get(i)).isLessThanOrEqualTo(testNumbers.get(i + 1));
            }
        }
    }

    @DisplayName("1~45 안에서 생성되고, 중복되지 않는가")
    @Test
    void 숫자_생성범위() {
        List<Integer> testNumbers = randomNumber.createSortedLottoNumbers();

        assertThat(testNumbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("중복되지 않는가")
    @Test
    void 중복_검증() {
        List<Integer> testNumbers = randomNumber.createSortedLottoNumbers();
        assertThat(testNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("티켓 수 만큼 랜덤번호를 생성하고 모으기")
    @Test
    void 랜덤번호_리스트_모으기() {
        List<List<Integer>> testAllRandomNumbers = randomNumber.generateMultipleLottoSets(8);
        assertThat(testAllRandomNumbers.size()).isEqualTo(8);
    }
}



