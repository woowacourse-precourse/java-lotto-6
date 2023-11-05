package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        // 구입 금액을 입력
        int userMoney = getValidMoney();

        // 사용자 게임 수 출력
        int lottoGame = userMoney / 1000;
        System.out.println();
        System.out.println(lottoGame + "개를 구매했습니다.");

        // 게임 수 만큼 로또 생성후 출력
        for (int i = 0; i < lottoGame; i++) {
            Lotto lotto = Lotto.generateLotto();
            System.out.println(lotto.getNumbers());
        }
        System.out.println();

        // 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        int[] winningNumbers = getValidWinningNumbers();
        System.out.println();

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber();
        System.out.println();

        // 당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        
        // 5등 확인 메서드
        
        // 4등 확인 메서드
        
        // 3등 확인 메서드
        
        // 2등 확인 메서드
        
        // 1등 확인 메서드
    }

    // 당첨 번호를 입력받는 메서드
    public static int[] getWinningNumbers() {
        String input = Console.readLine();
        String[] inputNumbers = input.split(",");
        int[] winningNumbers = new int[6];

        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해 주세요.");
        }

        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        return winningNumbers;
    }

    // 당첨 번호가 유효한지 검사하는 메서드
    public static int[] getValidWinningNumbers() {
        try {
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidWinningNumbers();
        }
    }

    // 보너스 번호를 입력받는 메서드
    public static int getBonusNumber() {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                validBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호가 유효한지 확인하고 예외를 발생시키는 메서드
    private static void validBonusNumber(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상 45 이하여야 합니다.");
        }
    }

    // 사용자 입력 금액이 유효한지 확인하는 메서드
    public static int getValidMoney() {
        while (true) {
            try {
                int userMoney = getMoney();
                correctMoney(userMoney);
                return userMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 사용자에게 구입 금액을 입력 받는 메서드
    public static int getMoney() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 된 금액을 입력해 주세요.");
        }
    }

    // 사용자 구입 금액이 정확한지 확인하는 메서드
    public static void correctMoney(int userMoney) {
        if (userMoney % 1000 != 0 || userMoney <= 0) {
            // IllegalArgumentException을 발생 시키고 오류 메시지 출력
            throw new IllegalArgumentException("[ERROR] 천원 단위로 금액을 입력해 주세요.");
        }
    }
}
