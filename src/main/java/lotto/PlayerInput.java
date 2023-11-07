package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerInput {
    //금액 입력받기
    public int InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    public List<Integer> LottoNumber() {
        List<Integer> winNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for (String number : input.split(",")) {
            winNumber.add(Integer.parseInt(number));
        }
        return winNumber;
    }
    public int BonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
