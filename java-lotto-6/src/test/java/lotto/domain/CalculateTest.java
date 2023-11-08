package lotto.domain;

import static lotto.domain.Calculate.calculateReturnRate;
import static lotto.domain.Calculate.getMatchingNumber;
import static lotto.domain.Calculate.printReturnValue;
import static lotto.domain.Calculate.returnStatistics;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

class CalculateTest {

  @Test
  void calculateReturnRateTest() {

    int lottoPurchaseAmount = 100000;
    List<Double>actualReturnValue = new ArrayList<>();
    actualReturnValue = List.of(5.0,50.0,1500.0,30000.0,2000000.0);
    List<Integer> statistics = new ArrayList<>();
    statistics = List.of(1,0,0,0,0);
    double expectedReturnRate = calculateReturnRate(statistics,lottoPurchaseAmount);
    assertEquals(expectedReturnRate, actualReturnValue.get(0));

    statistics = List.of(0,1,0,0,0);
    expectedReturnRate = calculateReturnRate(statistics,lottoPurchaseAmount);
    assertEquals(expectedReturnRate, actualReturnValue.get(1));

    statistics = List.of(0,0,1,0,0);
    expectedReturnRate = calculateReturnRate(statistics,lottoPurchaseAmount);
    assertEquals(expectedReturnRate, actualReturnValue.get(2));

    statistics = List.of(0,0,0,1,0);
    expectedReturnRate = calculateReturnRate(statistics,lottoPurchaseAmount);
    assertEquals(expectedReturnRate, actualReturnValue.get(3));

    statistics = List.of(0,0,0,0,1);
    expectedReturnRate = calculateReturnRate(statistics,lottoPurchaseAmount);
    assertEquals(expectedReturnRate, actualReturnValue.get(4));
  }

  @Test
  void printReturnValueTest() {
    List<Integer> statistics = new ArrayList<>();
    statistics = List.of(1,0,0,0,0);
    String actualOutput = printReturnValue(statistics,1000);

    String expectedOutput = "총 수익률은 500.0%입니다.";
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  void returnStatisticsTest() {
    List<Integer> expectedStatistics = new ArrayList<>();
    expectedStatistics = List.of(0,0,0,0,1);
    List<Integer> winNum = List.of(1,2,3,4,5,6);
    int bonusNum = 7;

    List<Integer> oneNumbers = List.of(1,2,3,4,5,6);
    List<Integer> twoNumbers = List.of(7,8,9,10,11,12);
    Lotto []randomNumbers = new Lotto[2];
    randomNumbers[0] = new Lotto(oneNumbers);
    randomNumbers[1] = new Lotto(twoNumbers);
    List<Integer> actualStatistics =returnStatistics(randomNumbers,winNum, bonusNum);
    assertEquals(expectedStatistics,actualStatistics);
  }

  @Test
  void getMatchingNumberTest() {
    List<Integer> winNum = List.of(1, 2, 3, 4, 5, 6);
    Lotto oneCombination = new Lotto(List.of(3, 4, 5, 6, 7, 8));

    int expectedMatchingNumber = 4;

    int actualMatchingNumber = getMatchingNumber(winNum, oneCombination);

    assertEquals(expectedMatchingNumber, actualMatchingNumber);
  }
}