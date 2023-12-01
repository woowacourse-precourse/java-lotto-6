package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionCode;
import lotto.utils.converter.Converter;

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
                ExceptionCode.NO_EXIST_ENTITY
        );
    }
}
