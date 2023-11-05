package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import lotto.data.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


class LottoModelTest {
    private LottoModel lottoModel;

    @BeforeEach
    void setUp() {
        lottoModel = new LottoModel();
    }

    @ParameterizedTest
    @CsvSource({"14.234,14.2", "14.286,14.3"})
    void computeRate_소숫점_둘째자리에서_반올림_확인(double test, String expect) {
        assertThat(lottoModel.computeRate(test)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("parameterProviderPublishTicket")
    void publishTicket_로또번호_오름차순_발급_확인(List<Integer> lottoNums, String expect) {
        assertThat(lottoModel.publishTicket(lottoNums)).isEqualTo(expect);
    }

    @Test
    void initWinningTable_당첨로또_테이블_생성_확인() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 0);
        expect.put(Rewards.SECOND, 0);
        expect.put(Rewards.THIRD, 0);
        expect.put(Rewards.FOURTH, 0);
        expect.put(Rewards.FIFTH, 0);
        assertThat(lottoModel.initWinningTable()).isEqualTo(expect);
    }

    @Test
    void initWinningNumsTable_로또_당첨번호_테이블_생성_확인() {
        List<Integer> winnings = Arrays.asList(1,2,3,4,5,6);
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 0);
        expect.put(2, 0);
        expect.put(3, 0);
        expect.put(4, 0);
        expect.put(5, 0);
        expect.put(6, 0);
        assertThat(lottoModel.initWinningNumsTable(winnings)).isEqualTo(expect);
    }

    static Stream<Arguments> parameterProviderPublishTicket() {
        return Stream.of(
                arguments(Arrays.asList(5, 7, 9, 3, 1), "[1, 3, 5, 7, 9]")
        );
    }
}