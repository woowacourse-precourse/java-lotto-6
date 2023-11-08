package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoNumberInput {
    List<Integer> numbers;
    int countNum;
    String bonusNum;
    public void run (){
        moneyInput();
        numberInput();
        LottoGenerator lotto = new LottoGenerator(numbers);
    }

    private void moneyInput(){
        System.out.println("구입금액을 입력해 주세요.?");
        countNum = Integer.parseInt(Console.readLine());
    }

    private void numberInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String num = Console.readLine();
        for(String i : num.split(",")){
            numbers.add(Integer.parseInt(i));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Console.readLine();
    }
}
