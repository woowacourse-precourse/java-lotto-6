package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    LottoMachine lottoMachine = LottoMachine.getInstance();

    @ParameterizedTest
    @DisplayName("요청 갯수 만큼 로또 번호 생성 테스트")
    @ValueSource(ints = {1, 5, 10, 23})
    void createLottoNumberRangeCheckTest(int quantity) {
        List<Lotto> lottos = lottoMachine.createLottos(quantity);

        Assertions.assertThat(lottos.size()).isEqualTo(quantity);
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 번호 비교 테스트")
    @MethodSource("initWitLottoData")
    void lottoNumberWinningComparisonTest(
            List<Integer> winLottoNumber
            , int bonusNumber
            , Lotto otherLotto
            , LottoRank reuslt
    ) {
        LottoMachine instance = LottoMachine.getInstance();
        instance.setWinLotto(new WinLotto(new Lotto(winLottoNumber), bonusNumber));

        Assertions.assertThat(instance.lottoWinningResult(otherLotto)).isEqualTo(reuslt);
    }

    static Stream<Arguments> initWitLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 45)
                        , 44
                        , new Lotto(List.of(1, 2, 3, 4, 5, 45))
                        , LottoRank.FIRST_PRIZE),
                Arguments.of(List.of(2, 18, 3, 4, 5, 6)
                        , 23
                        , new Lotto(List.of(2, 18, 3, 4, 5, 23))
                        , LottoRank.SECOND_PRIZE),
                Arguments.of(List.of(15, 2, 23, 43, 5, 6)
                        , 19
                        , new Lotto(List.of(3, 4, 7, 8, 9, 10))
                        , LottoRank.NO_PRIZE)
        );
    }
}