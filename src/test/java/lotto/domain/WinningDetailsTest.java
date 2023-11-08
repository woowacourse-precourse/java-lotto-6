package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.WinningGrade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("우승 정보 일급 컬렉션에")
class WinningDetailsTest {

    @DisplayName("요소의 개수를 요청하면 개수를 반환한다.")
    @Test
    void numOfValues() {
        // given
        final List<WinningDetail> values = List.of(new WinningDetail(WinningGrade.SECOND_GRADE, 3));
        final WinningDetails winningDetails = new WinningDetails(values);

        // when
        final int result = winningDetails.numOfValues();

        // then
        assertThat(result).isEqualTo(values.size());
    }

    @DisplayName("인덱스의 값을 요청하면 해당하는 값을 반환한다.")
    @Test
    void getByIndex() {
        // given
        final List<WinningDetail> values = List.of(new WinningDetail(WinningGrade.SECOND_GRADE, 3));
        final WinningDetails winningDetails = new WinningDetails(values);

        // when
        final int index = 0;
        final WinningDetail winningDetail = winningDetails.getByIndex(index);

        // then
        assertThat(winningDetail).isEqualTo(values.get(index));
    }

    @DisplayName("우승 결과를 요청시 우승 결과를 만들어 반환한다.")
    @Test
    void toWinningResult() {
        // given
        final WinningGrade secondGrade = WinningGrade.SECOND_GRADE;
        final List<WinningDetail> values = List.of(new WinningDetail(secondGrade, 9));
        final WinningDetails winningDetails = new WinningDetails(values);

        // when
        final WinningResult winningResult = winningDetails.toWinningResult();

        // then
        assertThat(winningResult.numOfWinningGrade(secondGrade)).isEqualTo(values.size());
    }
}
