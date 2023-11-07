package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUI {
    private final int INIT_NUM = 0;
    private final int LOTTONUM_MIN_RANGE = 0;
    private final int LOTTONUM_MAX_RANGE = 45;
    private final int LOTTO_LENGTH = 6;
    private final int PURCHASE_MIN = 0;
    private final int PURCHASE_UNIT = 1000;

    private int bonusNum;
    private int cost;
    private List<Integer> winningNums;

    public InputUI() {
        this.bonusNum = INIT_NUM;
        this.cost = INIT_NUM;
    }

    public void bonusBall() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String tempBonus = Console.readLine().trim();
                this.bonusNum = checkValidBonusNum(tempBonus);
                break;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public void checkExceptionWinning(int winning) {
        if (winning < LOTTONUM_MIN_RANGE || winning > LOTTONUM_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void checkLengthWinning(String[] parsedWinnings) {
        if (parsedWinnings.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    public int checkValidBonusNum(String tempBonus) {
        try {
            int bonusNum = Integer.parseInt(tempBonus);
            if (bonusNum >= LOTTONUM_MIN_RANGE && bonusNum <= LOTTONUM_MIN_RANGE) {
                return bonusNum;
            }
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    public int checkValidPurchase(String tempCost) {
        try {
            int cost = Integer.parseInt(tempCost);
            if (cost <= PURCHASE_MIN) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 "+PURCHASE_MIN+"원 이상이여야 합니다.");
            }
            if (cost % PURCHASE_UNIT != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 "+PURCHASE_UNIT+"원 단위여야 합니다.");
            }
            return cost;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
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

    public int getCost() {
        return cost;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public int getNumofLotto() {
        return cost / PURCHASE_UNIT;
    }

    public List<Integer> getWinningNums() {
        List<Integer> copiedWinningNums = new ArrayList<>();
        copiedWinningNums.addAll(winningNums);
        return copiedWinningNums;
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


    public void winnings() {
        while (true) {
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


}
