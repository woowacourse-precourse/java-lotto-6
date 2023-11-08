package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 당첨 번호 & 보너스 번호 테스트")
class LottoWinningTest {
    static Stream<Arguments> generateCorrectData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 6)
        );
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