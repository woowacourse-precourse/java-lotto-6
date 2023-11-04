package lotto.controller.dto.input;

import java.util.List;
import lotto.parser.StrictInputParser;
import lotto.validator.InputValidator;

/**
 * 로또 추첨을 위한 입력 데이터,
 * <p>
 * 당첨 번호 및 보너스 번호를 담은 Dto
 */
public final class DrawLottosDto {

    /**
     * 당첨 번호 6자리
     */
    private final List<Integer> lottoNumbers;

    /**
     * 보너스 번호
     */
    private final int bonusNumber;

    public DrawLottosDto(
            final List<Integer> lottoNumbers,
            final int bonusNumber
    ) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 2개의 입력을 받아서 로또 추첨을 위한 Dto로 변환합니다.
     */
    public static DrawLottosDto from(
            final String lottoNumbersInput,
            final String bonusNumberInput
    ) {
        final List<Integer> lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(
                lottoNumbersInput);
        final int bonusNumber = StrictInputParser.mustParseToInt(bonusNumberInput);
        return new DrawLottosDto(lottoNumbers, bonusNumber);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Dto 내의 데이터는 추후 다른 객체에 의해 사용되어야 하기 때문에 getter를 모두 열어 두었습니다.
     * <p>
     * 이후 Mapper에 의해 도메인 객체로 변환됩니다.
     */
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /**
     *
     */
    public static class Builder {
        private List<Integer> lottoNumbers;
        private int bonusNumber;

        private Builder() {
        }

        public Builder lottoNumbers(final String input) {
            InputValidator.validateCommasSeparatedInput(input);
            this.lottoNumbers = StrictInputParser.mustParseFromCommasSeparatedInputToIntList(input);
            return this;
        }

        public Builder bonusNumber(final String input) {
            InputValidator.validateNumericInput(input);
            this.bonusNumber = StrictInputParser.mustParseToInt(input);
            return this;
        }

        public DrawLottosDto build() {
            return new DrawLottosDto(lottoNumbers, bonusNumber);
        }
    }

}
