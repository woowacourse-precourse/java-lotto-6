package lotto.view;

import lotto.constant.Mark;
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
        List<String> elements = List.of(inputLine.split(Mark.DELIMITER.get()));
        List<Integer> winNumbers = new ArrayList<>();
        for (String element : elements) {
            winNumbers.add(Integer.parseInt(element));
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