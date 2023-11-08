package utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilityTest {
    @DisplayName("입력받은 정수 리스트를 오름차순으로 정렬해준다.")
    @Test
    void sortAscending() {
        assertThat(Utility.sortAscending(List.of(6,5,10,9,7,8))).
                isEqualTo(List.of(5,6,7,8,9,10));
    }
    @DisplayName("입력받은 문자열을 콤마를 기준으로 분리하여 List 형태로 반환한다.")
    @Test
    void splitByComma() {
        assertThat(Utility.splitByComma("가,나,다,라,마,바")).
                isEqualTo(List.of("가","나","다","라","마","바"));
    }
}