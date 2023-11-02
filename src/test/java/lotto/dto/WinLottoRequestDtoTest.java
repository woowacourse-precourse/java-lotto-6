package lotto.dto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinLottoRequestDtoTest {

    @ParameterizedTest
    @DisplayName("당첨 로또 번호 입력 전달 DTO 테스트")
    @MethodSource("initWinLottoRequestDtoData")
    void amountStringToIntegerTest(String winLottoNumber, List<Integer> lotto) {
        WinLottoRequestDto winLottoRequestDto = new WinLottoRequestDto(winLottoNumber);

        Assertions.assertThat(lotto).isEqualTo(winLottoRequestDto.lottoStringToList());
    }

    static Stream<Arguments> initWinLottoRequestDtoData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("7,8,9,10,11,12", List.of(7, 8, 9, 10, 11, 12)),
                Arguments.of("13,14,15,16,17,18", List.of(13, 14, 15, 16, 17, 18))
        );
    }

}