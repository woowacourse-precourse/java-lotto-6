package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {
    int price;

    // 생성자
    public Customer() {}

    // 입력 값을 price에 저장
    public void inputPrice() {
        try{
            this.price = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 금액은 숫자로만 작성되어야 합니다.");
            this.price = Integer.parseInt(Console.readLine());
        }

    }

    // 입력한 가격을 반환하는 메서드
    public int getPrice() {
        return price;
    }
}
