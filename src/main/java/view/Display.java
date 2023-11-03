package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Display {

    private String lottoPurchaseAmount;


    public Display() {
        setLottoPurchaseAmount();
    }

    private void setLottoPurchaseAmount() {
        System.out.println("구입내역을 입력해 주세요.");
        this.lottoPurchaseAmount = readLine();
    }

}
