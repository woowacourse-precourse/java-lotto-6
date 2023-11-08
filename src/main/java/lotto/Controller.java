package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int validPurchasePrice = getValidPurchasePrice();
        int purchaseQuantity = gameManager.calculatePurchaseQuantity(validPurchasePrice);
        System.out.println();
        outputView.print(purchaseQuantity);
        List<Lotto> lottoTickets = lottoTicketGenerator.buy(purchaseQuantity);
        outputView.print(lottoTickets);
        System.out.println();

        String validWinningNumbers = getValidWinningNumbers();
        List<Integer> convertedNumbers = inputConverter.convertToListOfInteger(validWinningNumbers);

        System.out.println();
        int bonusNumber = getValidBonusNumber(convertedNumbers);
        System.out.println();
        gameManager.saveWinningNumbers(convertedNumbers, bonusNumber);
        gameManager.updatePrizeStatistic(lottoTickets);
        outputView.print(gameManager.getPrizeStatistics());
        outputView.print(gameManager.calculateEarningRate(validPurchasePrice));
    }

    private int getValidPurchasePrice() {
        while (true) {
            try {
                String input = inputView.askPurchasePrice();
                validateOnlyDigits(input);
                int purchasePrice = inputConverter.convertToInteger(input);
                validatePurchasePrice(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % 10 != 0 || purchasePrice < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_PURCHASE_PRICE_UNIT.message);
        }
        if (purchasePrice > 100000) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_PURCHASE_PRICE_RANGE.message);
        }
    }

    private String getValidWinningNumbers() {
        while (true) {
            String input = inputView.askWinningNumbers();
            try {
                validateWinningNumbers(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbers(String input) {
        final String SEPARATOR = ",";
        String[] splitInput = input.split(SEPARATOR);

        if (splitInput.length != LottoTicketGenerator.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_NUMBER_LENGTH.message);
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String digit : splitInput) {
            int number = Integer.parseInt(digit);
            if (number < LottoTicketGenerator.MINIMUM_NUMBER || number > LottoTicketGenerator.MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.message);
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_DUPLICATE_NUMBER.message);
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = inputView.askBonusNumber();
                int bonusNumber = inputConverter.convertToInteger(input);
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoTicketGenerator.MINIMUM_NUMBER || bonusNumber > LottoTicketGenerator.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_BONUS_NUMBER.message);
        }
    }

    private void validateOnlyDigits(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_CONTAIN_NOT_ONLY_NUMBER.message);
        }
    }
}
