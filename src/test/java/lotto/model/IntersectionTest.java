package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

//    @DisplayName("당첨 번호 비고")
//    @Test
//    void winNum() {
//        Intersection intersection = new Intersection();
//        List<Integer> winNum = List.of(1,11,5,24,3,7);
//        List<Set> lottoNum = List.of(Set.of(1,11,5,24,3,8),Set.of(1,11,5,24,4,8));
//        List result = intersection.winNum(winNum, lottoNum);
//        assertThat(result).isEqualTo(List.of(5,4));
//    }

    @DisplayName("보너스 번호 비교")
    @Test
    void bonusNum() {
        Intersection intersection = new Intersection();
        List<Set> numbers = List.of(Set.of(1,11,5,24,3,7));
        List result = intersection.bonusNum(1,numbers);
        assertThat(result).isEqualTo(List.of(1));
    }
}