package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.Service.InputService;
import lotto.exception.LottoException;

import java.util.List;

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

    public List<Integer> chooseWinningNum() {
        String line;
        while (true) {
            line = Console.readLine();

            if (!lottoException.checkWinningNum(line)) break;
        }
        return inputService.getStringToList(line);
    }


    public Integer chooseBonusNum(List<Integer> winningNum) {
        String line;
        while (true) {
            line = Console.readLine();

            if (!lottoException.checkBonusNum(line, winningNum)) break;
        }
        return inputService.getBonusNum(line);
    }
}
