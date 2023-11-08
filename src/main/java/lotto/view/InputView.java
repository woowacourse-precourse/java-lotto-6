package lotto.view;

import lotto.constant.Format;
import lotto.domain.Lotto;
import lotto.io.InputStream;
import lotto.util.Validator;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    InputStream inputStream;

    public InputView(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int inputMoney() throws IllegalArgumentException {
        int money = inputStream.inputInt();
        Validator.checkPositive(money);
        Validator.checkThousandDivision(money);
        return money;
    }

    public List<Integer> inputWinNumbers() throws IllegalArgumentException {
        String inputLine = inputStream.inputLine();
        List<String> elements = List.of(inputLine.split(Format.DELIMITER.get()));
        List<Integer> winNumbers = new ArrayList<>();
        for (String element : elements) {
            int number = Lotto.checkRange(Integer.parseInt(element));
            Validator.checkDuplicated(winNumbers, number);
            winNumbers.add(number);
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