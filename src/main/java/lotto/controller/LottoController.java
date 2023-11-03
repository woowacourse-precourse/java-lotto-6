package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.view.View;
public class LottoController {
    public void run(){
        LottoNumber lottoNumber = new LottoNumber();
        Lotto lotto = new Lotto(lottoNumber.getLottoNumbers());
        int budget = View.requestMoney();
        if (budget % 1000 != 0){
            throw new IllegalArgumentException();
        }
        int purchasedLotto = budget / 1000;
        System.out.println(purchasedLotto+"개를 구매했습니다.");

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
