package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.utils.converter.Converter;
import lotto.view.constant.Notice;
import lotto.view.constant.Regex;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public int readPurchasePrice() {
        Notice.NOTICE_PURCHASE_PRICE.print();

        return Converter.toInt(
                Console.readLine(),
                ExceptionCode.INVALID_PURCHASE_PRICE
        );
    }

    public List<Integer> readLottoNumbers() {
        Notice.NOTICE_LOTTO_NUMBERS.print();

        String[] splitInput = Console.readLine()
                .split(Regex.COMMA.getRegex());

        return Arrays.stream(splitInput)
                .map(number -> Converter.toInt(
                        number,
                        ExceptionCode.INVALID_LOTTO_NUMBER)
                )
                .toList();
    }

    public int readBonusNumber() {
        Notice.NOTICE_BONUS_NUMBERS.print();

        return Converter.toInt(
                Console.readLine(),
                ExceptionCode.INVALID_BONUS_NUMBER
        );
    }
}
