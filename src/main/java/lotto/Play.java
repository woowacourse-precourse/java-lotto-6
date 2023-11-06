package lotto;

import static lotto.io.ErrorHandler.*;


import camp.nextstep.edu.missionutils.Console;

public class Play {
    int numberOfTicket;
    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        String boughtAmount = Console.readLine();
        numberOfTicket = checkBoughtAmount(boughtAmount);
        MakeLottoCard lottoCard = new MakeLottoCard(numberOfTicket);
    }
    public int giveNumberOfTicket(String boughtAmount){
        int boughtAmountInt = Integer.parseInt(boughtAmount);
        return boughtAmountInt / 1000;
    }
    public Integer checkBoughtAmount(String boughtAmount) {
        checkInt(boughtAmount);
        checkPositive(boughtAmount);
        checkThousands(boughtAmount);
        return giveNumberOfTicket(boughtAmount);
    }
}
