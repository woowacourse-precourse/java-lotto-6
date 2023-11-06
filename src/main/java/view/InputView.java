package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private List<Integer> prizeNumber;
    // 테스트를 위해 분리
    public String inputStr() {
        return readLine();
    }

    OutputView outputView = new OutputView();

    public int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            outputView.printInputPurchaseAmount();
            String inputStr = readLine();
            try {
                purchaseAmount = validatePurchaseAmount(inputStr);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }


    public void inputPrizeNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            outputView.printInputPrizeNumber();
            String inputStr = readLine();
            try {
                validatePrizeNumber(inputStr);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        int bonusNumber = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            outputView.printInputBonusNumber();
            String inputStr = readLine();
            try {
                bonusNumber = validateBonusNumber(inputStr);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private int validatePurchaseAmount(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 구성됩니다.");
        }

        int purchaseAmount = Integer.parseInt(inputStr);

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
        return purchaseAmount;
    }

    public void validatePrizeNumber(String inputStr) {
        if (!inputStr.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 구분됩니다.");
        }

        List<Integer> prizeNumberTemp = Arrays.stream(inputStr.split(","))
                .map(s -> {
                    int num = Integer.parseInt(s);
                    if (num > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 45 이하의 숫자로 구성됩니다.");
                    }
                    return num;
                })
                .collect(Collectors.toList());

        if (prizeNumberTemp.size() != new HashSet<>(prizeNumberTemp).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
        }

        if (prizeNumberTemp.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 구성됩니다.");
        }

        this.prizeNumber = prizeNumberTemp;
    }

    public int validateBonusNumber(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 구성됩니다.");
        }

        int bonusNumber = Integer.parseInt(inputStr);

        if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 45 미만의 숫자로 구성됩니다.");
        }

        if (prizeNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }

        return bonusNumber;
    }

    public List<Integer> getPrizeNumber() {
        return prizeNumber;
    }
}
