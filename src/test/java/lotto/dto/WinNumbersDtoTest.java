package lotto.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinNumbersDtoTest {

    private static final String ERROR_CODE = "[ERROR]";
    private static final int START_INCLUSIVE_LOTTO_NUMBER = 1;
    private static final int END_INCLUSIVE_LOTTO_NUMBER = 45;


    @Test
    void WinNumbersDto는_당첨번호와_보너스번호를_포함한다() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinNumbersDto winNumbersDto = new WinNumbersDto(winNumbers, bonusNumber);

        assertThat(winNumbersDto.winNumbers())
                .isEqualTo(winNumbers);
        assertThat(winNumbersDto.bonusNumber())
                .isEqualTo(bonusNumber);
    }

    @Test
    void winNumbersDto의_당첨번호도_로또번호_자릿수만큼의_숫자를_입력하지않으면_IllegalArgumentException_발생() {
        List<Integer> tooManyWinNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;
        assertThatThrownBy(() -> new WinNumbersDto(tooManyWinNumbers, bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(tooManyWinNumbers, bonusNumber))
                .hasMessageContaining(ERROR_CODE);

        List<Integer> tooLittleWinNumbers = Arrays.asList(1, 2, 3);
        assertThatThrownBy(() -> new WinNumbersDto(tooLittleWinNumbers, bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(tooLittleWinNumbers, bonusNumber))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    void winNumbersDto의_당첨번호도_로또번호와_같이_중복된_숫자를_허용하지_않는다() {
        List<Integer> duplicatedWinNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new WinNumbersDto(duplicatedWinNumbers, 7))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(duplicatedWinNumbers, 7))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    void winNumbersDto의_당첨번호도_정해진_범위_외의_숫자를_입력하면_IllegalArgumentException_발생() {
        List<Integer> tooSmallNumberContain = List.of(START_INCLUSIVE_LOTTO_NUMBER - 1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertThatThrownBy(() -> new WinNumbersDto(tooSmallNumberContain, bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(tooSmallNumberContain, bonusNumber))
                .hasMessageContaining(ERROR_CODE);

        List<Integer> tooBigNumberContain = List.of(1, 2, 3, 4, 5, END_INCLUSIVE_LOTTO_NUMBER + 1);
        assertThatThrownBy(() -> new WinNumbersDto(tooBigNumberContain, bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(tooBigNumberContain, bonusNumber))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    void bonusNumber도_정해진_범위_외의_숫자를_입력하면_IllegalArgumentException_발생() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int tooSmallBonusNumber = START_INCLUSIVE_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> new WinNumbersDto(winNumbers, tooSmallBonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(winNumbers, tooSmallBonusNumber))
                .hasMessageContaining(ERROR_CODE);

        int tooBigBonusNumber = END_INCLUSIVE_LOTTO_NUMBER + 1;
        assertThatThrownBy(() -> new WinNumbersDto(winNumbers, tooBigBonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(winNumbers, tooBigBonusNumber))
                .hasMessageContaining(ERROR_CODE);
    }

    @Test
    void bonusNumber도_당첨번호와_중복되면_IllegalArgumentException_발생() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicatedBonusNumber = 1;
        assertThatThrownBy(() -> new WinNumbersDto(winNumbers, duplicatedBonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbersDto(winNumbers, duplicatedBonusNumber))
                .hasMessageContaining(ERROR_CODE);
    }
}