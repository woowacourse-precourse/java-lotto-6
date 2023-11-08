package lotto;

import lotto.Controller.LottoResult;
import lotto.Input.*;
import lotto.Output.Result;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        LottoAmount lottoAmount = new LottoAmount();
        System.out.println();

        System.out.println(lottoAmount.getTicket() + "개를 구매했습니다.");
        ArrayList<List<Integer>> lottos = new ArrayList<List<Integer>>();
        for (int i = 0; i < lottoAmount.getTicket(); i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            System.out.println(lottoNumbers.getNumbers());
            lottos.add(lottoNumbers.getNumbers());
        }
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        LottoAnswer lottoAnswer = new LottoAnswer();


        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        LottoBonusNumber bonusNumber = new LottoBonusNumber();


        LottoResult lottoResult = new LottoResult(lottos, lottoAnswer.getAnswer(), bonusNumber.getBonus());

        System.out.println();
        Result result = new Result(lottoAmount.getPrice(), lottoResult.getLottoResult());

    }
}
