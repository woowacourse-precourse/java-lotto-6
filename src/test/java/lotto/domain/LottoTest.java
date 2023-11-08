package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final String IS_NOT_SIX_LENGTH_ERROR_MESSAGE = "[ERROR] 당첨 숫자는 6자리여야 합니다.";
    private static final String IS_NOT_OVERLAP_SIX_VALIDATOR_ERROR_MESSAGE = "[ERROR] 6개의 숫자에 중복된 로또 번호가 존재합니다.";
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_NOT_SIX_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IS_NOT_OVERLAP_SIX_VALIDATOR_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또_객체_내_번호_반환_테스트")
    void getNumbers() {
        // given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> getNumbers;
        Lotto lotto = new Lotto(numbers);
        // when
        getNumbers = lotto.getNumbers();
        // then
        assertThat(getNumbers).isEqualTo(numbers);
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("해당_객체와_다른_로또_객체_일치_번호_개수_세기_테스트")
    void countMatchedOtherLotto(List<Integer> target, Integer answerCount) {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto compTarget = new Lotto(target);
        // when
        Integer countMatched = lotto.countMatchedOtherLotto(compTarget);
        // then
        assertThat(countMatched).isEqualTo(answerCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {7,8,9})
    @DisplayName("해당_객체_번호와_보너스_번호_일치_테스트")
    void valid_isContainBonus(Integer bonusNumber) {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Bonus bonus = new Bonus(winningLotto.getNumbers(), bonusNumber);
        Lotto playerLotto = new Lotto(Arrays.asList(7,8,9,10,11,12));

        // when
        Boolean isMatchBonus = playerLotto.isContainBonus(bonus);
        // then
        assertThat(isMatchBonus).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {33,27,44})
    @DisplayName("해당_객체_번호와_보너스_번호_불일치_테스트")
    void invalid_isContainBonus(Integer bonusNumber) {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Bonus bonus = new Bonus(winningLotto.getNumbers(), bonusNumber);
        Lotto playerLotto = new Lotto(Arrays.asList(7,8,9,10,11,12));

        // when
        Boolean isMatchBonus = playerLotto.isContainBonus(bonus);
        // then
        assertThat(isMatchBonus).isEqualTo(false);
    }

    private static Stream<Arguments> provideLottoNumbers(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 6),
                Arguments.of(Arrays.asList(5,15,17,23,24,44),1),
                Arguments.of(Arrays.asList(1,3,4,33,35,45),3)
        );
    }
}