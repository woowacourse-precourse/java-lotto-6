package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ResultServiceTest {
    ResultService resultService;
    List<Integer> winningNumber;
    int bonusNumber;
    Map<Integer,Integer> winningResult = new HashMap<>();
    List<LottoPurchase> userLotteries = new ArrayList<>();

    @BeforeEach
    void setup() {
        resultService = new ResultService();
        winningNumber = List.of(1,2,3,4,5,6);
        bonusNumber = 7;
    }
    @BeforeEach
    void generateUserLotteries() {
        userLotteries.add(LottoPurchase.userLotteryFrom(Arrays.asList(1,3,5,7,9,11)));
        userLotteries.add(LottoPurchase.userLotteryFrom(Arrays.asList(2,4,6,8,10,12)));
        userLotteries.add(LottoPurchase.userLotteryFrom(Arrays.asList(13,15,17,19,21,23)));
        userLotteries.add(LottoPurchase.userLotteryFrom(Arrays.asList(14,16,18,20,22,24)));
    }
    @BeforeEach
    void init() {
        winningResult.put(Constants.LottoResult.TREE.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(Constants.LottoResult.FOUR.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(Constants.LottoResult.FIVE.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(Constants.LottoResult.FIVE_AND_BONUS.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(Constants.LottoResult.SIX.getCount(), Constants.INITIAL_VALUE);
    }

    @Test
    @DisplayName("로또 한장당 일치하는 번호 개수를 구하고 맵에 저장한다. (테스트에서는 3개의 번호가 일치하는 로또가 2개있다.)")
    void containsNumber() {
        winningResult = resultService.containsNumber(winningNumber, userLotteries, bonusNumber);
        assertEquals(winningResult.get(3),2);
    }
    @Test
    @DisplayName("5개의 번호 및 보너스번호가 일치하는지 확인하고 결과에 따른 값을 맵에 저장한다.")
    void containsBonusNumber() {
        // 보너스 번호 일치
        userLotteries.add(LottoPurchase.userLotteryFrom(Arrays.asList(1,2,3,4,5,7)));
        // 보너스 번호 불일치
        userLotteries.add(LottoPurchase.userLotteryFrom(Arrays.asList(1,2,3,4,5,8)));
        winningResult = resultService.containsNumber(winningNumber, userLotteries, bonusNumber);
        assertEquals(winningResult.get(7),1);
        assertEquals(winningResult.get(5),1);

    }
    @Test
    @DisplayName("통계값을 계산한다.")
    void calcWinningMoney() {
        winningResult = resultService.containsNumber(winningNumber, userLotteries, bonusNumber);
        long winningMoney = resultService.calculateWinningMoney(winningResult);
        assertEquals(winningMoney,10000);
    }
    @Test
    @DisplayName("수익률을 계산한다.")
    void statistics() {
        long winningMoney = 10000; // 당첨금을 10000원으로 가정
        int purchaseCount = 4;
        double statistics = resultService.statistics(winningMoney,purchaseCount);
        assertEquals(statistics,250.0); // 소수점 2째자리에서 반올림

    }
}