package lotto.controller;

import java.util.List;
import lotto.domain.cash.Cash;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
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
        while(true) {
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
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e);
            }
        }
    }

    private void inputWinningLottoNumbers() {

        outputView.print(Messages.INPUT_WINNING_NUMBERS.getMessage());
        Lotto winningNumbers;
        while(true) {
            try {
                winningNumbers = new Lotto(inputView.inputNumbers());
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e);
            }
        }

        outputView.print(Messages.INPUT_BONUS_NUMBERS.getMessage());
        LottoNumber bonusNumber;
        while(true) {
            try {
                bonusNumber = new LottoNumber(inputView.inputNumber());
                winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e);
            }
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
