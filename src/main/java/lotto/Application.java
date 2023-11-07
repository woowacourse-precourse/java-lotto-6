package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 당첨 로또 수
    static int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        // 구입 금액을 입력
        int userMoney = getValidMoney();

        // 사용자 게임 수 출력
        int lottoGame = userMoney / 1000;
        System.out.println();
        System.out.println(lottoGame + "개를 구매했습니다.");

        // 게임 수 만큼 로또 생성후 출력
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoGame; i++) {
            Lotto lotto = Lotto.generateLotto();
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoList.add(lottoNumbers);
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

        for (int i = 0; i < lottoGame; i++) {
            List<Integer> userLotto = lottoList.get(i);
            int matches = checkMatches(userLotto, winningNumbers);
            boolean bonus = checkBonusMatches(userLotto, bonusNumber);
            countMatches(matches, bonus);
        }
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");

        // 총 수익률 출력
        int total = getTotalMoney();
        double profit = (double) total / userMoney * 100;
        System.out.println("총 수익률은 " + String.format("%,.1f", profit) + "%입니다.");
    }

    public enum Prize {
        FIRST(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);
        private final int prizeAmount;

        Prize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }

    public static int getTotalMoney() {
        int total = 0;
        total += first * Prize.FIRST.getPrizeAmount();
        total += second * Prize.SECOND.getPrizeAmount();
        total += third * Prize.THIRD.getPrizeAmount();
        total += fourth * Prize.FOURTH.getPrizeAmount();
        total += fifth * Prize.FIFTH.getPrizeAmount();
        return total;
    }

    // 당첨 로또 수 카운트 메서드
    public static void countMatches(int matches, boolean bonus) {
        if (matches == 6) first++;
        if (matches == 5 && bonus) second++;
        if (matches == 5) third++;
        if (matches == 4) fourth++;
        if (matches == 3) fifth++;
    }

    // 각 게임에서 몇 개의 번호가 맞았는지 확인하는 메서드
    public static int checkMatches(List<Integer> userLotto, int[] winningNumbers) {
        int matches = 0;
        boolean[] matched = new boolean[46];
        for (int userNumber : userLotto) {
            matched[userNumber] = true;
        }
        for (int winningNumber : winningNumbers) {
            if (matched[winningNumber]) {
                matches++;
            }
        }
        return matches;
    }

    // 각 게임에서 보너스 번호가 있는지 확인하는 메서드
    public static boolean checkBonusMatches(List<Integer> userLotto, int bonusNumber) {
        return userLotto.contains(bonusNumber);
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
