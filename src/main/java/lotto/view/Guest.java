package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Guest {
    int price;
    int count;
    public int lottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        price = Integer.parseInt(Console.readLine());
        divideExceptionHandling(price);
        count = price/1000;
        return count;
    }

    public void divideExceptionHandling(int price) {
        try{
            if (price%1000 != 0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 1000단위로 입력해야 됩니다.");
            lottoCount();
        }
    }
}
