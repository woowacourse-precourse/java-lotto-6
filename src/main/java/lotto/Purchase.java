package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public int purchase() {
        Validation validation = new Validation();
        int purchase_amount = 0;
        boolean valid_input = false;

        while (!valid_input) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputString = Console.readLine();
                validation.isAllNumber(inputString);
                purchase_amount = Integer.parseInt(inputString);
                validation.isDivisibleByThousand(purchase_amount);
                valid_input = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        return purchase_amount;
    }
}
