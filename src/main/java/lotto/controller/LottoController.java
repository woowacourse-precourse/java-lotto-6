package lotto.controller;

import lotto.constant.Message;
import lotto.constant.Value;
import lotto.constant.WinType;
import lotto.domain.LottoSeller;
import lotto.domain.MatchCounter;
import lotto.domain.User;
import lotto.domain.WinCounter;
import lotto.domain.Lotto;
import lotto.dto.MatchCountDto;
import lotto.io.InputStream;
import lotto.io.OutputStream;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    private final int ZERO = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private final User user;
    private final LottoSeller seller;
    private MatchCounter matchCounter;
    private WinCounter winCounter;

    public LottoController(InputStream inputStream, OutputStream outputStream) {
        this.inputView = new InputView(inputStream);
        this.outputView = new OutputView(outputStream);
        this.user = User.createByBudget(ZERO);
        this.seller = LottoSeller.create();
    }

    public void inputMoney() {
        while (true) {
            try {
                outputView.printMoneyInputMessage();
                int money = inputView.inputMoney();
                user.setBudget(money);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
        outputView.printEmptyLine();
    }

    public void buyLottos() {
        int money = user.pay();
        List<Lotto> lottos = seller.sellLottos(money);
        user.setLottos(lottos);
        outputView.printBuyMessage(lottos.size());
        lottos.forEach(lotto -> outputView.print(lotto.toString()));
        outputView.printEmptyLine();
    }

    public void inputWinNumbers() {
        while (true) {
            try {
                outputView.printWinNumbersInputMessage();
                List<Integer> winNumbers = inputView.inputWinNumbers();
                matchCounter = MatchCounter.from(winNumbers);
                outputView.printEmptyLine();
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberInputMessage();
                int bonusNumber = inputView.inputBonusNumber();
                this.matchCounter.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
        outputView.printEmptyLine();
    }

    public void getWinStatistics() {
        outputView.printStatisticsMessage();
        winCounter = new WinCounter();
        for (MatchCountDto counting : matchCounter.getMatchCounts(user.getLottos())) {
            try {
                WinType winType = WinType.get(counting.match(), counting.bonus());
                int count = winCounter.getCount(winType);
                winCounter.put(winType, count + Value.ONE.get());
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        outputView.print(winCounter.toString());
    }

    public void getRateOfReturn() {
        String rateOfReturn = winCounter.getRateOfReturn(user.getPayed());
        outputView.print(Message.RATE_OF_RETURN_START.get() + rateOfReturn + Message.RATE_OF_RETURN_END.get());
    }
}