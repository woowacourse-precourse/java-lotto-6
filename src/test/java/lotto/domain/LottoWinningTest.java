package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 당첨 번호 & 보너스 번호 테스트")
class LottoWinningTest {
    static Stream<Arguments> generateDuplicateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 7)
        );
    }

    static Stream<Arguments> generateCorrectData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 6)
        );
    }

    @ParameterizedTest(name = "[{index}] 보너스 숫자 중복 예외 발생 : {0}. {1}")
    @MethodSource("generateDuplicateData")
    void 보너스_숫자_중복_예외_발생(List<Integer> list, int num) {
        // given
        Lotto lottoList = new Lotto(list);
        LottoNumber bonusNum = new LottoNumber(num);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new LottoWinning(lottoList, bonusNum));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.DUPLICATE_BONUS_NUM.getMessage());
    }

    @ParameterizedTest(name = "[{index}] 정상 생성 확인")
    @MethodSource("generateCorrectData")
    void 정상_생성_확인(List<Integer> list, int num) {
        // given
        Lotto lottoList = new Lotto(list);
        LottoNumber bonusNum = new LottoNumber(num);

        // when
        LottoWinning lottoWinning = new LottoWinning(lottoList, bonusNum);

        // then
        assertEquals(lottoWinning.getWinningNum().getNumbers(), lottoList.getNumbers());
        assertThat(lottoWinning.getBonusNum().getNumber()).isEqualTo(bonusNum.getNumber());
    }


}