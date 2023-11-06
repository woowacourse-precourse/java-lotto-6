package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int num = Integer.parseInt(Console.readLine());
            if(num % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
        }


    }
}
