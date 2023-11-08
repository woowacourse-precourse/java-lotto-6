package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;

public class Parser {

    private Parser() {
    }

    public static int parsePurchaseAmount(String input) {
        validateInput(input);
        return Integer.parseInt(input);
    }

    public static Lotto parseLottoWiningNumbers(String input) {
        List<String> LottoWiningNumbers = Arrays.stream(input.split(ParserMessage.commas.getParserMessage()))
                .map(String::trim)
                .toList();
        LottoWiningNumbers.stream().forEach(Parser::validateInput);
        return new Lotto(LottoWiningNumbers.stream().map(Integer::parseInt).toList());
    }


    public static BonusNumber parseLottoBonusNumber(String input) {
        validateInput(input);
        return BonusNumber.create(Integer.parseInt(input));
    }

    private static void validateInput(String input) {
        if (validateBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getErrorMessage());
        }
        if (!validateNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }

    private static boolean validateNumber(String input) {
        Pattern numberPatterns = Pattern.compile("^[0-9]+$");
        return numberPatterns.matcher(input).matches();
    }

    private static boolean validateBlank(String input) {
        return Objects.equals(input, ParserMessage.BLANK.getParserMessage());
    }

    enum ParserMessage {
        commas(","),
        BLANK("");

        private final String parserMessage;

        ParserMessage(String parserMessage) {
            this.parserMessage = parserMessage;
        }

        private String getParserMessage() {
            return parserMessage;
        }
    }
}
