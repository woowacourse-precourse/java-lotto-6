package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int makeTicket(int totalPrice) {
        if (totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return totalPrice/1000;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int totalPrice = 0;
        int ticket = 0;
        // 1000원 나누어 떨어지지 않는 경우 예외처리
        while (true){
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                totalPrice = Integer.parseInt(readLine());
                ticket = makeTicket(totalPrice);
                System.out.println(ticket + "개를 구매했습니다." );
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        int[] winNumber  = new int[7];
        String[] winNumberString = readLine().split(",");

        for (int i = 0; i < 6; i++){
            winNumber[i] = Integer.parseInt(winNumberString[i].trim());
        }

        int bonusNumber = Integer.parseInt(readLine());
        winNumber[6] = bonusNumber;

    }
}
