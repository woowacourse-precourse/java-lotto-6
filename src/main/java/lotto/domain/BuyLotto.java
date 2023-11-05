package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {
    public static void inputMoney(){
        //로또 구입 금액 입력
        //1000원으로 나누어떨어지지 않는 경우 에러 처리
        int inputPurchaseMoney;

        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            inputPurchaseMoney = Integer.valueOf(readLine());
            try{
                if(inputPurchaseMoney % 1000 == 0){
                    quantityLotto(inputPurchaseMoney);
                    break;
                }else if(inputPurchaseMoney % 1000 != 0){
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 로또 금액인 1000원 단위로 입력해주세요.");
            }
        }
    }

    public static void quantityLotto(int inputPurchaseMoney) {
        //발행한 로또 수량 출력
        int buyingQuantityLotto = inputPurchaseMoney / 1000;
        System.out.println();
        System.out.println(buyingQuantityLotto + "개를 구매했습니다.");
    }

    public static void numberLotto(){
        //로또 번호(오름차순, 중복 X) 출력

    }
}
