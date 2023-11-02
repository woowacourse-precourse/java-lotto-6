package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    @Test
    @DisplayName("로또의 번호 생성 테스트")
    void createLottoNumberRangeCheckTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        List<Integer> createLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // new Lotto 생성 시 로또 범위 1 ~ 45 / 로또 번호 중복 / 로또 갯수 검증
        Assertions.assertThatNoException().isThrownBy(() -> new Lotto(createLottoNumber));
    }

    @ParameterizedTest
    @DisplayName("입력된 당첨 번호 로또 생성 테스트")
    @MethodSource("initWitLottoData")
    void winLottoNumberRangeCheckTest(List<Integer> winLottoNumber) {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        // new Lotto 생성 시 로또 범위 1 ~ 45 / 로또 번호 중복 / 로또 갯수 검증
        Assertions.assertThatNoException().isThrownBy(() -> new Lotto(winLottoNumber));
    }

    static Stream<Arguments> initWitLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 45)),
                Arguments.of(List.of(2, 18, 3, 4, 5, 6)),
                Arguments.of(List.of(15, 2, 23, 43, 5, 6))
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 비교 테스트")
    void lottoNumberWinningComparisonTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    }
}