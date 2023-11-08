package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    private static Stream<Arguments> provideLottoAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 3, 7, 10, 13, 45), "FIFTH"),
                Arguments.of(List.of(1, 3, 7, 8, 29, 45), "FOURTH"),
                Arguments.of(List.of(1, 3, 7, 8, 9, 45), "THIRD"),
                Arguments.of(List.of(1, 3, 7, 8, 9, 18), "SECOND"),
                Arguments.of(List.of(1, 3, 7, 8, 9, 11), "FIRST")
        );
    }


    @DisplayName("당첨번호 : [1,3,7,8,9,11] ,보너스 번호 : 18 인경우 등수 판별")
    @ParameterizedTest(name = "로또번호 :{0}, 예상등수 : {1}")
    @MethodSource("provideLottoAndResult")
    void calculateLottoPlace(List<Integer> numbers, String expected) {
        Lotto lotto = new Lotto(numbers);
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 3, 7, 8, 9, 11));
        Integer bonusNumber = 18;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Optional<LottoPlace> lottoPlace = lotto.calculateLottoPlace(winningLotto);

        assertThat(lottoPlace).containsSame(LottoPlace.valueOf(expected));
    }
}
