package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private final static String AMOUNT = "구입금액을 입력해 주세요.";
    private final static String COUNT = "개를 구매했습니다.";
    private final static String LUCKY_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String ERROR = "[ERROR]";

    public int purchase(){
        while(true){
            System.out.println(AMOUNT);
            try {
                String priceStr = Console.readLine();
                int amount = Integer.parseInt(priceStr);
                if (isNotDivisibleBy1000(amount)) {
                    return amount;
                }
            } catch (IllegalArgumentException e) { }
        }
    }

    public boolean isNotDivisibleBy1000(int amount){
        if(amount % 1000 != 0){
            System.out.println(ERROR + " 1000으로 나누어 떨어지는 금액을 입력하세요.");
            return false;
        }
        return true;
    }

    public void count(){
        LottoGame input = new LottoGame();
        int num = input.purchase() / 1000;
        System.out.println("\n"+num+COUNT);
    }
}

