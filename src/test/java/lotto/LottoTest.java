package lotto;

import static lotto.domain.ticket.LottoErrorMessage.DUPLICATION_ERROR;
import static lotto.domain.ticket.LottoErrorMessage.INVALID_RANGE_ERROR;
import static lotto.domain.ticket.LottoErrorMessage.SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.domain.dto.LottoResult;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoNumberGenerator;
import lotto.domain.winningnumbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

class LottoTest {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATION_ERROR.getMessage());
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호는 1에서 45사이의 값이어야 한다.")
    @ParameterizedTest
    @MethodSource("provideInvalidRangeNumbers")
    void createInvalidRange(List<Integer> numbers) {

        //when, then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR.getMessage());
    }

    @Test
    void 유효_로또_번호_생성() {
        //given
        List<Integer> lottoNumber = lottoNumberGenerator.generate();

        //when,then
        assertThatCode(() -> new Lotto(lottoNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호는_오름차순() {
        //given
        List<Integer> lottoNumber = lottoNumberGenerator.generate();

        //when
        List<Integer> clone = lottoNumber.stream()
                .sorted()
                .toList();

        //then
        assertThat(lottoNumber).isEqualTo(clone);
    }

    @ParameterizedTest
    @MethodSource("provideLottoAndWinningNumbersWithResult")
    void 로또_번호중_동일한_숫자의_개수와_보너스_번호_매치_여부를_반환한다(List<Integer> numbers, List<Integer> winningNumbers,
                                  int bonusNumber,int count, boolean match) {
        //given
        Lotto lotto = new Lotto(numbers);
        WinningNumbers winningNum =new WinningNumbers(winningNumbers, bonusNumber);

        //when
        LottoResult result = lotto.getResult(winningNum);

        //then
        assertThat(result.getCountOfSameNumber()).isEqualTo(count);
        assertThat(result.getMatchBonusNumber()).isEqualTo(match);
    }

    private static Stream<Arguments> provideInvalidRangeNumbers() {
        return Stream.of(
                Arguments.of(List.of(0,1,2,3,4,5)),
                Arguments.of(List.of(41,42,43,44,45,46)),
                Arguments.of(List.of(0,10,20,30,40,50))
        );
    }

    private static Stream<Arguments> provideLottoAndWinningNumbersWithResult() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6),List.of(1,2,3,4,5,6),10,6,false),
                Arguments.of(List.of(1,2,3,4,5,10),List.of(1,2,3,4,5,45),10,5,true),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(1,2,3,4,44,45),10,4,false),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(1,2,3,43,44,45),10,3,false),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(1,2,42,43,44,45),10,2,false),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(1,41,42,43,44,45),10,1,false),
                Arguments.of(List.of(1,2,3,4,5,6),List.of(40,41,42,43,44,45),10,0,false)
        );
    }
}