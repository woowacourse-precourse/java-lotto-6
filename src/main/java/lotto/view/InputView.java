package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.Service.InputService;
import lotto.exception.LottoException;

public class InputView {

    private final LottoException lottoException = new LottoException();
    private final InputService inputService = new InputService();


    public Integer purchaseLottoAmount() {
        String line;
        while (true) {
            line = Console.readLine();

            if (!lottoException.checkLottoAmount(line)) break;
        }
        return inputService.getStringPriceToInt(line);
    }
}
