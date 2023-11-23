package lotto.domain.lotto.entity;

import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoResultCountTest {

    @Nested
    @DisplayName("학습 테스트 - EnumMap의 초기화 상태 확인")
    class 학습_테스트 {

        @Test
        @DisplayName("EnumMap을 생성하고 아무 값도 넣지 않으면 아무 것도 들어있지 않다.")
        void enumMap_초기_상태() {
            EnumMap<LottoResult, Integer> enumMap = new EnumMap<>(LottoResult.class);
            enumMap.entrySet()
                    .forEach(
                            entry -> {
                                System.out.println(entry.getKey() + ": " + entry.getValue());
                            }
                    );
        }
    }

}