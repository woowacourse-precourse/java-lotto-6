package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import lotto.data.Lotto;
import lotto.data.Rewards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


class LottoModelTest {
    private final int BONUS_NUM = 40;
    private final int CHECK_BONUS = 999;
    private final List<Integer> WINNING_NUMS = Arrays.asList(1, 2, 3, 4, 5, 6);

    static Stream<Arguments> parameterProviderPublishTicket() {
        return Stream.of(
                arguments(Arrays.asList(5, 7, 9, 3, 1), "[1, 3, 5, 7, 9]")
        );
    }

    private LottoModel lottoModel;

    class MockLotto extends Lotto {
        private List<Integer> numbers;

        MockLotto(List<Integer> numbers) {
            super(numbers);
        }
    }

    @BeforeEach
    void setUp() {
        lottoModel = new LottoModel();
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,1,1,1,1,1,2,3,4,5,6",
            "1,1,1,1,1,0,1,2,3,4,5,16",
            "1,1,1,1,0,0,1,2,3,4,15,16",
            "1,1,1,0,0,0,1,2,3,14,15,16"
    })
    void compareLotto_당첨번호_확인_1_3_4_5등(
            int expect1, int expect2, int expect3, int expect4, int expect5, int expect6,
            int winNum1, int winNum2, int winNum3, int winNum4, int winNum5, int winNum6
    ) {
        HashMap<Integer, Integer> expect = new HashMap<>();
        expect.put(1, expect1);
        expect.put(2, expect2);
        expect.put(3, expect3);
        expect.put(4, expect4);
        expect.put(5, expect5);
        expect.put(6, expect6);
        assertThat(lottoModel.compareLotto(
                WINNING_NUMS,
                new MockLotto(List.of(winNum1, winNum2, winNum3, winNum4, winNum5, winNum6)),
                BONUS_NUM))
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
        expect.put(CHECK_BONUS, 1);
        assertThat(lottoModel.compareLotto(
                WINNING_NUMS,
                new MockLotto(List.of(1, 2, 3, 4, 5, BONUS_NUM)),
                BONUS_NUM))
                .isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"5000,8000,62.5", "10000,8000,125.0"})
    void computeRate_소숫점_둘째자리에서_반올림_확인(int totalEarned, int purchased, String expect) {
        assertThat(lottoModel.computeRate(totalEarned, purchased))
                .isEqualTo(expect);
    }

    @Test
    void generateNewLotto_로또_번호_발행_오름차순_정렬_테스트() {
        List<Integer> expect = new ArrayList<>(List.of(1, 3, 5, 7, 9, 11));
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoModel.generateNewLotto())
                            .isEqualTo(expect);
                }, List.of(5, 1, 7, 11, 9, 3)
        );
    }

    @DisplayName("구매 금액만큼의 로또 번호를 발행 기능 단위 테스트")
    @Test
    void publishLotto() {
        List<Lotto> expect = new ArrayList<>();
        int numOfLotto = 1;
        MockLotto mockLotto = new MockLotto(List.of(1, 3, 5, 7, 9, 11));
        expect.add(mockLotto);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> result = lottoModel.publishLotto(numOfLotto);
                    assertThat(result.get(0).getNumbers())
                            .isEqualTo(mockLotto.getNumbers());
                }, List.of(5, 1, 7, 11, 9, 3)
        );
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
    void initWinningTable_당첨로또_테이블_생성_확인() {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, 0);
        expect.put(Rewards.SECOND, 0);
        expect.put(Rewards.THIRD, 0);
        expect.put(Rewards.FOURTH, 0);
        expect.put(Rewards.FIFTH, 0);
        assertThat(lottoModel.initWinningTable()).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("parameterProviderPublishTicket")
    void publishTicket_로또번호_오름차순_발급_확인(List<Integer> lottoNums, String expect) {
        assertThat(lottoModel.publishTicket(lottoNums)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({
            "1,0,0,0,0,6,false",
            "0,1,0,0,0,5,true",
            "0,0,1,0,0,5,false",
            "0,0,0,1,0,4,false",
            "0,0,0,0,1,3,false"
    })
    void makeWinningTable_당첨여부_판단(int expect1, int expect2, int expect3, int expect4,
                                  int expect5, int result, boolean bonus) {
        HashMap<Rewards, Integer> expect = new HashMap<>();
        expect.put(Rewards.FIRST, expect1);
        expect.put(Rewards.SECOND, expect2);
        expect.put(Rewards.THIRD, expect3);
        expect.put(Rewards.FOURTH, expect4);
        expect.put(Rewards.FIFTH, expect5);
        assertThat(lottoModel.makeWinningTable(result, bonus))
                .isEqualTo(expect);
    }

}