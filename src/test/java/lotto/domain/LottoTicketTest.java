package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    private static final String REGEX = ",";
    private static final int FIRST_INDEX = 0;

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = "5,3,14,45,25,1:1", delimiterString = ":")
    public void 로또_생성_시_오름차순으로_정렬된다(String input, int expected) {
        // given
        List<Integer> numbers = Arrays.stream(input.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // when
        LottoTicket lotto = new LottoTicket(numbers);
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        LottoNumber lottoNumber = lottoNumbers.get(FIRST_INDEX);

        // then
        Assertions.assertThat(lottoNumber.getNumber()).isEqualTo(expected);
    }

}