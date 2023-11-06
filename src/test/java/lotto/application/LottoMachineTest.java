package lotto.application;

import lotto.domain.Lotto;
import lotto.global.constant.enums.MatchResultType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@DisplayName("LottoMachine 테스트")
class LottoMachineTest {

    @DisplayName("자동 로또 발행 테스트")
    @RepeatedTest(
            value = 1_000,
            name = "{displayName}, {currentRepetition}/{totalRepetitions}"
    )
    public void Case_Auto_Lotto() {
        Lotto autoLotto = LottoMachine.issueAutomaticLotto();
        Assertions.assertThat(autoLotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("수동 로또 발행 테스트")
    @ParameterizedTest(name = "{index} : 입략 로또 번호 = {0}")
    @MethodSource("argumentsForManualLotto")
    public void Case_Manual_Lotto(List<Integer> lottoNumbers) {
        // 무작위 정렬 숫자 리스트를 통해 수동 발행한 로또 생성
        Lotto autoLotto = LottoMachine.issueManualLotto(lottoNumbers);

        // 같은 번호 구성으로 정렬하여 새로운 로또를 생성
        List<Integer> sameNumbers = new ArrayList<>(lottoNumbers);
        sameNumbers.sort(Integer::compareTo);
        Lotto sameLotto = new Lotto(sameNumbers);

        Assertions.assertThat(autoLotto).isInstanceOf(Lotto.class);
        // 무작위 정렬 숫자를 넣더라도 잘 정렬되어 로또가 생성된 것인지 확인
        Assertions.assertThat(sameLotto).usingRecursiveComparison().isEqualTo(autoLotto);
    }
    private static Stream<Arguments> argumentsForManualLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(40, 41, 42, 43, 44, 45)),
                Arguments.of(List.of(11, 22, 33, 44, 1, 2)),
                Arguments.of(List.of(45, 1, 14, 29, 23, 17))
        );
    }

    @DisplayName("로또 비교 테스트")
    @ParameterizedTest(name = "{index} : Lotto_A Numbers = {0} & Lotto_B Numbers = {1}, Expected = {2}")
    @MethodSource("argumentsForComparingLottos")
    public void Case_Compare_And_Matching_Lotto(
            List<Integer> numbersOfLottoA,
            List<Integer> numbersOfLottoB,
            int bonusNumber,
            MatchResultType expectedMatchType
    ) {
        Lotto lottaA = new Lotto(numbersOfLottoA);
        Lotto lottoB = new Lotto(numbersOfLottoB);

        Assertions.assertThat(LottoMachine.match(lottaA, lottoB, bonusNumber))
                .isEqualTo(expectedMatchType);
    }
    private static Stream<Arguments> argumentsForComparingLottos() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 7, 8, 9),
                        45,
                        MatchResultType.MATCH_THREE
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 7, 8),
                        45,
                        MatchResultType.MATCH_FOUR
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 7),
                        45,
                        MatchResultType.MATCH_FIVE
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 7),
                        6,
                        MatchResultType.MATCH_FIVE_WITH_BONUS
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        45,
                        MatchResultType.MATCH_SIX
                ),
                // 0개가 일치한 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 12),
                        45,
                        MatchResultType.BOOM
                ),
                // 1개가 일치한 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 7, 8, 9, 10, 11),
                        45,
                        MatchResultType.BOOM
                ),
                // 2개가 일치한 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 7, 8, 9, 10),
                        45,
                        MatchResultType.BOOM
                )
        );
    }

}