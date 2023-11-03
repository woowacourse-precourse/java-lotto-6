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
        try{
            stringToList(money);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            buyMoney();
        }
        return Integer.parseInt(money);
    }
    public int buyLotto(int buyMoney){
        return buyMoney / 1000;
    }
    private void stringToList(String money){
        if(!isValidString(money)){
            throw new IllegalArgumentException("로또 구입 금액은 숫자로 이루어져야 합니다.");
        }
        if(!isDivideNumber(money)){
            throw new IllegalArgumentException(" 로또 구입 금액은 천원단위로 나눠져야 합니다.");
        }
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
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    public String bonusNum(List a){
        System.out.println("보너스 번호를 입력해 주세요.");
        String k = Console.readLine();
        try{
            bonusNumException(a, k);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            bonusNum(a);
        }
        return k;
    }
    private void bonusNumException(List a, String k){
        if(a.contains(Integer.parseInt(k))){
            throw new IllegalArgumentException("로또 번호는 중복이 불가능 합니다.");
        }
        if(Integer.parseInt(k) > 45 || Integer.parseInt(k) < 1){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
