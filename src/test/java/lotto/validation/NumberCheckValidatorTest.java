package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.messages.ErrorMessages.*;
import static lotto.validation.NumberCheckValidator.*;
import static org.assertj.core.api.Assertions.*;

class NumberCheckValidatorTest {

    @Test
    @DisplayName(value = "정상처리")
    void 정상처리() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(lottoNumbers::add);
        validateLottoNumber(lottoNumbers); //실패할 경우 예외 발생
    }

    @Test
    @DisplayName("중복되는 수가 있을 경우 예외")
    void 중복_예외() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(lottoNumbers::add);
        lottoNumbers.add(5);

        assertThatThrownBy(() -> validateLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATION);
    }

    @Test
    @DisplayName("입력받은 로또번호 개수가 6 미만 6 초과")
    void 리스트_사이즈_예외() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 4).forEach(lottoNumbers::add);
        assertThatThrownBy(() -> validateLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_SIZE);

        lottoNumbers.add(5);
        lottoNumbers.add(6);
        lottoNumbers.add(7);

        assertThatThrownBy(() -> validateLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_SIZE);
    }

    @Test
    @DisplayName("입력받은 로또번호가 1미만 45 초과")
    void 범위_초과_예외() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(lottoNumbers::add);
        lottoNumbers.add(0);

        assertThatThrownBy(() -> validateLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE);

        lottoNumbers.remove(5);
        lottoNumbers.add(46);

        assertThatThrownBy(() -> validateLottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE);
    }

    @Test
    @DisplayName("보너스 번호 정상 처리")
    void 보너스_정상_처리() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(lottoNumbers::add);

        int bonusNum = 7;

        validateBonusNumber(lottoNumbers, bonusNum); // 실패할 경우 예외 발생
    }

    @Test
    @DisplayName("보너스 번호가 로또번호와 중복 예외")
    void 보너스_중복_예외() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(lottoNumbers::add);

        int bonusNum = 6;

        assertThatThrownBy(() -> validateBonusNumber(lottoNumbers, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATION_WITH_WINNING_NUMBER);
    }

    @Test
    @DisplayName("보너스 번호가 1미만 45 초과 예외")
    void 보너스_범위_초과_예외() {
        List<Integer> lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(lottoNumbers::add);

        int bonusNum1 = 46;

        assertThatThrownBy(() -> validateBonusNumber(lottoNumbers, bonusNum1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_RANGE);


        int bonusNum2 = 0;

        assertThatThrownBy(() -> validateBonusNumber(lottoNumbers, bonusNum2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_RANGE);
    }
}