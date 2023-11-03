package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    public boolean isCostToNumber(String cost) {
        boolean flag = false;

        try{
            Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            flag = true;
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        } finally {
            buyLotto();
        }

        return flag;
    }
}
