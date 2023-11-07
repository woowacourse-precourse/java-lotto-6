package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import view.InputView;
import view.OutputView;

public class Play {
    private final InputView input = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printPurchase();
        String purchaseInput = input.getInput();
        Purchase purchase = new Purchase(purchaseInput);
        outputView.printPurchaseAmount(purchase.getPurchaseAmount());
        outputView.printPurchaseLotto(purchase);

        outputView.printEnterWinning();
        List<Integer> numbers = parseNumbers(input.getInput());
        outputView.printEnterBonus();
        int bonusNumber = Integer.parseInt(input.getInput());
        Winning winning = new Winning(numbers, bonusNumber);
    }

    public List<Integer> parseNumbers(String input) {
        validateBlank(input);
        return Stream.of(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void validateBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 ,(쉼표)로 구분하며며, 공백을 포함할 수 없습니다.");
        }
    }
}
