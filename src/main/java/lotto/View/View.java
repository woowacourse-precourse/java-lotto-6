package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class View {

    public void myLotto(List<Integer> k){
        for(int i = 0; i < k.size(); i++){
            System.out.println(k.get(i));
        }
    }

    public int buyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return stringToList(money);
    }
    public int buyLotto(int buyMoney){
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
    public List<Integer> correctNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream( Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }
}
