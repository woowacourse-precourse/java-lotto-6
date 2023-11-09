package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumMapTest {
    private EnumMap<Day, String> dayMap;

    @BeforeEach
    void setUp() {
        dayMap = new EnumMap<>(Day.class);
        dayMap.put(Day.MONDAY, "월요일");
        dayMap.put(Day.TUESDAY, "화요일");
        dayMap.put(Day.WEDNESDAY, "수요일");
    }

    @Test
    @DisplayName("EnumMap에 요소를 추가하고 크기를 확인")
    void addToEnumMapAndCheckSize() {
        assertThat(dayMap.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("EnumMap에 포함된 특정 요일의 값을 확인")
    void getSpecificDayValue() {
        assertThat(dayMap.get(Day.MONDAY)).isEqualTo("월요일");
        assertThat(dayMap.get(Day.TUESDAY)).isEqualTo("화요일");
    }

    @Test
    @DisplayName("EnumMap에서 존재하지 않는 키를 조회")
    void getNonExistingKey() {
        assertThat(dayMap.get(Day.SUNDAY)).isNull();
    }

    @Test
    @DisplayName("EnumMap의 모든 요소를 순회")
    void iterateOverEnumMap() {
        for (Map.Entry<Day, String> entry : dayMap.entrySet()) {
            assertThat(entry.getKey()).isNotNull();
            assertThat(entry.getValue()).isNotNull();
        }
    }

    @Test
    @DisplayName("EnumMap에 요소를 삭제")
    void removeFromEnumMap() {
        dayMap.remove(Day.MONDAY);
        assertThat(dayMap.containsKey(Day.MONDAY)).isFalse();
    }

    @Test
    @DisplayName("EnumMap의 모든 요소를 삭제하고 비어 있는지 확인")
    void clearEnumMapAndCheckIfEmpty() {
        dayMap.clear();
        assertThat(dayMap.isEmpty()).isTrue();
    }
}
