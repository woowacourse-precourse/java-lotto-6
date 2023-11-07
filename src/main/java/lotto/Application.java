package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요:");
        getQuantityOfLotto(Console.readLine());
    }

    public static Integer convertMoneyFormat(String inputMoney) {
        Integer money = Integer.valueOf(inputMoney);
        return money;
    }
    public static void getQuantityOfLotto(String inputMoney) {
        Integer money = convertMoneyFormat(inputMoney);
        Integer quantityOfLotto = money/1000;
        System.out.println(quantityOfLotto);
    }

    //수량 만큼 반복
        // 로또 랜덤 생성
        //랜덤 생성된 로또 정렬
        //로또 객체 만들기
        //로또 list에 삽입(로또 배열 만들어야함)
}
