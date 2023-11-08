package lotto.service;

import lotto.domain.*;
import lotto.service.StatisticsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsGeneratorTest {
    @DisplayName("2개 이하 맞췄을 때 확인")
    @Test
    void createUnderTwoMatchesStatistics() {
        int budget = 1000;
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(40,41,42,43,44,45))); //0
        lottos.addLotto(new Lotto(List.of(1,8,10,15,20,25))); //1
        lottos.addLotto(new Lotto(List.of(1,5,10,15,20,25))); //2
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }

    @DisplayName("당첨번호 2개 이하 맞추고 보너스 번호 맞췄을 때 확인")
    @Test
    void createUnderTwoAndBonusMatchesStatistics() {
        int budget = 1000;
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(40,41,42,43,44,7))); //0
        lottos.addLotto(new Lotto(List.of(1,8,10,15,20,7))); //1
        lottos.addLotto(new Lotto(List.of(1,5,10,15,20,7))); //2
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }

    @DisplayName("3개 맞췄을 때 확인")
    @Test
    void createThreeMatchesStatistics() {
        int budget = 1000;
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",1,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,4,5,6))); //3
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }

    @DisplayName("4개 맞췄을 때 확인")
    @Test
    void createFourMatchesStatistics() {
        int budget = 1000;
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",1,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,11,12,13))); //4
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }

    @DisplayName("5개 맞췄을 때 확인")
    @Test
    void createFiveMatchesStatistics() {
        int budget = 1000;
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",1,
                "matchesFiveAndBonus",0,
                "matchesSix",0
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,11,22,44))); //5
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }

    @DisplayName("5개 맞추고 보너스 번호 맞췄을 때 확인")
    @Test
    void createFiveAndBonusMatchesStatistics() {
        int budget = 1000;
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",1,
                "matchesSix",0
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,11,22,7))); //5 + 보너스
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }

    @DisplayName("6개 맞췄을 때 확인")
    @Test
    void createSixMatchesStatistics() {
        int bonus = 7;
        BonusNumber bonusNumber = new BonusNumber(bonus);
        Map<String, Integer> statisticsMatchesCounts = Map.of(
                "matchesThree",0,
                "matchesFour",0,
                "matchesFive",0,
                "matchesFiveAndBonus",0,
                "matchesSix",1
        );
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1,2,3,11,22,33)));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,11,22,33");
        WinningCombination winningCombination = new WinningCombination(winningLottoNumbers, bonusNumber);

        StatisticsGenerator statisticsGenerator = new StatisticsGenerator(lottos,winningCombination);
        assertThat(statisticsGenerator.generateMatchesCount())
                .isEqualTo(statisticsMatchesCounts);
    }
}