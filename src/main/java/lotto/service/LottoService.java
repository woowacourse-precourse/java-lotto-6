package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.InputValidation;
import lotto.model.Lotto;
import lotto.model.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static final int DIVIDED_AMOUNT = 1000;
    private int lottoCount;
    private ArrayList<Lotto> lottos;
    private int payment;
    private Lotto winningNumbers;
    private int bonusNumber;

    public int getPayment() {
        return payment;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void createLottoCount() {
        while (true) {
            try {
                lottoCount = checkLottoCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkLottoCount() {
        payment = checkPurchaseAmount();
        return calculateLottoCount(payment);
    }

    public int checkPurchaseAmount() {
        String amount = InputView.purchaseAmount();
        return checkNumber(amount);
    }

    public int checkNumber(String amount) {
        InputValidation.validateNumber(amount);
        return Integer.parseInt(amount);
    }

    public int calculateLottoCount(int validAmount) {
        InputValidation.validatePurchaseAmount(validAmount);
        return validAmount / DIVIDED_AMOUNT;
    }

    public void play() {
        OutputView.printLottoCount(lottoCount);
        createLottos();
    }

    public void createLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumber.make()));
        }
        printLottoNumbers();
    }

    public void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void createWinningNumbers() {
        while (true) {
            try {
                String input = InputView.winningNumber();
                List<Integer> numbers = parseInput(input);
                setWinningNumbers(new Lotto(numbers));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            String trimmedPart = part.trim(); // 앞뒤 공백 제거
            int validPart = checkNumber(trimmedPart);
            InputValidation.validateNumberInRange(validPart);
            numbers.add(validPart);
        }
        return numbers;
    }

    public void createBonusNumber() {
        while (true) {
            try {
                String input = InputView.bonusNumber();
                int validPart = checkNumber(input);
                setBonusNumber(validPart);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
