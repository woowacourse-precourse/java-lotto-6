package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {
    private static boolean correctInputMoney;
    private static int buyingQuantityLotto;
    public static int inputMoney(){
        //로또 구입 금액 입력
        correctInputMoney = false;
        int inputPurchaseMoney = 0;

        while(!correctInputMoney){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                inputPurchaseMoney = Integer.valueOf(readLine());
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 올바른 금액을 입력해 주세요.");
            }

            validateInputMoney(inputPurchaseMoney);
        }

        return inputPurchaseMoney;
    }

    private static void validateInputMoney(int inputPurchaseMoney){
        //1000원으로 나누어떨어지지 않는 경우 에러 처리
        try{
            if(inputPurchaseMoney % 1000 == 0){
                quantityLotto(inputPurchaseMoney);
                correctInputMoney = true;
            }else if(inputPurchaseMoney % 1000 != 0){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 금액인 1000원 단위로 입력해주세요.");
        }
    }

    public static void quantityLotto(int inputPurchaseMoney) {
        //발행한 로또 수량 출력
        buyingQuantityLotto = inputPurchaseMoney / 1000;
        System.out.println();
        System.out.println(buyingQuantityLotto + "개를 구매했습니다.");
    }

    public static List<Integer> numberLotto(){
        //로또 번호(오름차순, 중복 X) 출력
        List<Integer> lottoNumbersPurchased = new ArrayList<>();
        for(int i = 0; i < buyingQuantityLotto; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            for(int num : numbers){
                lottoNumbersPurchased.add(num);
            }
            System.out.println(numbers);
        }

        return lottoNumbersPurchased;
    }
}
