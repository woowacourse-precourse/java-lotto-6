package lotto;

import lotto.domain.*;
import lotto.dto.AllLotteriesNumbersInfoDTO;
import lotto.domain.MultipleNumbersInputVO;
import lotto.domain.SingleNumberInputVO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private SingleNumberInputVO userNumber;
    private MultipleNumbersInputVO userNumbers;
    private GenerateLotteries generateLotteries;
    private PurchasePrice purchasePrice;
    private Lotto lotto;
    private BonusLotto bonusLotto;

    public void startGame() {
        inputPurchasePriceHandler();

        generateLotteriesHandler();

        inputWinningNumbersHandler();

        inputBonusNumberHandler();

        calculateLottoResultAndPrintHandler();
    }

    private void inputPurchasePriceHandler() {
        while (true) {
            try {
                String price = inputView.requestPurchasePrice();
                userNumber = new SingleNumberInputVO(price);
                purchasePrice = new PurchasePrice(userNumber.getParsingNumber());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void inputWinningNumbersHandler() {
        while (true) {
            try {
                String winningNumbers = inputView.requestWinningNumbers();
                userNumbers = new MultipleNumbersInputVO(winningNumbers);
                lotto = new Lotto(userNumbers.getParsingNumbers());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void inputBonusNumberHandler() {
        while (true) {
            try {
                String bonusNumber = inputView.requestBonusNumber();
                userNumber = new SingleNumberInputVO(bonusNumber);
                bonusLotto = new BonusLotto(userNumber.getParsingNumber(), lotto);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void generateLotteriesHandler() {
        generateLotteries = new GenerateLotteries(purchasePrice.getTotalLottoTickets());
        outputView.printPurchasedLotteries(generateLotteries.getLotteries());
    }

    private void calculateLottoResultAndPrintHandler() {
        AllLotteriesNumbersInfoDTO allLotteriesInfo = new AllLotteriesNumbersInfoDTO(lotto, bonusLotto, generateLotteries);
        LottoRank lottoRank = new LottoRank(allLotteriesInfo);
        double profitPercentage = lottoRank.calculateProfitPercentage(purchasePrice);

        outputView.printWinningStatistics(lottoRank.getRank());
        outputView.printProfitPercentage(profitPercentage);
    }
}
