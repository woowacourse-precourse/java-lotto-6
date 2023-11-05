package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.domain.lotto.LottoService;

public class LottoController {

    private LottoService ls = new LottoService();
    public void insertUserInputNumbers(){
        System.out.println("구매할 로또 금액을 입력하세요.");
        System.out.println("1000원 - 1장 구매 입니다.");
        System.out.println("단위가 1000원 을 벗어나는 경우 프로그램이 종료됩니다.");
        String inputNumbers = Console.readLine();
        // 위 부분은 view로 따로 빼기

        // String 을 int로 바꿈 -> 이 경우에 익셉션을 터트리도록 설계
        int price = 50000;

        // 구매한 개수를 알고 싶을 때 출력 하도록 제작
        // 이 결과를 뷰로 보내주기
        int num = ls.numberOfLottoPurchases(price);

    }

}
