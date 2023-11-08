package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {
    @DisplayName("랜덤 숫자 리스트 생성 시 크기 확인 테스트")
    @Test
    void 랜덤_숫자_리스트_생성_크기_확인_테스트() {
        int start = 1;
        int end = 45;
        int count = 6;

        assertThat(Util.createRandomNumberList(start, end, count))
                .hasSize(6);
    }

    @DisplayName("리스트 오름차순 정렬 테스트")
    @Test
    void 리스트_오름차순_정렬_테스트() {
        List<Integer> list = List.of(4, 2, 3, 1, 5);
        assertThat(Util.sortListAscending(list)).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @DisplayName("문자열 구분 테스트")
    @Test
    void 문자열_구분_테스트() {
        String input = "1,2,3,4,5";
        assertThat(Util.splitInputNumbers(input)).isEqualTo(List.of("1", "2", "3", "4", "5"));
    }

    @DisplayName("문자열 리스트 정수형 리스트로 변환 테스트")
    @Test
    void 문자열_리스트_정수형_리스트_변환_테스트() {
        List<String> list = List.of("1", "2", "3", "4");
        assertThat(Util.stringListToIntegerList(list)).isEqualTo(List.of(1, 2, 3, 4));
    }

    @DisplayName("문자열 숫자 정수형 변환 테스트")
    @Test
    void 문자열_숫자_정수형_변환_테스트() {
        String number = "1";
        assertThat(Util.stringToInt(number)).isEqualTo(1);
    }

    @DisplayName("리스트에 해당 숫자가 포함 되어 있는지 테스트")
    @Test
    void 숫자_리스트_포함_테스트() {
        int number = 1;
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        assertThat(Util.checkContainNumber(list, number)).isTrue();
    }

    @DisplayName("리스트끼리 겹치는 숫자 개수 구하기 테스트")
    @Test
    void 리스트_겹치는_숫자_개수_구하기_테스트() {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);
        assertThat(Util.countContainNumbers(list1, list2)).isEqualTo(3);
    }
}