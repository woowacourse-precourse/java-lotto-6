package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    public int price;
    public int number;

    public void inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        price = Integer.parseInt(Console.readLine());
    }

    public void inputValidate(){
        double tempNumber = 0;
        while(true){
            try {
                tempNumber = price/1000;
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 가격은 1000단위여야 합니다.");
                System.out.println("구입금액을 입력해 주세요.");
                price = Integer.parseInt(Console.readLine());
            }
        }
        number = (int) tempNumber;
    }

}
