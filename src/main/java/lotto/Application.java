package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = "";

        while (purchaseAmount.isEmpty()) {
            purchaseAmount = Console.readLine();
            if (!isValidPurchaseAmount(purchaseAmount)) {
                purchaseAmount = "";
                IllegalArgumentException e = new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.");
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    public static boolean isValidPurchaseAmount(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return value % 1000 == 0;
        } catch (NumberFormatException e) {
            return false; // 숫자로 변환할 수 없는 경우 유효하지 않음
        }
    }

    public static int calculateAndPrintLottoQuantity(String purchaseAmount) {
        int lottoQuantity = Integer.parseInt(purchaseAmount) / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        return lottoQuantity;
    }

    public static void generateLottoNumbers(int lottoQuantity, List<List<Integer>> issuedLottoNumbers) {
        for(int i = 0; i<lottoQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            issuedLottoNumbers.add(numbers);
        }
    }

    public static void printLottoNumbers(List<List<Integer>> issuedLottoNumbers) {
        for (List<Integer> numbers : issuedLottoNumbers) {
            System.out.println(numbers);
        }
    }

    public static void inputWinningNumber(List<Integer> winningNumbers) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        String[] splitWinningNumbers = inputWinningNumbers.split(",");

        while (!isValidWinningNumber(splitWinningNumbers)) {
            inputWinningNumbers = Console.readLine();
            splitWinningNumbers = inputWinningNumbers.split(",");
        }

        for (String splitWinningNumber : splitWinningNumbers) {
            winningNumbers.add(Integer.parseInt(splitWinningNumber));
        }
    }

    public static boolean isValidWinningNumber(String[] splitWinningNumbers) {
        for (int i = 0; i<splitWinningNumbers.length; i++) {
            if (Integer.parseInt(splitWinningNumbers[i]) < 1 || Integer.parseInt(splitWinningNumbers[i]) > 45) {
                IllegalArgumentException e = new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();

        while (Integer.parseInt(inputBonusNumber) < 1 || Integer.parseInt(inputBonusNumber) > 45) {
            IllegalArgumentException e = new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            System.out.println(e.getMessage());
            inputBonusNumber = Console.readLine();
        }

        return Integer.parseInt(inputBonusNumber);
    }

    public static void main(String[] args) {
        String purchaseAmount = inputPurchaseAmount();
        System.out.println();

        int lottoQuantity = calculateAndPrintLottoQuantity(purchaseAmount);
        List<List<Integer>> issuedLottoNumbers = new ArrayList<>();
        generateLottoNumbers(lottoQuantity, issuedLottoNumbers);
        printLottoNumbers(issuedLottoNumbers);
        System.out.println();

        List<Integer> winningNumbers = new ArrayList<>();
        inputWinningNumber(winningNumbers);
        System.out.println();

        int bonusNumber = inputBonusNumber();
    }
}
