package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        while(true){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int inputPrice = Integer.valueOf(readLine());
                validateThousandUnit(inputPrice);
                return;
            } catch (IllegalArgumentException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
    }

    private static void validateThousandUnit (int inputPrice) {
        if((inputPrice %1000)!=0){
           /* System.out.println();*/
            throw new IllegalArgumentException("[ERROR] 구입금액 단위는 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}
