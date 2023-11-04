package lotto;

import static lotto.constant.LottoInformation.DELIMITER;
import static lotto.constant.message.ErrorMessage.NOT_ONLY_DIGIT;
import static lotto.constant.message.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.message.InputMessage.INPUT_MONEY;
import static lotto.constant.message.InputMessage.INPUT_WINNING_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Customer;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoSeller;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    Customer customer = new Customer();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    WinningNumbers winningNumbers = new WinningNumbers();

    public void purchaseLotto() {
        try {
            String input = inputView.requestInputValue(INPUT_MONEY);
            int purchaseAmount = convertInteger(input);
            customer.scanPocket(purchaseAmount);

            LottoSeller seller = new LottoSeller();
            seller.checkRemainder(customer.getMoney());

            outputView.printLottoCount(seller.getSellCount());
            customer.setLotteryTicket(seller.makeLottoTickets());
            outputView.printLottoNumbers(customer.getLotteryTicket());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }
    }

    public void generateWinningNumbers() {
        try {
            String input = inputView.requestInputValue(INPUT_WINNING_NUMBER);
            List<Integer> numbers = convertIntegerList(input);
            winningNumbers.makeWinningNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateWinningNumbers();
        }
    }

    public void generateBonusNumber() {
        try {
            String inputValue = inputView.requestInputValue(INPUT_BONUS_NUMBER);
            int bonusNumber = convertInteger(inputValue);
            winningNumbers.makeBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateBonusNumber();
        }
    }

    public void revealLottoResults() {
        outputView.printResultMessage();
        LottoCalculator calculator = new LottoCalculator(winningNumbers);
        calculator.makePrizeResult(customer.getLotteryTicket());
        outputView.printPrizeResult(calculator.getResult());
        String profitRate = calculator.calculateProfitRate(customer.getMoney());
        System.out.println(profitRate);
    }

    private int convertInteger(String input) {
        validateOnlyDigit(input);
        return Integer.parseInt(input);
    }

    private List<Integer> convertIntegerList(String input) {
        String[] numbers = validateListOnlyDigit(input);

        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private String[] validateListOnlyDigit(String input) {
        String[] numbers = input.split(DELIMITER, -1);

        for (String number : numbers) {
            validateOnlyDigit(number);
        }
        return numbers;
    }

    private void validateOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isEmpty()) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT.getMessage());
        }
    }

}
