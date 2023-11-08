package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurcahseAmountValidator;
import lotto.validator.WinningNumberValidator;

public class Input {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;

    public Input(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
    }

    public int startInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        if(PurcahseAmountValidator.validate(purchaseAmount));
        System.out.println();

        int numOfTicket = Integer.parseInt(purchaseAmount)/1000;
        System.out.println(numOfTicket+"개를 구매했습니다.");

        for(int i=0; i<numOfTicket; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTicket.add(new Lotto(numbers));
            printLottoTicket(lottoTicket.get(i));
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = Console.readLine();
        WinningNumberValidator.validate(winningNum);
        String[] splitWinningNumber = winningNum.split(",");
        for (String num : splitWinningNumber) {
            winningNumber.add(Integer.parseInt(num));
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        BonusNumberValidator.validate(bonusNum);
        int bonusNumber = Integer.parseInt(bonusNum);
        System.out.println();

        return bonusNumber;
    }

    private void printLottoTicket(Lotto lo) {
        System.out.println(lo.getNumbers());
    }
}
