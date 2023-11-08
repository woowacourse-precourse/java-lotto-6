package lotto;

import java.util.List;

public class Controller {
    GameManager gameManager;
    LottoTicketGenerator lottoTicketGenerator;
    InputConverter inputConverter;
    InputView inputView;
    OutputView outputView;

    public Controller() {
        this.gameManager = new GameManager();
        this.lottoTicketGenerator = new LottoTicketGenerator();
        this.inputConverter = new InputConverter();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int purchasePrice = getValidPurchasePrice();

        int purchaseQuantity = gameManager.calculatePurchaseQuantity(purchasePrice);
        System.out.println();
        outputView.print(purchaseQuantity);
        List<Lotto> lottoTickets = lottoTicketGenerator.buy(purchaseQuantity);
        outputView.print(lottoTickets);
        System.out.println();
        List<Integer> winningNumbers = inputConverter.convertToListOfInteger(inputView.askWinningNumbers());
        System.out.println();
        int bonusNumber = inputConverter.convertToInteger(inputView.askBonusNumber());
        System.out.println();
        gameManager.saveWinningNumbers(winningNumbers, bonusNumber);
        gameManager.updatePrizeStatistic(lottoTickets);
        outputView.print(gameManager.getPrizeStatistics());
        outputView.print(gameManager.calculateEarningRate(purchasePrice));
    }

    private int getValidPurchasePrice() {
        while (true) {
            try {
                String input = inputView.askPurchasePrice();
                validateOnlyNumber(input);
                int purchasePrice = inputConverter.convertToInteger(input);
                validatePurchasePrice(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_PURCHASE_PRICE_UNIT.message);
        }
        if (purchasePrice > 100000) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_PURCHASE_PRICE_RANGE.message);
        }
    }

    private void validateOnlyNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_CONTAIN_NOT_ONLY_NUMBER.message);
        }
    }
}
