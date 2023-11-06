package lotto.controller;

import lotto.domain.constant.Rank;
import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.controller.constant.ErrorConst.INPUT_NOT_INT;
import static lotto.controller.constant.ErrorConst.INPUT_NOT_LONG;
import static lotto.ui.constant.MessageConst.PURCHASE_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_BONUS_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_DETAILS_NOTICE;
import static lotto.ui.constant.MessageConst.WINNING_MAIN_REQUEST;

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

    public void setUpWinning() {
        Lotto main = setUPWinningMain();
        Bonus bonus = setUPWinningBonus();

        service.generateWinning(main, bonus);
    }

    public void provideWinningDetails() {
        OutputView.printMessage(WINNING_DETAILS_NOTICE);

        service.rank();

        Map<Rank, Integer> winningDetails = service.getWinningDetails();
        for (Map.Entry<Rank, Integer> entry : winningDetails.entrySet()) {
            String description = entry.getKey().getDescription();
            Integer count = entry.getValue();

            OutputView.printWinningDetail(description, count);
        }
    }

    public void provideRateOfReturn() {
        double rateOfReturn = service.calculateReturn();

        OutputView.printRateOfReturn(rateOfReturn);
    }

    private Lotto setUPWinningMain() {
        OutputView.printMessage(WINNING_MAIN_REQUEST);
        String input = InputView.input();

        List<Integer> winningMain = makeIntegerList(input);
        return new Lotto(winningMain);
    }

    private Bonus setUPWinningBonus() {
        OutputView.printMessage(WINNING_BONUS_REQUEST);
        String input = InputView.input();

        int winningBonus = makeInt(input);
        return new Bonus(winningBonus);
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

    private int makeInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INT, e);
        }
    }

}
