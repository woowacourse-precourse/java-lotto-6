package inputprocess;

import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;

public class MoneyInput {
    public static int money;
    public MoneyInput(){inputMoneyCheck();}
    //
    private void inputMoneyCheck() {
        checkInt();
        ableDivideMoney();
    }

    private void ableDivideMoney() {
        int money = MoneyInput.money;
        boolean isValid = false;
        while(!isValid) {
            try{
                validataMoney(money);
                isValid = true;
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위의 금액을 입력해주세요.");
                money = changeInt();
            }
        }
    }

    private void validataMoney(int money) throws IllegalArgumentException {
        if(money % 1000 != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInt() {
        while(true){
            try {
                MoneyInput.money = changeInt();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 정수를 입력해주세요.");
            }
        }
    }

    private int changeInt() {
        try{
            int inputMoney = Integer.parseInt(Console.readLine());
            return inputMoney;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException();
        }
    }

}
