package lotto.domain;

import lotto.constants.WinningInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constants.WinningInfo.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 정보를 요청하면 [{숫자},{숫자},{숫자},{숫자},{숫자},{숫자}] 꼴로 반환한다.")
    @Test
    void successGetNumbersInfo() {
        Lotto lotto = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));

        String numbersInfo = assertDoesNotThrow(() -> lotto.getInfoOfNumbers());
        assertThat(numbersInfo)
                .isEqualTo(String.format("[%d, %d, %d, %d, %d, %d]", 1, 2, 3, 4, 5, 6));
    }

    private static Stream<Arguments> successCalculateResultScenarios() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, FIRST_RANK),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 10), 6, SECOND_RANK),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 10), 7, THIRD_RANK),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 9, 10), 7, FOURTH_RANK),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 8, 9, 10), 7, FIFTH_RANK)
        );
    }

    @DisplayName("당첨 번호 정보를 전달하면 해당하는 당첨 정보를 가진 Result 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("successCalculateResultScenarios")
    void successCalculateResult(List<Integer> lottoNumbers, List<Integer> targetNumbers,
                                int bonusNumber, WinningInfo winningInfo) {
        Lotto lotto = Lotto.createLotto(lottoNumbers);
        Target target = Target.createTarget(targetNumbers, bonusNumber);

        Result result = assertDoesNotThrow(() -> lotto.compareWithTargetAndCreateResult(target));
        assertThat(result.getWinningInfo()).isNotEmpty();

        WinningInfo createdWinningInfo = result.getWinningInfo().get();
        assertThat(createdWinningInfo).isEqualTo(winningInfo);
    }
}