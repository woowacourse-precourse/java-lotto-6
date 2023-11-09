package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    @ParameterizedTest
    @CsvSource({
            "10, 1 2 3 4 5 6 10, true",
            "10, 1 2 3 4 5 6, false",
            "7, 8 9 10 11 12 13, false",
            "20, 15 16 17 18 19 20, true"
    })
    @DisplayName("BonusNumber는 주어진 숫자 목록에 포함된 경우에만 true를 반환해야 한다")
    void testBonusNumberContainedInList(int bonusNumberValue, String numbersList, boolean expectedResult) {
        // 입력 문자열을 Integer 리스트로 변환
        List<Integer> numbers = Arrays.stream(numbersList.split(" "))
                .map(Integer::parseInt).toList();
        BonusNumber bonusNumber = BonusNumber.from(bonusNumberValue);

        // 결과 검증
        assertEquals(expectedResult, bonusNumber.isContainedIn(numbers));
    }
}
