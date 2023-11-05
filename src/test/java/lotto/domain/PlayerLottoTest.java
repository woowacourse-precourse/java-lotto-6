package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerLottoTest {

    Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 45, 43));
    LottoNumber bonusNumber = new LottoNumber(6);

    @Nested
    @DisplayName("최종 성적을 계산하는 기능 테스트")
    class calculateResultTest {
        @Test
        void totalTest() {
            // given
            PlayerLotto playerLotto = makeLottoTickets();
            Lotto winningNumber = new Lotto(List.of(1, 3, 2, 4, 7, 5));
            LottoNumber bonusNumber = new LottoNumber(27);
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
        }

        @Test
        @DisplayName("당첨 번호와 5개 일치하고, 보너스 번호 일치")
        void criticalBranchTest1() {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(List.of(1, 45, 3, 4, 2, 6))));
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.SECOND);
        }

        @Test
        @DisplayName("당첨 번호와 5개 일치하고, 보너스 번호 불일치")
        void criticalBranchTest2() {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(List.of(1, 45, 3, 4, 2, 21))));
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.THIRD);
        }

        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:6",
                "11,12,13,14,15,16:16,15,14,13,12,11:23"}, delimiter = ':')
        @DisplayName("1등 테스트 - 6개 일치, 보너스 볼 일치 여부 상관 없음")
        void firstRankWhetherBonusMatchOrNot(String playerLottoInput, String winningNumberInput, int bonusNumberInput) {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(create(playerLottoInput))));
            Lotto winningNumber = new Lotto(create(winningNumberInput));
            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.FIRST);
        }

        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,6,21:5",
                "11,12,13,14,15,16:16,15,14,13,12,29:11"}, delimiter = ':')
        @DisplayName("2등 테스트 - 5개 일치, 보너스 볼 일치")
        void secondTest(String playerLottoInput, String winningNumberInput, int bonusNumberInput) {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(create(playerLottoInput))));
            Lotto winningNumber = new Lotto(create(winningNumberInput));
            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.SECOND);
        }

        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,6,21:7",
                "11,12,13,14,15,16:16,15,14,13,12,29:17"}, delimiter = ':')
        @DisplayName("3등 테스트 - 5개 일치, 보너스 볼 불일치")
        void thirdTest(String playerLottoInput, String winningNumberInput, int bonusNumberInput) {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(create(playerLottoInput))));
            Lotto winningNumber = new Lotto(create(winningNumberInput));
            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.THIRD);
        }

        @Test
        @DisplayName("당첨 번호와 4개 일치하고, 보너스 번호 일치")
        void forthTestWhenBonusMatch() {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.FOURTH);
        }

        @Test
        @DisplayName("당첨 번호와 4개 일치하고, 보너스 번호 불일치하는 경우")
        void fourthTestWhenBonusNotMatch() {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(List.of(1, 2, 3, 23, 4, 5))));
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.FOURTH);
        }

        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:1,3,6,21,27,34:45",
                "11,12,13,14,15,16:16,15,14,21,22,29:11"}, delimiter = ':')
        @DisplayName("5등 테스트 - 3개 일치, 보너스 볼 일치 여부 상관 없음")
        void fifthTest(String playerLottoInput, String winningNumberInput, int bonusNumberInput) {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(create(playerLottoInput))));
            Lotto winningNumber = new Lotto(create(winningNumberInput));
            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.FIFTH);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "1,3,11,23,34,44:1,3,6,21,27,33:45",

                "29,22,1,2,3,11:16,15,14,21,22,29:11",

                "11,12,13,14,15,16:11,17,18,19,20,21:22",

                "17,18,19,20,21,22:22,23,24,25,26,27:17",

                "30,31,32,33,34,35:36,37,38,39,40,41:42",

                "40,41,42,43,44,45:1,2,3,4,5,6:40"}, delimiter = ':')
        void noneTest(String playerLottoInput, String winningNumberInput, int bonusNumberInput) {
            // given
            PlayerLotto playerLotto = new PlayerLotto(List.of(new Lotto(create(playerLottoInput))));
            Lotto winningNumber = new Lotto(create(winningNumberInput));
            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
            // when
            List<Rank> ranks = playerLotto.calculateResult(winningNumber, bonusNumber);
            // then
            Assertions.assertThat(ranks).containsExactly(Rank.NONE);
        }
    }

    private static List<Integer> create(String playerLottoInput) {
        List<Integer> list = Arrays.stream(playerLottoInput.split(","))
                .map(Integer::parseInt)
                .toList();
        return list;
    }

    private PlayerLotto makeLottoTickets() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 5, 7, 27)),
                new Lotto(List.of(1, 4, 5, 7, 2, 28)),
                new Lotto(List.of(7, 4, 2, 3, 30, 37)),
                new Lotto(List.of(2, 3, 7, 11, 12, 13)));
        return new PlayerLotto(playerLotto);
    }

}