package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchase = 0; // 구입 금액
        try{
            // 1-1. 로또 금액 입력 받음
            System.out.println("구입금액을 입력해 주세요.");
            purchase = Integer.parseInt(Console.readLine());
            if(purchase % 1000 != 0){
                throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
            }
        } catch (IllegalArgumentException e){
            // 1-2. 금액이 1000원 단위가 아니면 예외 발생
            System.out.println("[ERROR] "+e.getMessage());
        }

    }
}
