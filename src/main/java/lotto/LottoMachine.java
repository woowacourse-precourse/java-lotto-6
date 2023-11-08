package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {
    private int count;


    public void getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try{
            this.count = Integer.parseInt(input)/1000;
        } catch (IllegalArgumentException e){
            System.out.println(("[Error] 1000원 단위로 나누어 떨어져야 합니다."));
            getMoney();
        }

    }

}
