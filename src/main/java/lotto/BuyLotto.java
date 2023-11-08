package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {

    Validation validate = new Validation();
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
        validate.validateIsNum(input);
        int budget = Integer.parseInt(input);
        validate.validateIsThousand(budget);
        numLotto = budget / 1000;
    }

}
