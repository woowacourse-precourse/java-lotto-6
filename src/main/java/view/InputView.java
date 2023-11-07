package view;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ERROR_PRIFIX = "[ERROR] ";

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("\n구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine().trim());
                if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException(ERROR_PRIFIX + "구입 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_PRIFIX + "숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String[] numbers = Console.readLine().split(",");
                List<Integer> winningNumbers = parseNumbers(numbers);
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e){
                System.out.println(ERROR_PRIFIX + "숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ERROR_PRIFIX + "보너스 번호는 1부터 45 사이의 값이어야 합니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_PRIFIX + "숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String[] numberStrings) throws NumberFormatException {
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }
        return numbers;
    }
}
