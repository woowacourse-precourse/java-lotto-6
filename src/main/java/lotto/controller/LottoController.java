package lotto.controller;

import static lotto.util.Validator.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static int amount;
    private static Lotto winningNumbers;

    public void startGame() {
        int quantity = getQuantity();
        OutputView.printNumberOfLottoPurchase(quantity);
        OutputView.printLottoList(purchaseLotto(quantity));
        setWinningNumbers();
    }

    private int getQuantity() {
        String quantity = getQuantityInput();
        amount = Integer.parseInt(quantity);
        return amount / 1000;
    }

    private String getQuantityInput() {
        return checkQuantity(InputView.inputAmount());
    }

    private String checkQuantity(String input) {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(input);
            return purchaseAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getQuantityInput();
        }
    }

    private List<Lotto> purchaseLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers();

        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = randomNumbers.generateRandomNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private void setWinningNumbers() {
        winningNumbers = getWinningNumbersInput();
    }

    private Lotto getWinningNumbersInput() {
        return checkWinningNumbers(InputView.inputWinningNumbers());
    }

    private Lotto checkWinningNumbers(String input) {
        try {
            List<Integer> numbers = transformInputNumber(input);
            Lotto lotto = new Lotto(numbers);
            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getWinningNumbersInput();
        }
    }

    public List<Integer> transformInputNumber(String input) {
        List<String> numbers = convertStringToList(input);
        validateNonNumericNumbers(numbers);
        return convertStringToInt(numbers);
    }
}
