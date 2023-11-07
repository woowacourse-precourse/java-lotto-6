package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private void printMessage(String outputMessage){
        System.out.println(outputMessage);
    }

    public String askPurchasingAmount(){
        printMessage("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void printOrderedLottoCount(int ticketCount) {
        printMessage(ticketCount + "개를 구매했습니다.");
    }
}
