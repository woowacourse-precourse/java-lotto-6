package lotto.formatter;

import lotto.domain.lotto.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("플레이어 로또들 객체에 대해")
class PlayerLottosFormatterTest {

    static Stream<List<Numbers>> lottosResources() {
        Numbers numbers1 = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = new Numbers(List.of(7, 8, 9, 10, 11, 12));
        return Stream.of(List.of(numbers1, numbers2));
    }

    @ParameterizedTest
    @MethodSource("lottosResources")
    @DisplayName("로또 생성 결과에 따라 출력 형태를 얻는다.")
    void Given_CreatePlayerLottosFormatter_When_toPlayerLottoResultMessage_Then_EqualType(List<Numbers> values) {
        //given
        PlayerLottosFormatter playerLottosFormatter = new PlayerLottosFormatter(values);

        //when
        String resultLottoMessage = playerLottosFormatter.toPlayerLottosResultMessage();

        //then
        assertThat(resultLottoMessage).isEqualTo(
                """
                        2개를 구매했습니다.
                        [1, 2, 3, 4, 5, 6]
                        [7, 8, 9, 10, 11, 12]
                        """
        );

    }
}
