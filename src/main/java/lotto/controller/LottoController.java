package lotto.controller;

import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.controller.constant.ErrorConst.INPUT_NOT_INT;
import static lotto.controller.constant.ErrorConst.INPUT_NOT_LONG;
import static lotto.ui.constant.MessageConst.PURCHASE_REQUEST;

public class LottoController {

    private final LottoService service = new LottoService();

    public void purchaseLotteries() {
        OutputView.printMessage(PURCHASE_REQUEST);
        String input = InputView.input();

        long price = makeLong(input);
        service.buyLotteries(price);
    }

    public void provideLotteriesDetails() {
        List<Lotto> lottoStorage = service.getLottoStorage();
        OutputView.printAmountNotice(lottoStorage.size());

        for (Lotto lotto : lottoStorage) {
            OutputView.printLotto(lotto.getNumbers());
        }
    }

    public Lotto setUPWinningMain() {
        String input = InputView.input();

        List<Integer> winningMain = makeIntegerList(input);
        return new Lotto(winningMain);
    }

    private long makeLong(String price) {
        try {
            return Long.parseLong(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_LONG, e);
        }
    }

    private List<Integer> makeIntegerList(String input) {
        try {
            String[] inputSplit = input.split(",");
            return Arrays.stream(inputSplit)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INT, e);
        }
    }

}
