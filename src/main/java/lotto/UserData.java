package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserData {
    public int money;
    public int lottoCount;
    public double returnRate;

    public void inputMoney(){
        int rawMoney = Integer.parseInt(Console.readLine());
        validateMoney(rawMoney);
        money = rawMoney;
    }

    public void validateMoney(int raw){
        if(raw % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
