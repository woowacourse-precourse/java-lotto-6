package lotto.view;

import lotto.constant.ErrorMessage;
import lotto.constant.Mark;
import lotto.domain.Lotto;
import lotto.io.InputStream;
import lotto.util.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    InputStream inputStream;

    public InputView(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public BigDecimal inputMoney() throws IllegalArgumentException {
        String moneyInput = inputStream.inputLine();
        if (Validator.isNumeric(moneyInput)) {
            BigDecimal money = new BigDecimal(moneyInput);
            Validator.checkPositive(money);
            Validator.checkThousandDivision(money);
            return money;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.get());
    }

    public List<Integer> inputWinNumbers() throws IllegalArgumentException {
        String inputLine = inputStream.inputLine();
        List<String> elements = List.of(inputLine.split(Mark.DELIMITER.get()));
        List<Integer> winNumbers = new ArrayList<>();
        for (String element : elements) {
            try {
                winNumbers.add(Integer.parseInt(element));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.get());
            }
        }
        Lotto.checkFormat(winNumbers);
        Validator.checkDelimiterCount(inputLine);
        return winNumbers;
    }

    public int inputBonusNumber() throws IllegalArgumentException {
        int number = inputStream.inputInt();
        return Lotto.checkRange(number);
    }
}