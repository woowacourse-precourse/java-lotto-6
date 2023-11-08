package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInformationTest {
    @Test
    @DisplayName("보너스 숫자가 당첨 번호에 포함되면 예외 처리한다.")
    void validateBonusNumberTest() {
        //Given
        List<LottoNumber> answerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .toList();
        LottoNumber bonusNumber = LottoNumber.of(6);

        //When & Then
        assertThatThrownBy(() -> new WinningInformation(new Lotto(answerLottoNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
    }
}
