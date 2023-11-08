package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.InvestmentMoneyDto;
import lotto.dto.request.WinningLottoNumbersDto;
import lotto.view.printer.ConsolePrinter;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

class InputViewTest {
    private static final Printer PRINTER = new ConsolePrinter();

    private Reader reader;
    private InputView inputView;

    @ParameterizedTest
    @ValueSource(strings = {"0", "999", "1000", "1001"})
    void 사용자의_로또_구매_입력을_뷰를_통해서_받을때는_숫자_형태의_문자만_입력받을수_있다() {
        reader = () -> "1000";
        inputView = InputView.of(reader, PRINTER);

        InvestmentMoneyDto result = inputView.readInvestmentMoney();

        assertNotNull(result);
        assertThat(result.getInvestmentMoney())
                .isEqualTo(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "one"})
    void 사용자의_로또_구매_입력을_뷰를_통해서_받을때는_공백과_숫자_형태가_아닌_문자라면_예외가_발생한다(String input) {
        reader = () -> input;
        inputView = InputView.of(reader, PRINTER);

        assertThatThrownBy(inputView::readInvestmentMoney)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.0", "1,000"})
    void 사용자의_로또_구매_입력을_뷰를_통해서_받을때는_소수점과_천단위_구분자가_있는_문자라면_예외가_발생한다(String input) {
        reader = () -> input;
        inputView = InputView.of(reader, PRINTER);

        assertThatThrownBy(inputView::readInvestmentMoney)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_당첨_번호_입력을_뷰를_통해서_받을때는_숫자_형태의_문자와_구분자를_통해서_입력_받을수_있다() {
        reader = () -> "1,2,3,4,5,6";
        inputView = InputView.of(reader, PRINTER);

        WinningLottoNumbersDto winningLottoNumbersDto = inputView.readWinningLottoNumbers();

        assertThat(winningLottoNumbersDto.getWinningLottoNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "one,two,three,four,five,six"})
    void 사용자의_당첨_번호_입력을_뷰를_통해서_받을때는_공백과_숫자_형태가_아닌_문자라면_예외가_발생한다(String input) {
        reader = () -> input;
        inputView = InputView.of(reader, PRINTER);

        assertThatThrownBy(inputView::readWinningLottoNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_당첨_번호_입력을_뷰를_통해서_받을때는_구분자가_없는_문자라면_예외가_발생한다() {
        reader = () -> "1 2 3 4 5 6";
        inputView = InputView.of(reader, PRINTER);

        assertThatThrownBy(inputView::readWinningLottoNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_보너스_번호_입력을_뷰를_통해서_받을때는_숫자_형태의_문자만_입력받을수_있다() {
        reader = () -> "7";
        inputView = InputView.of(reader, PRINTER);

        BonusNumberDto bonusNumberDto = inputView.readBonusNumber();

        assertThat(bonusNumberDto.getBonusNumber())
                .isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "one"})
    void 사용자의_보너스_번호_입력을_뷰를_통해서_받을때는_공백과_숫자_형태가_아닌_문자라면_예외가_발생한다(String input) {
        reader = () -> input;
        inputView = InputView.of(reader, PRINTER);

        assertThatThrownBy(inputView::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자의_보너스_번호_입력을_뷰를_통해서_받을때는_구분자를_통해서_여러개의_숫자를_입력받으면_예외_발생한다() {
        reader = () -> "7,8";
        inputView = InputView.of(reader, PRINTER);

        assertThatThrownBy(inputView::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
