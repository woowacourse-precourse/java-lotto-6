package lotto;

import lotto.Controller.LottoResult;
import lotto.Input.*;
import lotto.Output.LottoGameResult;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        LottoAmount lottoAmount = new LottoAmount();
        System.out.println();

        System.out.println(lottoAmount.getTicket() + "개를 구매했습니다.");
        ArrayList<List<Integer>> playerLottos = new ArrayList<List<Integer>>();
        for (int i = 0; i < lottoAmount.getTicket(); i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            System.out.println(lottoNumbers.getLottoTicket());
            playerLottos.add(lottoNumbers.getLottoTicket());
        }
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();


        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        LottoBonusNumber bonusNumber = new LottoBonusNumber();


        LottoResult lottoResult = new LottoResult(playerLottos, lottoWinningNumber.getAnswer(), bonusNumber.getBonus());

        System.out.println();
        LottoGameResult lottoGameResult = new LottoGameResult(lottoAmount.getLottoPurchaseAmount(), lottoResult.getLottoResult());

    }
}
