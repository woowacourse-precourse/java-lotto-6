package lotto.utils;

import lotto.core.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    @DisplayName("NULL 검증")
    @Test
    void 검증_NULL() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateNullOrEmpty((String) null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자 리스트 길이 검증 - 6 미만")
    @Test
    void 검증_길이_6_미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateNumbersLength(List.of(1,2,3,4,5)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자 리스트 길이 검증 - 6 초과")
    @Test
    void 검증_길이_6_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateNumbersLength(List.of(1,2,3,4,5,6,7)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("구매 금액 범위 검증 : 1000미만")
    @Test
    void 구매_금액_범위_미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePriceRange("900"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자 검증 : 문자입력")
    @Test
    void 숫자_테스트_문자(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateIsNumber("aaa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자열 검증 : 문자 입력")
    @Test
    void 숫자열_테스트_문자(){
        String[] inputs = {"aa","bb","cc","dd","ee","ff"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateIsNumbers(inputs))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("번호 범위 : 단일")
    @Test
    void 번호_범위_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateIsNumberInRange(47))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("번호 범위 : 리스트")
    @Test
    void 번호_리스트_범위_테스트(){
        List<Integer> numbers = List.of(1,2,3,4,5,99);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateIsNumbersInRange(numbers))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("리스트 중복 테스트")
    @Test
    void 번호_리스트_중복_테스트(){
        List<Integer> numbers = List.of(1,2,3,4,4,6);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.hasDuplicateInNumbers(numbers))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("구매 금액 1000원 단위 테스트")
    @Test
    void 구매금액_단위_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validatePriceModIsZero("1900"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자열 오름차순 정렬 테스트")
    @Test
    void 오름차순_정렬_테스트(){
        List<Integer> numbers = List.of(21,6,12,4,1,2);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.validateAscending(numbers))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
