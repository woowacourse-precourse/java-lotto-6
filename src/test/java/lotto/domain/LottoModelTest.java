package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import lotto.Lotto;
import lotto.data.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


class LottoModelTest {
    private final List<Integer> WINNING_NUMS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private final int CHECK_BONUS = 999;
    private final int BONUS_NUM = 40;

    private LottoModel lottoModel;

    @BeforeEach
    void setUp() {
        lottoModel = new LottoModel();
    }

    @ParameterizedTest
    @CsvSource({"5000,8000,62.5", "10000,8000,125.0"})
    void computeRate_소숫점_둘째자리에서_반올림_확인(int totalEarned, int purchased, String expect) {
        assertThat(lottoModel.computeRate(totalEarned,purchased))
                .isEqualTo(expect);
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
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 0);
        expect.put(2, 0);
        expect.put(3, 0);
        expect.put(4, 0);
        expect.put(5, 0);
        expect.put(6, 0);
        assertThat(lottoModel.initWinningNumsTable(WINNING_NUMS)).isEqualTo(expect);
    }

    @Test
    void compareLotto_당첨번호_확인_1등() {
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 1);
        expect.put(2, 1);
        expect.put(3, 1);
        expect.put(4, 1);
        expect.put(5, 1);
        expect.put(6, 1);
        assertThat(lottoModel.compareLotto(WINNING_NUMS, new MockLotto(List.of(1, 2, 3, 4, 5, 6)), BONUS_NUM))
                .isEqualTo(expect);
    }

    @Test
    void compareLotto_당첨번호_확인_2등() {
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 1);
        expect.put(2, 1);
        expect.put(3, 1);
        expect.put(4, 1);
        expect.put(5, 1);
        expect.put(6, 0);
        expect.put(BONUS_NUM, 1);
        assertThat(lottoModel.compareLotto(WINNING_NUMS, new MockLotto(List.of(1, 2, 3, 4, 5, BONUS_NUM)), BONUS_NUM))
                .isEqualTo(expect);
    }

    @Test
    void compareLotto_당첨번호_확인_3등() {
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 1);
        expect.put(2, 1);
        expect.put(3, 1);
        expect.put(4, 1);
        expect.put(5, 1);
        expect.put(6, 0);
        assertThat(lottoModel.compareLotto(WINNING_NUMS, new MockLotto(List.of(1, 2, 3, 4, 5, 16)), BONUS_NUM))
                .isEqualTo(expect);
    }

    @Test
    void compareLotto_당첨번호_확인_4등() {
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 1);
        expect.put(2, 1);
        expect.put(3, 1);
        expect.put(4, 1);
        expect.put(5, 0);
        expect.put(6, 0);
        assertThat(lottoModel.compareLotto(WINNING_NUMS, new MockLotto(List.of(1, 2, 3, 4, 15, 16)), BONUS_NUM))
                .isEqualTo(expect);
    }

    @Test
    void compareLotto_당첨번호_확인_5등() {
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, 1);
        expect.put(2, 1);
        expect.put(3, 1);
        expect.put(4, 0);
        expect.put(5, 0);
        expect.put(6, 0);
        assertThat(lottoModel.compareLotto(WINNING_NUMS, new MockLotto(List.of(1, 2, 3, 14, 15, 16)), BONUS_NUM))
                .isEqualTo(expect);
    }

    @Test
    void makeWinningTable_당첨여부_판단_1등() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 1);
        expect.put(Rewards.SECOND, 0);
        expect.put(Rewards.THIRD, 0);
        expect.put(Rewards.FOURTH, 0);
        expect.put(Rewards.FIFTH, 0);
        assertThat(lottoModel.makeWinningTable(6, false))
                .isEqualTo(expect);
    }

    @Test
    void makeWinningTable_당첨여부_판단_2등() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 0);
        expect.put(Rewards.SECOND, 1);
        expect.put(Rewards.THIRD, 0);
        expect.put(Rewards.FOURTH, 0);
        expect.put(Rewards.FIFTH, 0);
        assertThat(lottoModel.makeWinningTable(5, true))
                .isEqualTo(expect);
    }

    @Test
    void makeWinningTable_당첨여부_판단_3등() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 0);
        expect.put(Rewards.SECOND, 0);
        expect.put(Rewards.THIRD, 1);
        expect.put(Rewards.FOURTH, 0);
        expect.put(Rewards.FIFTH, 0);
        assertThat(lottoModel.makeWinningTable(5, false))
                .isEqualTo(expect);
    }

    @Test
    void makeWinningTable_당첨여부_판단_4등() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 0);
        expect.put(Rewards.SECOND, 0);
        expect.put(Rewards.THIRD, 0);
        expect.put(Rewards.FOURTH, 1);
        expect.put(Rewards.FIFTH, 0);
        assertThat(lottoModel.makeWinningTable(4, false))
                .isEqualTo(expect);
    }

    @Test
    void makeWinningTable_당첨여부_판단_5등() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 0);
        expect.put(Rewards.SECOND, 0);
        expect.put(Rewards.THIRD, 0);
        expect.put(Rewards.FOURTH, 0);
        expect.put(Rewards.FIFTH, 1);
        assertThat(lottoModel.makeWinningTable(3, false))
                .isEqualTo(expect);
    }


    static Stream<Arguments> parameterProviderPublishTicket() {
        return Stream.of(
                arguments(Arrays.asList(5, 7, 9, 3, 1), "[1, 3, 5, 7, 9]")
        );
    }


    class MockLotto extends Lotto {
        private List<Integer> numbers;

        MockLotto(List<Integer> numbers) {
            super(numbers);
        }
    }

}