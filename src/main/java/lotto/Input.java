package lotto;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Double.isNaN;

public class Input {

    public int lottoValue = 1000;
    public int inputValue(){
        //로또 구입 금액을 먼저 받는다
        System.out.println("구입금액을 입력해 주세요.");
        int input = 0;


        while (true) {

            try {
                String userInput = Console.readLine();
                input = Integer.parseInt(userInput);


                // 입력이 유효한 경우
                break; // 올바른 입력을 받았으므로 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 문자열을 입력할 수 없습니다.");
                // 예외 처리
//                throw new IllegalArgumentException("[ERROR] 문자열을 입력할 수 없습니다.");
//                // 다시 입력을 받을 수 있도록 루프 계속 c
            }
        }




        int inputValue = input / lottoValue;
        System.out.println();   //개행
        System.out.println(inputValue + "개를 구매했습니다.");

        return inputValue;
    }
}