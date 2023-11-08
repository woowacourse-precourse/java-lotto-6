package Model;

import Controller.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Model.LottoProcess.getPoint;
import static Model.LottoProcess.intersaction;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoProcessTest {
    @DisplayName("교집합이 있으면 결과를 반환한다.")
    @Test
    void checkIntersaction() {
        List<Integer> actualValue=intersaction(List.of(1, 2, 3, 4, 5, 5),List.of(1,2,7,8,9,10));
        List<Integer> expected= List.of(1,2);
        assertEquals(expected,actualValue);
    }

    @DisplayName("교집합이 없어도 진행해 결과를 반환한다.")
    @Test
    void checkNullIntersaction() {
        List<Integer> actualValue=intersaction(List.of(1, 2, 3, 4, 5, 5),List.of(11,12,17,18,19,10));
        List<Integer> expected= List.of();
        assertEquals(expected,actualValue);
    }
    @DisplayName("6개가 중복되면 points.get(4)가 1증가한다.")
    @Test
    void check6matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1, 2, 3, 4, 5, 6),List.of(1,2,3,4,5,6),8);
        List<Integer> expected= List.of(0,0,0,0,1);
        assertEquals(expected,actualValue);
    }
    @DisplayName("5개가 중복, 보너스 포함 되면 points.get(3)가 1증가한다.")
    @Test
    void check5_includeBonus_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1, 2, 3, 4, 5),List.of(1,2,3,4,5,8),8);
        List<Integer> expected= List.of(0,0,0,1,0);
        assertEquals(expected,actualValue);
    }
    @DisplayName("5개가 중복, 보너스 제외 되면 points.get(2)가 1증가한다.")
    @Test
    void check5_exceptBonus_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1, 2, 3, 4, 5),List.of(1,2,3,4,5,8),10);
        List<Integer> expected= List.of(0,0,1,0,0);
        assertEquals(expected,actualValue);
    }
    @DisplayName("4개가 중복 이면 points.get(1)가 1증가한다.")
    @Test
    void check4_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1, 2, 3, 4),List.of(1,2,3,4,5,8),10);
        List<Integer> expected= List.of(0,1,0,0,0);
        assertEquals(expected,actualValue);
    }
    @DisplayName("3개가 중복 이면 points.get(0)가 1증가한다.")
    @Test
    void check3_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1, 2, 3),List.of(1,2,3,4,5,8),10);
        List<Integer> expected= List.of(1,0,0,0,0);
        assertEquals(expected,actualValue);
    }
    @DisplayName("중복이 2개이면 point가 증가하지 않는다.")
    @Test
    void checkUnder3_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1, 2),List.of(1,2,3,4,5,8),10);
        List<Integer> expected= List.of(0,0,0,0,0);
        assertEquals(expected,actualValue);
    }
    @DisplayName("중복이 1개이면 point가 증가하지 않는다.")
    @Test
    void check1_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(1),List.of(1,2,3,4,5,8),10);
        List<Integer> expected= List.of(0,0,0,0,0);
        assertEquals(expected,actualValue);
    }
    @DisplayName("중복이 0개이면 point가 증가하지 않는다.")
    @Test
    void check0_matchTest() {
        LottoProcess.points.set(4,0);
        LottoProcess.points.set(3,0);
        LottoProcess.points.set(2,0);
        LottoProcess.points.set(1,0);
        LottoProcess.points.set(0,0);
        List<Integer> actualValue=getPoint(List.of(),List.of(1,2,3,4,5,8),10);
        List<Integer> expected= List.of(0,0,0,0,0);
        assertEquals(expected,actualValue);
    }
}