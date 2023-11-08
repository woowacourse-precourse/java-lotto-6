package lotto;

import java.util.ArrayList;
import java.util.List;

public class Ask {
    public static int askPurchaseNumber() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                double purchaseAmount = Double.parseDouble(camp.nextstep.edu.missionutils.Console.readLine());
                return (int) isDivisibleByOneThousand(purchaseAmount); // 구매 금액이 1,000으로 나누어지는지 확인 후 정수로 바꾸어 리턴
            } catch (NullPointerException e) {
                System.err.println("[ERROR] 구매금액을 입력하셔야 합니다.\n");
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 구매금액은 숫자형식이어야 합니다.\n");
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 구매금액은 1,000원 단위로 입력하셔야 합니다.\n");
            }
        }
    }

    public static int askBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
                checkValidBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (NullPointerException e) {
                System.err.println("[ERROR] 보너스 번호를 입력하셔야 합니다.\n");
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 보너스 번호는 숫자형식이어야 합니다.\n");
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public static Lotto askWiningNumber() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                return new Lotto(parseNumberList(camp.nextstep.edu.missionutils.Console.readLine()));
            } catch (NullPointerException e) {
                System.err.println("[ERROR] 당첨번호를 입력하셔야 합니다.\n");
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 당첨번호들은 공백없이 쉼표로 구분된 숫자들의 형식이어야 합니다.\n");
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public static double isDivisibleByOneThousand(double number) {
        if (number < Application.ONE_LOTTO_PRICE)
            throw new IllegalArgumentException();// 예외처리: 1,000원보다 작은 경우
        if (number % Application.ONE_LOTTO_PRICE != 0)
            throw new IllegalArgumentException(); // 예외처리: 1,000으로 나누어떨어지지 않는 경우
        return number / Application.ONE_LOTTO_PRICE;
    }

    // 입력값을 숫자리스트로 만드는 메서드
    public static List<Integer> parseNumberList(String input) throws NumberFormatException {
        List<Integer> numberList = new ArrayList<>();

        String[] numberStrings = input.split(",");
        for (String numStr : numberStrings) {
            int number = Integer.parseInt(numStr);
            numberList.add(number);
        }
        return numberList;
    }

    public static void checkValidBonusNumber(Lotto winningNumbers, int bonusNumber) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            System.err.println("[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
