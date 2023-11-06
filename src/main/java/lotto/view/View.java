package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String askPurchasingAmount(){
        printMessage("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private void printMessage(String outputMessage){
        System.out.println(outputMessage);
    }
}
