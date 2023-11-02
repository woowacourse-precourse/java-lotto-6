package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private final List<Lotto> lottos;
    private int price;

    public User(List<Lotto> lottos) {
        inputPrice();
        this.lottos = lottos;
    }
    public void inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        price= Integer.parseInt(Console.readLine());
        if(!validatePrice(price)) throw new IllegalArgumentException("잘못된 금액을 입력했습니다.");

    }
    public boolean validatePrice(int price){
        if((price%1000)!=0) return false;
        else return true;
    }



}
