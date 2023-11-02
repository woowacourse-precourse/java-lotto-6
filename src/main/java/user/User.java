package user;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int money = Integer.parseInt(Console.readLine());
                validateInputMoney(money);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int validateInputMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1장당 1000원입니다. 1000원 단위로 구매를 진행해주세요.");
        }
        return  money;
    }
}

