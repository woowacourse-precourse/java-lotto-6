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
    public void inputLottoNum(){
        System.out.println("당첨 번호를 입력하세요.");
        String inputStr = Console.readLine();
        String[] input = inputStr.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberStr : input) {
            validateLottoNum(numbers,numberStr);
        }
    }
    private List<Integer> validateLottoNum(List<Integer> numbers, String numberStr){
        try {
            int number = Integer.parseInt(numberStr);
            if(number>=1 && number<=45){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호입니다.");
            }
            numbers.add(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
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
