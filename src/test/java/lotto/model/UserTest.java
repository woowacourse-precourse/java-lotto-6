package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("유저 입력 테스트")
class UserTest {
    static Stream<Arguments> generateDuplicateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), "6"),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), "7")
        );
    }

    @ParameterizedTest(name = "[{index}] 보너스 숫자 중복 예외 발생 : {0}, {1}")
    @MethodSource("generateDuplicateData")
    void 보너스_숫자_중복_예외_발생(List<Integer> list, String num) {
        // given
        User user = new User();
        Lotto lottoList = new Lotto(list);
        LottoNumber bonusNum = new LottoNumber(num);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validateDuplicate(lottoList, bonusNum));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.DUPLICATE_BONUS_NUM.getMessage());
    }


    // private 메서드 테스트 위해 복사
    private void validateDuplicate(Lotto winningNums, LottoNumber bonusNum) {
        if (winningNums.getNumbers().stream().anyMatch(e -> e.getNumber() == bonusNum.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUM.getMessage());
        }
    }
}