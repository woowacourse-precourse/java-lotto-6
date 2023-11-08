package lotto;

public class Computer {
    final String ASK_PRICE = "구입금액을 입력해 주세요.";
    String getPriceFromUser(){
        System.out.println(ASK_PRICE);

        return camp.nextstep.edu.missionutils.Console.readLine();
    }

}
