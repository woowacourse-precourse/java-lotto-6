package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public int purchase() {
        Validation validation = new Validation();
        int purchaseAmount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputString = Console.readLine();
                validation.isAllNumber(inputString);
                purchaseAmount = Integer.parseInt(inputString);
                validation.isDivisibleByThousand(purchaseAmount);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        return purchaseAmount;
    }
}
