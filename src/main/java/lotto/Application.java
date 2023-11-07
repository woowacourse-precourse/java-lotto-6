package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int makeTicket(int totalPrice) {
        if (totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return totalPrice / 1000;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int ticket = purchaseTicket();
        for (int i = 0; i < ticket; i++) {
            System.out.println(Lotto.makeLotto());
        }
        int[] winNumbers = inputWinningNumbers(); // 당첨 번호는 6개
        int bonusNumber = inputBonusNumber(winNumbers); // 보너스 볼은 1개

    }
    private static int purchaseTicket() {
        int totalPrice;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                totalPrice = Integer.parseInt(readLine());
                int ticket = makeTicket(totalPrice);
                System.out.println(ticket + "개를 구매했습니다.");
                return ticket;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static int[] inputWinningNumbers() {
        int[] winNumbers = new int[6];
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
                String[] winNumberStrings = readLine().split(",");
                if (winNumberStrings.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
                }
                for (int i = 0; i < 6; i++) {
                    winNumbers[i] = Integer.parseInt(winNumberStrings[i].trim());
                    if (winNumbers[i] < 1 || winNumbers[i] > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 값이어야 합니다.");
                    }
                }
                return winNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static int inputBonusNumber(int[] winNumbers) {
        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 볼을 입력해 주세요.");
                bonusNumber = Integer.parseInt(readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45 사이의 값이어야 합니다.");
                }
                for (int winNumber : winNumbers) {
                    if (winNumber == bonusNumber) {
                        throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복될 수 없습니다.");
                    }
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
