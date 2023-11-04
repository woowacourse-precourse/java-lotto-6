package lotto.controller.dto.input.builder;

import java.util.List;
import lotto.controller.dto.input.DrawLottosDto;
import lotto.domain.lotto.validator.LottoValidator;
import lotto.parser.StrictInputParser;

public final class DrawLottosDtoBuilder {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    private DrawLottosDtoBuilder() {
    }

    public static DrawLottosDtoBuilder builder() {
        return new DrawLottosDtoBuilder();
    }

    public DrawLottosDtoBuilder lottoNumbers(final String input) {
        final List<Integer> lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(input);
        LottoValidator.validateLottoLength(lottoNumbers);
        LottoValidator.validateDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        return this;
    }

    public DrawLottosDtoBuilder bonusNumber(final String input) {
        final int bonusNumber = StrictInputParser.mustParseToInt(input);
        LottoValidator.validateDuplicationWithBonusNumber(lottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        return this;
    }

    public DrawLottosDto build() {
        return new DrawLottosDto(lottoNumbers, bonusNumber);
    }
}