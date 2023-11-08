package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoUtilsTest {

    @DisplayName("랜덤으로 로또 번호를 뽑아주는 기능")
    @Test
    public void 랜덤으로_로또_번호를_뽑고_로또객체를_생성하면_예외가_발생하지_않는다() {
        // given
        List<Integer> integers = LottoUtils.generateRandomLottoNumbers();

        // when

        // then
        assertDoesNotThrow(() -> new Lotto(integers));
    }

    @DisplayName("오름차순으로 정렬해주는 기능")
    @Test
    public void 오름차순으로_정렬해준다() {
        // given
        List<Integer> notSortedList = new ArrayList<>(List.of(6, 5, 2, 1, 4, 3));
        List<Integer> sortedList = new ArrayList<>(List.of(1,2,3,4,5,6));

        // when
        List<Integer> afterSort = LottoUtils.sortAsc(notSortedList);

        // then
        assertThat(afterSort).isEqualTo(sortedList);
    }

    @DisplayName("문자열을 Integer 배열로 바꿔주는 기능")
    @Test
    public void 문자열을_콤마_기준으로_나누고_정수_배열로_만들어준다() {
        // given
        String numbers = "1,2,3,4,5,6";
        List<Integer> matchNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> stringToIntegerList = LottoUtils.stringToList(numbers);

        // then
        assertThat(stringToIntegerList).isEqualTo(matchNumbers);
    }

    @DisplayName("금액에 따른 로또개수를 출력해주는 기능")
    @ParameterizedTest
    @CsvSource(value = {"3000:3", "7000:7", "10_000_000:10_000"}, delimiter = ':')
    public void 금액에_맞게_로또_개수를_반환해준다(long prise, int cnt) {
        long lottoAmount = LottoUtils.getLottoAmount(prise);
        assertThat(lottoAmount).isEqualTo(cnt);
    }

    @DisplayName("당첨 번호의 개수를 출력해주는 기능(보너스 번호 제외)")
    @Test
    public void 당첨_번호의_개수를_반환해준다() {
        // given
        List<Integer> buyer = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = new ArrayList<>(List.of(11,25,1,3,4,8));
        int matchCount = 3;

        // when
        int count = LottoUtils.matchLotto(buyer, winning);

        // then
        assertThat(count).isEqualTo(matchCount);
    }

    @DisplayName("보너스 번호가 있는지 확인하는 기능")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void 보너스_번호가_있는지_확인하는_기능(int bonus) {
        // given
        Lotto buyer = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int matchCount = 5;

        // when
        boolean isContain = LottoUtils.matchBonus(matchCount, buyer, bonus);

        // then
        assertThat(isContain).isTrue();
    }
}