package lotto.controller.dto.input.builder;

import java.util.List;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.parser.StrictInputParser;
import lotto.validator.InputValidator;

public final class DrawLottosDtoBuilder {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    private DrawLottosDtoBuilder() {
    }

    public static DrawLottosDtoBuilder builder() {
        return new DrawLottosDtoBuilder();
    }

    public static void main(String[] args) {
        final DrawLottosDto dto = DrawLottosDtoBuilder.builder()
                .lottoNumbers("1,2,3,4,5,6")
                .bonusNumber("7")
                .build();
    }

    public DrawLottosDtoBuilder lottoNumbers(final String input) {
        InputValidator.validateCommasSeparatedInput(input);
        this.lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(input);
        return this;
    }

    public DrawLottosDtoBuilder bonusNumber(final String input) {
        InputValidator.validateNumericInput(input);
        this.bonusNumber = StrictInputParser.mustParseToInt(input);
        return this;
    }

    public DrawLottosDto build() {
        return new DrawLottosDto(lottoNumbers, bonusNumber);
    }
}