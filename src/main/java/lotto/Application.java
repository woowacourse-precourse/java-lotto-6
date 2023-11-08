package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = 0;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String inputAmount = Console.readLine();

            if (isValidInput(inputAmount)) {
                purchaseAmount = Integer.parseInt(inputAmount) / 1000;
                break;
            }
        }
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            lottoList.add(lotto);
            System.out.println(randomNumbers);
        }
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputWinningNumber = Console.readLine();
            String[] numberString = inputWinningNumber.split(",");
            if (numberString.length != 6) {
                System.err.println("[ERROR] 6개의 번호를 입력해주세요.");
                continue;
            }
            if (isVaileNumbers(numberString, winningNumbers)) {
                break;
            }

            System.out.println(winningNumbers);
            winningNumbers.clear();
            System.out.println(winningNumbers);
        }

        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String inputBonusNumber = Console.readLine();
            if(isVaildBonusNumber(inputBonusNumber, winningNumbers)) {
                break;
            }
        }
    }

    private static boolean isValidInput(String input) {
        try {
            int inputAmount = Integer.parseInt(input);
            if (inputAmount % 1000 != 0) {
                System.err.println("[ERROR] 구입금액은 1000원 단위여야 합니다. 다시 입력해주세요.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 구입금액은 숫자로 입력해주세요.");
            return false;
        }
    }

    private static boolean isVaileNumbers(String[] numberStrings, List<Integer> winningNumbers) {
        for (String numberString : numberStrings) {
            int number = 0;
            try {
                number = Integer.parseInt(numberString);

            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 숫자로 변환할 수 없는 값이 입력되었습니다.");
                return false;
            }

            if (number < 1 || number > 45) {
                System.err.println("[ERROR] 1부터 45 사이의 번호를 입력하세요.");
                return false;
            }

            if (winningNumbers.contains(number)) {
                System.err.println("[ERROR] 중복된 번호를 입력했습니다.");
                return false;
            }
            winningNumbers.add(number);
        }
        return true;
    }

    private static boolean isVaildBonusNumber (String number, List<Integer> winningNumbers) {
        try {
            int changeNumber = Integer.parseInt(number);
            if (changeNumber < 1 || changeNumber > 45) {
                System.err.println("[ERROR] 1부터 45 사이의 번호를 입력하세요.");
                return false;
            }
            if (winningNumbers.contains(changeNumber)) {
                System.err.println("[ERROR] 당첨 번호에 이미 존재하는 숫자입니다.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 숫자로 변환할 수 없는 값이 입력되었습니다.");
            return false;
        }
        return true;
    }
}
