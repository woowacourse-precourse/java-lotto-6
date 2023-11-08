package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class PrizeTest {
    static Prize prize;
    @BeforeAll
    static void prepare() {
        prize = new Prize();
    }

    @DisplayName("맞힌 점수에 따른 1등~6등 테스트")
    @ParameterizedTest
    @CsvSource({
            "6, false, 1", // (1등) 6개 번호 일치
            "5, true, 2",  // (2등) 5개 번호 + 보너스 번호 일치
            "5, false, 3", // (3등) 5개 번호 일치
            "4, true, 3",  // (3등) 5개 번호 일치
            "4, false, 4", // (4등) 4개 번호 일치
            "3, true, 4",  // (4등) 4개 번호 일치
            "3, false, 5", // (5등) 3개 번호 일치
            "2, true, 5"   // (5등) 3개 번호 일치
    })
    void gradeTest(int sameCount, boolean bonusSame, int expectedGrade) {
        int grade = prize.getGrade(sameCount, bonusSame);
        Assertions.assertThat(grade).isEqualTo(expectedGrade);
    }

    @DisplayName("등수에 따른 상금 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, 2_000_000_000",
            "2, 30_000_000",
            "3, 1_500_000",
            "4, 50_000",
            "5, 5_000"
    })
    void moneyTest(int grade, int expectedMoney) {
        int money = prize.getMoney(grade);
        Assertions.assertThat(money).isEqualTo(expectedMoney);
    }
}