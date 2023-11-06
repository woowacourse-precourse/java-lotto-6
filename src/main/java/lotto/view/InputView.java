package lotto.view;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.NumberParser.parseWinningNum;

public class InputView {

    public int readPurchaseMoney() {
        boolean flag = false;
        int purchaseMoney = 0;
        while (!flag) {
            try {
                String purchaseMoneyStr = readLine();
                purchaseMoney = validatePurchaseMoneyIsInt(purchaseMoneyStr); // int인지 검증, 오류나면 catch로ㅠ
                validatePurchaseMoneyIsMultipleOfThousand(purchaseMoney);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                OutputView.printStartMessage();
            }
        }
        return purchaseMoney;
    }

    // excpetion
    public int validatePurchaseMoneyIsInt(String purchaseMoneyStr) {
        try {
            return Integer.parseInt(purchaseMoneyStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    public void validatePurchaseMoneyIsMultipleOfThousand(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0 || purchaseMoney ==0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위만 입력 가능합니다.");
        }
    }
    // end

    public ArrayList<Integer> readWinningNum() {
        boolean flag = false;
        ArrayList<Integer> winningNum = new ArrayList<>();
        while (!flag) {
            try {
                String winningNumStr = readLine();
                validateWinningNumCommaAfterComma(winningNumStr);
                validateBlankInWinningNum(winningNumStr);
                validateWinningNumLastCharIsComma(winningNumStr);
                winningNum = parseWinningNum(winningNumStr);
                validateWinningNumCountIsOver(winningNum);
                flag=true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                OutputView.printInputWinnerNumMessage();
            }
        }
        return winningNum;
    }

    // exception
    public void validateWinningNumCountIsOver(ArrayList<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호 개수는 6개 입니다.");
        }
    }

    public void validateWinningNumCommaAfterComma(String winningNumStr) {
        for (int i = 0; i < winningNumStr.length()-1; i++) {
            if (winningNumStr.charAt(i) == ',' && winningNumStr.charAt(i+1) == winningNumStr.charAt(i)) {
                throw new IllegalArgumentException("[ERROR] ','다음에 바로','가 입력되었습니다.");
            }
        }
    }

    public void validateBlankInWinningNum(String winningNumStr) {
        for (int i = 0; i < winningNumStr.length(); i++) {
            if (winningNumStr.charAt(i) == ' ') {
                throw new IllegalArgumentException("[ERROR] 공백 없이 입력해 주세요.");
            }
        }
    }

    public void validateWinningNumLastCharIsComma(String winningNumStr) {
        if (winningNumStr.charAt(winningNumStr.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 마지막에 ','가 입력 되었습니다.");
        }
    }
    // end
    public int readBonusNum() {
        boolean flag = false;
        int bonusNum = 0;
        while (!flag) {
            try {
                String bonusNumStr = readLine();
                bonusNum = validateBonusNumIsInt(bonusNumStr);
                validateBonusNumIsInRange(bonusNum);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }

    public int validateBonusNumIsInt(String bonusNumStr) {
        try {
            return Integer.parseInt(bonusNumStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public void validateBonusNumIsInRange(int bonusNum) {
        if (!(bonusNum >= 1 && bonusNum <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1이상 45이하 입니다.");
        }
    }
}
