package lotto.domain.result;

import lotto.domain.customer.Customer;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultServiceTest {
    private static final int PRICE = 10000;
    private ResultService resultService;

    @BeforeEach
    void setUp() {
        resultService = new ResultService(new Result(
                new Customer("5000"), new WinningNumber("1,2,3,4,5,6", "7")));
    }

    @DisplayName("두 숫자 리스트를 비교해서 존재하는 같은 숫자의 갯수 만큼 값을 반환한다.")
    @Test
    void getSameNumberCount() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(4,5,6,7,8,9);
        int sameNumberCount = resultService.countSameNumber(lottoNumbers, winningNumbers);
        assertThat(sameNumberCount).isEqualTo(3);
    }

    @DisplayName("숫자 리스트에 특정 한 숫자가 있는지 확인하여 boolean 반환한다.")
    @Test
    void containsValueInList() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int value = 3;
        boolean containsOrNot = resultService.containSameNumber(numbers, value);
        assertThat(containsOrNot).isTrue();
    }

    @DisplayName("일치하는 숫자 갯수로 로또 등수를 매긴다.")
    @Test
    void giveGradeBySameNumberCount() {
        int sameCount = 5;
        boolean containsOrNot = false;
        Grade grade = resultService.giveGrade(sameCount, containsOrNot);
        assertThat(grade).isEqualTo(Grade.THIRD);
    }

    @DisplayName("전체 등수를 받아서 총 상금 합계를 구한다.")
    @Test
    void getTotalPrizeByGrades() {
        List<Grade> grades = Arrays.asList(Grade.FIRST, Grade.THIRD, Grade.FIFTH);
        long totalPrize = resultService.sumAllPrize(grades);
        long answer = Grade.FIRST.getPrize() + Grade.THIRD.getPrize() + Grade.FIFTH.getPrize();
        assertThat(totalPrize).isEqualTo(answer);
    }

    @DisplayName("퍼센트 구해서 둘째자리에서 반올림하여 반환 - 최대 수익률")
    @Test
    void maxPercentage() {
        int price = PRICE;
        long prize = 20000000000L;
        String percentage = resultService.calculatePercentage(price, prize);
        assertThat(percentage).isEqualTo("200,000,000.0");
    }

    @DisplayName("퍼센트 구해서 둘째자리에서 반올림하여 반환 - 수익률 100% 미만")
    @Test
    void priceIsGreaterThanPrice() {
        int price = PRICE;
        long prize = 5000L;
        String percentage = resultService.calculatePercentage(price, prize);
        assertThat(percentage).isEqualTo("50.0");
    }

    @DisplayName("퍼센트 구해서 둘째자리에서 반올림하여 반환 - 수익률 0%")
    @Test
    void zeroPercent() {
        int price = PRICE;
        long prize = 0L;
        String percentage = resultService.calculatePercentage(price, prize);
        assertThat(percentage).isEqualTo("0.0");
    }
}