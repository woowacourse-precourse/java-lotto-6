package lotto.controller;

import java.util.List;
import lotto.domain.cash.Cash;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.domain.lotto.WinningLottoNumbers;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;
import lotto.domain.message.Messages;
import lotto.domain.message.Messenger;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;
import lotto.domain.win.WinStatesCounter;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.WinStateInformationDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
    private final LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(pickNumbersStrategy);

    private final LottoShop lottoShop = new LottoShop();

    private Cash purchaseCash;
    private WinningLottoNumbers winningLottoNumbers;
    private List<Lotto> lotteries;

    private final Messenger messenger = new Messenger();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotteries();
        inputWinningLottoNumbers();
        printResult();
    }

    private void purchaseLotteries() {
        outputView.print(Messages.INPUT_PURCHASE_CASH_AMOUNT.getMessage());
        try {
            purchaseCash = new Cash(inputView.inputNumber());
            int lotteriesCount = lottoShop.countPurchasableAmount(purchaseCash.amount());
            outputView.print(Messages.PURCHASED_LOTTERIES_FORMAT.getMessage(lotteriesCount));
            List<LottoNumbersDTO> lottoNumbersDTOs = lottoNumbersGenerator.generateByCount(lotteriesCount);
            lotteries = lottoNumbersDTOs.stream()
                    .map(LottoNumbersDTO::numbers)
                    .map(Lotto::new)
                    .toList();
            outputView.print(messenger.getLotteriesNumbersMessage(lottoNumbersDTOs));
        } catch (IllegalArgumentException e) {
            outputView.print(e);
            purchaseLotteries();
        }
    }

    private void inputWinningLottoNumbers() {
        winningLottoNumbers = new WinningLottoNumbers(inputWinningNumbers(), inputBonusNumber());
    }

    private List<Integer> inputWinningNumbers() {
        outputView.print(Messages.INPUT_WINNING_NUMBERS.getMessage());
        try {
            return inputView.inputNumbers();
        } catch (IllegalArgumentException e) {
            outputView.print(e);
            return inputWinningNumbers();
        }
    }

    private int inputBonusNumber() {
        outputView.print(Messages.INPUT_BONUS_NUMBERS.getMessage());
        try {
            return inputView.inputNumber();
        } catch (IllegalArgumentException e) {
            outputView.print(e);
            return inputBonusNumber();
        }
    }

    private void printResult() {
        WinStatesCounter winStatesCounter = new WinStatesCounter(winningLottoNumbers, lotteries);
        List<WinStateInformationDTO> winStateInformationDTOs = winStatesCounter.getWinStateInformationDTOs();
        outputView.print(Messages.WINNING_STATISTICS_START.getMessage());
        winStateInformationDTOs.forEach(dto -> outputView.print(Messages.WINNING_STATISTIC_INFORMATION_FORMAT.getMessage(
                dto.description(), dto.prize(), dto.winningCount()
        )));
        Prize prize = Prize.from(winStateInformationDTOs);
        double yield = prize.getYield(purchaseCash);
        outputView.print(Messages.YIELD_FORMAT.getMessage(yield));
    }

}
