package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class LottoService {

    public void inputAmount(){
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String amountStr = Console.readLine();
            validateAmount(amountStr);
        }
    }
    private void validateAmount(String amountStr){
        try {
            int amount = Integer.parseInt(amountStr);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.");
            } else {
                System.out.println(amount);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
