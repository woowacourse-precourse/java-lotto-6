package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUI {
    private final int INIT_NUM = 0;
    private int bonusNum;
    private int cost;
    private List<Integer> winningNums;

    public InputUI() {
        this.bonusNum = INIT_NUM;
        this.cost = INIT_NUM;
    }

    public int getCost() {
        return cost;
    }

    public int getNumofLotto() {
        return cost / 1000;
    }

    public List<Integer> getWinningNums() {
        List<Integer> copiedWinningNums = new ArrayList<>();
        copiedWinningNums.addAll(winningNums);
        return copiedWinningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void purchase() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String tempCost = Console.readLine();
                cost = checkValidPurchase(tempCost);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public int checkValidPurchase(String tempCost) {
        try {
            int cost = Integer.parseInt(tempCost);
            if (cost <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0원 이상이여야 합니다.");
            }
            if (cost % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
            return cost;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    public void bonusBall() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String tempBonus = Console.readLine();
                bonusNum = checkValidBonusNum(tempBonus);
                break;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public int checkValidBonusNum(String tempBonus) {
        try {
            int bonusNum = Integer.parseInt(tempBonus);
            if (bonusNum >= 1 && bonusNum <= 45) {
                return bonusNum;
            }
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    public void winnings() {
        while(true){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputWinnings = Console.readLine();
                String[] parsedWinnings = inputWinnings.split(",");
                winningNums = checkValidWinnings(parsedWinnings);
                break;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public List<Integer> checkValidWinnings(String[] parsedWinnings) {
        try {
            List<Integer> winningNum = new ArrayList<>();
            checkLengthWinning(parsedWinnings);
            for (String element : parsedWinnings) {
                int winning = Integer.parseInt(element);
                checkExceptionWinning(winning);
                winningNum.add(winning);
            }
            return winningNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void checkLengthWinning(String[] parsedWinnings) {
        if (parsedWinnings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    public void checkExceptionWinning(int winning) {
        if (winning < 0 || winning > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


}
