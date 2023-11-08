package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {
    private int numLotto;
    private boolean checkValidBudget = true;
    public int BuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        while (checkValidBudget) {
            inputBudget();
        }
        return numLotto;
    }

    private void inputBudget() {
        try {
            String budget = readLine();
            calculateNumLotto(budget);
            checkValidBudget = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkValidBudget = true;
        }
    }

    public void calculateNumLotto(String input) {
        validateIsNum(input);
        int budget = Integer.parseInt(input);
        validateIsThousand(budget);
        numLotto = budget / 1000;
    }

    private void validateIsNum(String buget) {
        if (!buget.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateIsThousand(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1,000단위로 입력해주세요.");
        }
    }
}
