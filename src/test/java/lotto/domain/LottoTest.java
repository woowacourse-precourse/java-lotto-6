package lotto.domain;

import lotto.fixture.NumberFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("[Domain Layer] Lotto")
class LottoTest {

    @Nested
    @DisplayName("[from] 정적 팩토리 메소드 / 생성자 테스트")
    class constructor_new {

        /**
         * Lotto 객체 생성자 예외처리
         * 1. 리스트 숫자의 갯수가 제약조건(Default : 6)과 일치하지 않는 요청
         * 2. 리스트 숫자의 각 요소가 제약조건(Default 1 ~ 45)를 만족하지 않는 요청
         * 3. 리스트 숫자에 중복된 요소가 포함되는 경우
         */

        @Test
        @DisplayName("[Success] 정상적인 로또 숫자 인자로 객체 생성 성공")
        void Should_Success_When_Valid_Parameter() {
            // given
            NumberFixture valid = NumberFixture.VALID;
            // when && then
            Assertions.assertDoesNotThrow(valid::toEntity);
        }
    }
}
