package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public int getMoney(){
        System.out.println("구입금액을 입력해 주세요.\n");
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    private void validateMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE+" 로또는 1000원 단위로 구매가 가능합니다.");
        }
    }


}
