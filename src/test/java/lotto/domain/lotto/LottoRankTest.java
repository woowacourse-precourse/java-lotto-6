package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

     @DisplayName("맞춘 개수의 해당하는 순위를 반환한다.")
     @TestFactory
     Collection<DynamicTest> getRank(){
        boolean isBonus = true;
        boolean anyBonus = false;
        // given
        return List.of(
                DynamicTest.dynamicTest("6개를 맞추면 순위는 1등이다.", () -> {
                    //when
                    LottoRank rank = LottoRank.getRank(6, anyBonus);
                    //then
                    assertEquals(rank, LottoRank.FIRST);

                }),
                DynamicTest.dynamicTest("5개를 맞추고 보너스도 맞춘다면 순위는 2등이다.", () -> {
                    //when
                    LottoRank rank = LottoRank.getRank(5, isBonus);
                    //then
                    assertEquals(rank, LottoRank.SECOND);
                }),
                DynamicTest.dynamicTest("5개를 맞추고 보너스는 맞추지 못하면 순위는 3등이다.", () -> {
                    //when
                    LottoRank rank = LottoRank.getRank(5, anyBonus);
                    //then
                    assertEquals(rank, LottoRank.THIRD);
                }),
                DynamicTest.dynamicTest("4개를 맞추면 순위는 4등이다.", () -> {
                    //when
                    LottoRank rank = LottoRank.getRank(4, anyBonus);
                    //then
                    assertEquals(rank, LottoRank.FOURTH);
                }),
                DynamicTest.dynamicTest("3개를 맞추면 순위는 5등이다.", () -> {
                    //when
                    LottoRank rank = LottoRank.getRank(3, anyBonus);
                    //then
                    assertEquals(rank, LottoRank.FIFTH);
                }),
                DynamicTest.dynamicTest("맞춘 개수가 3개 밑인 경우에 순위는 존재하지 않는다.", () -> {
                    //when
                    LottoRank rank = LottoRank.getRank(2, anyBonus);
                    //then
                    assertEquals(rank, LottoRank.NO_RANK);
                })
        );
    }
    @DisplayName("로또 당첨된 개수를 전달하면 각 등수의 총 금액을 반환받는다.")
     @TestFactory
     Collection<DynamicTest> calculate(){
        boolean isBonus = true;
        boolean anyBonus = false;
        // given
        return List.of(
                DynamicTest.dynamicTest("1등은 2,000,000,000원", () -> {
                    //when
                    long calculate = LottoRank.FIRST.calculatePrize(1);
                    //then
                    assertEquals(calculate, 2000000000);

                }),
                DynamicTest.dynamicTest("2등은 30,000,000원", () -> {
                    //when
                    long calculate = LottoRank.SECOND.calculatePrize(1);
                    //then
                    assertEquals(calculate, 30000000);
                }),
                DynamicTest.dynamicTest("3등은 1,500,000원", () -> {
                    //when
                    long calculate = LottoRank.THIRD.calculatePrize(1);
                    //then
                    assertEquals(calculate, 1500000);
                }),
                DynamicTest.dynamicTest("4등은 50,000원", () -> {
                    //when
                    long calculate = LottoRank.FOURTH.calculatePrize(1);
                    //then
                    assertEquals(calculate, 50000);
                }),
                DynamicTest.dynamicTest("5등은 5,000원.", () -> {
                    //when
                    long calculate = LottoRank.FIFTH.calculatePrize(1);
                    //then
                    assertEquals(calculate, 5000);
                }),
                DynamicTest.dynamicTest("순위가 존재하지 않으면 0원", () -> {
                    //when
                    long calculate = LottoRank.NO_RANK.calculatePrize(1);
                    //then
                    assertEquals(calculate, 0);
                })
        );
    }

}