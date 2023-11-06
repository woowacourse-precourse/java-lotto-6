package lotto.domain;

import static lotto.constant.testConstant.BONUS_NUMBER_45;
import static lotto.constant.testConstant.LOTTO_1_TO_5_WITH_45;
import static lotto.constant.testConstant.LOTTO_1_TO_6;
import static lotto.constant.testConstant.LOTTO_4_TO_9;
import static lotto.constant.testConstant.LOTTO_7_TO_12;
import static lotto.domain.MatchingCase.FIVE_MATCHING;
import static lotto.domain.MatchingCase.FIVE_MATCHING_WITH_BONUS;
import static lotto.domain.MatchingCase.FOUR_MATCHING;
import static lotto.domain.MatchingCase.SIX_MATCHING;
import static lotto.domain.MatchingCase.THREE_MATCHING;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.testConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoCollectionTest {
    List<Lotto> lottos = List.of(LOTTO_1_TO_6, LOTTO_7_TO_12);

    @DisplayName("from은 로또 리스트를 받아서 로또 컬렉션 객체를 생성한다")
    @Test
    void check_from() {
        assertThat(LottoCollection.from(lottos)).isInstanceOf(LottoCollection.class);

        assertThat(LottoCollection.from(lottos).getLottoCollection())
                .hasSize(lottos.size())
                .allSatisfy(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }

    @DisplayName("getResultGroup은 각 로또별 비교 결과를 받아서 리스트로 담는다")
    @Test
    void check_getResultGroup() {
        LottoCollection lottoCollection = LottoCollection.from(List.of(LOTTO_1_TO_6, LOTTO_7_TO_12));
        Lotto winningLotto = new Lotto(List.of(1, 2, 7, 41, 42, 43));
        int bonusNumber = 8;
        List<LottoResult> resultGroup = lottoCollection.getResultGroup(winningLotto, bonusNumber);
        assertThat(resultGroup).containsExactly(LottoResult.of(2, false)
                , LottoResult.of(1, true));
    }

    public static Stream<Arguments> lottoResult() {
        return Stream.of(
                Arguments.of(List.of(LOTTO_1_TO_6, LOTTO_7_TO_12), FIVE_MATCHING, 1),
                Arguments.of(List.of(LOTTO_1_TO_5_WITH_45, LOTTO_7_TO_12), FIVE_MATCHING_WITH_BONUS, 1)
        );
    }

    @DisplayName("setResultGroup은 비교 결과들을 당첨 통계에 반영한다")
    @ParameterizedTest
    @MethodSource("lottoResult")
    void check_setResultGroup(List<Lotto> lottos, MatchingCase matchingCase, int winningCount) {
        LottoCollection lottoCollection = LottoCollection.from(lottos);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        lottoCollection.setResultGroup(winningLotto, BONUS_NUMBER_45);
        assertThat(matchingCase.getWinningCount()).isEqualTo(winningCount);
    }
}
