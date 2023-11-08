package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import static lotto.io.LottoMessage.INPUT_PURCHASE_PRICE;

public class View implements InputView, OutputView {

    @Override
    public String readPurchasePrice() {
        printLottoMessage(INPUT_PURCHASE_PRICE);
        return Console.readLine();
    }

    @Override
    public void printLottoMessage(LottoMessage lottoMessage) {
        System.out.println(lottoMessage.getMessage());
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
