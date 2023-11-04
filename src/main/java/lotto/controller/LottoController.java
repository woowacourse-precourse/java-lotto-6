package lotto.controller;

import static lotto.view.View.requestMoney;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;
public class LottoController {
    public void run(){
        Money money = new Money(requestMoney());
        Customer customer = new Customer(money);
        LottoNumber lottoNumber = new LottoNumber();

        System.out.println(customer.getLottoCount()+"개를 구매했습니다.");
        System.out.println("당첨번호를 입력해 주세요");
        String winningNumber = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        if (winningNumbers.size() != winningNumbers
                .stream()
                .distinct()
                .toList()
                .size()
        ){
            throw new IllegalArgumentException();
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("이햐 3개부터 6개까지 일치여부 프린트");
    }
}
