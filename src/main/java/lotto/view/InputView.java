package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {

    final static Validator validator = new Validator();

    public static int validateInputAmount() {
        int amount;
        while (true) {
            try {
                String input = inputPurchaseAmount();
                if (!validator.checkAmount(input)) {
                    amount = Integer.parseInt(input);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    public static String[] validateInputNumbers() {
        String[] lottoNumbers;
        while (true) {
            try {
                String[] input = inputLottoNumber();
                if (!validator.checkNumbers(input)) {
                    lottoNumbers = input;
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumbers;
    }

    public static String validateInputBonusNumber() {
        String lottoNumber;
        while (true) {
            try {
                String input = inputBonusNumber();
                if (!validator.checkNumber(input)) {
                    lottoNumber = input;
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumber;
    }

    private static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    private static String[] inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumber = Console.readLine();
        return lottoNumber.split(",");
    }

    private static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
