package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {
    int price;

    // 생성자 | 입력 값을 price에 저장
    public Customer() {
        this.price = Integer.parseInt(Console.readLine());
    }

    // 입력한 가격을 반환하는 메서드
    public int getPrice() {
        return price;
    }
}
