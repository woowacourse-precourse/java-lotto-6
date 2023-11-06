package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.GetPurchaseUI;
import lotto.ui.GetWinningNumbersUI;
import lotto.ui.PrintLottoUI;

public class Application {
    private static Purchase getPurchaseAmount(GetPurchaseUI getPurchaseUI) {

        String input = getPurchaseUI.enterPurchaseAmountUI();

        return new Purchase(input);
    }

    private static Lotto getWinningNumbers(GetWinningNumbersUI winningNumbersUI) {
        String input = winningNumbersUI.enterWinningNumbersUI();
        String[] inputNumbers = input.split(",");

        List<Integer> numbers = new ArrayList<>();
        int number;

        for (String s : inputNumbers) {
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    private static Integer getBonusNumbers(GetWinningNumbersUI winningNumbersUI) {
        String input = winningNumbersUI.enterBonusNumberUI();
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(bonusNumber >= 1 && bonusNumber <= 45) {
            return bonusNumber;
        }

        throw new IllegalArgumentException();
    }

    private static void isValidBonusNumber(Lotto winningLotto, Integer bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getLotto();

        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

        GetPurchaseUI getPurchaseUI = new GetPurchaseUI();
        PrintLottoUI printLottoUI = new PrintLottoUI();
        GetWinningNumbersUI winningNumbersUI = new GetWinningNumbersUI();

        Purchase purchase;

        int lottoCount;

        List<Lotto> lottos = new ArrayList<>();

        Lotto winningLotto;
        int bonusNumber;

        while (true) {
            try {
                purchase = getPurchaseAmount(getPurchaseUI);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_PURCHASE_AMOUNT);
            }
        }

        lottoCount = purchase.getPurchaseAmount() / 1000;

        printLottoUI.printLottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            MakeLotto makeLotto = new MakeLotto();
            lottos.add(makeLotto.makeLotto());
            printLottoUI.printLotto(lottos.get(i).getLotto());
        }



        while (true) {
            try {
                winningLotto = getWinningNumbers(winningNumbersUI);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_LOTTO_NUMBERS);
            }
        }

        while (true) {
            try {
                bonusNumber = getBonusNumbers(winningNumbersUI);
                isValidBonusNumber(winningLotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Constants.ERROR_NOT_VALID_BONUS_NUMBER);
            }
        }
    }
}
