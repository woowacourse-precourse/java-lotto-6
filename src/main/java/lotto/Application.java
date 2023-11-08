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
        int bonusNumber = 0;
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String inputBonusNumber = Console.readLine();
            if (isVaildBonusNumber(inputBonusNumber, winningNumbers)) {
                bonusNumber = Integer.parseInt(inputBonusNumber);
                break;
            }
        }
        int threeMatch = 0;
        int fourMatch = 0;
        int fiveMatch = 0;
        int sixMatch = 0;
        int bonusMatch = 0;

        int threeReward = 5000;
        int fourReward = 50000;
        int fiveReward = 1500000;
        int sixReward = 2000000000;
        int bonusReward = 30000000;
        for (int i = 0; i < lottoList.size(); i++) {
            switch (isWinner(lottoList.get(i), winningNumbers, bonusNumber)) {
                case 3:
                    threeMatch++;
                    break;
                case 4:
                    fourMatch++;
                    break;
                case 5:
                    fiveMatch++;
                    break;
                case 6:
                    sixMatch++;
                    break;
                case 7:
                    bonusMatch++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatch + "개");
        System.out.println("4개 일치 (50,000원) - " + fourMatch + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatch + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusMatch + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatch + "개");

        int money = threeMatch * threeReward + fourMatch * fourReward + fiveMatch * fiveReward + sixMatch * sixReward
                + bonusMatch * bonusReward;
        double result = (double) money / (purchaseAmount * 1000) * 100;
        String finalResult = String.format("%.1f", result);
        System.out.println("총 수익률은 " + finalResult + "%입니다.");
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

    private static boolean isVaildBonusNumber(String number, List<Integer> winningNumbers) {
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

    private static int isWinner(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        switch (lotto.isWinner(winningNumbers)) {
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                if (lotto.isBonus(bonusNumber)) {
                    return 7;
                }
                return 5;
            case 6:
                return 6;
            default:
                break;
        }
        return 0;
    }
}
