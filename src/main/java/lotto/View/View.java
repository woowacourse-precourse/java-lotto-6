package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class View {

    public int buyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return stringToList(money);
    }
    public int buyLotto(int buyMoney){
        System.out.println(buyMoney / 1000 + "개를 구매했습니다.");
        return buyMoney / 1000;
    }
    private int stringToList(String money){
        if(!isValidString(money)){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 이루어져야 합니다.");
        }
        if(!isDivideNumber(money)){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원단위로 나눠져야 합니다.");
        }
        return Integer.parseInt(money);
    }
    private boolean isValidString(String money){
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, money);
    }
    private boolean isDivideNumber(String money){
        if(Integer.parseInt(money) % 1000 != 0){
            return false;
        }
        return true;
    }
}
