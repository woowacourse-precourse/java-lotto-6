package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 toString 값 확인")
    @Test
    public void lotto_toString() throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 7]");
    }

    // todo : toString에 의존하는 테스트. getter를 굳이 만들어야 하는지에 대해 고민하고 수정하기
    @DisplayName("로또 넘버 생성 확인")
    @Test
    public void createLotto_from_lottoNumbers() throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 7]");
    }


    public static Stream<Arguments> lottoNumbers_bonusNumber_Counts() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 7, 6),  //1
                Arguments.arguments(List.of(2, 3, 4, 5, 6, 7), 7, 5),  //2
                Arguments.arguments(List.of(2, 3, 4, 5, 6, 8), 7, 5), // 3
                Arguments.arguments(List.of(4, 5, 6, 7, 8, 9), 7, 3),
                Arguments.arguments(List.of(5, 6, 7, 8, 9, 10), 7, 2),
                Arguments.arguments(List.of(6, 7, 8, 9, 10, 11), 7, 1),
                Arguments.arguments(List.of(7, 8, 9, 10, 11, 12), 7, 0)
        );
    }

    @DisplayName("로또 번호끼리 비교해서 개수 반환 : 5개 일치")
    @ParameterizedTest
    @MethodSource("lottoNumbers_bonusNumber_Counts")
    public void createLotto_matchAndCount(List<Integer> winningNumbers, int bonusNumber, int count) throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto winningLotto = new Lotto(winningNumbers);
        Lotto lotto = new Lotto(numbers);

        //when
        int matchResult = lotto.match(winningLotto);

        //then
        assertThat(matchResult).isEqualTo(count);
    }

    @DisplayName("로또 번호를 (로또 번호 + 보너스 번호)와 비교해서 결과 반환")
    @ParameterizedTest
    @MethodSource("lottoNumbers_bonusNumber_Counts")
    public void createLotto_matchAndRank(List<Integer> winningNumbers, int bonusNumber, int count) throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        //when
        MatchingResult result = lotto.match(winningLotto, bonusLottoNumber);

        //then
        assertThat(result.getCorrectCount()).isEqualTo(count);
        assertThat(result.isBonusCorrect()).isFalse();
    }
}