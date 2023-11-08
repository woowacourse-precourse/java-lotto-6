package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.lottoMaker.Lotto;
import lotto.lottoMaker.LottoGenerator;
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
        while(true) {
            try {
                String purchaseAmount = inputPurchaseAmount();
                break;
            } catch(IllegalArgumentException e) {
                ;
            }
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        while(true) {
            try {
                String winningNum = inputWinningNum();
                break;
            } catch(IllegalArgumentException e) {
                ;
            }
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        while(true) {
            try {
                String bonusNum = inputBonusNum();
                bonusNumber = Integer.parseInt(bonusNum);
                break;
            } catch(IllegalArgumentException e) {
                ;
            }
        }
        return bonusNumber;
    }

    private void printLottoTicket(Lotto lo) {
        System.out.println(lo.getNumbers());
    }
    private String inputPurchaseAmount() throws IllegalArgumentException {
        String purchaseAmount = Console.readLine();
        if(PurcahseAmountValidator.validate(purchaseAmount));
        System.out.println();

        int numOfTicket = Integer.parseInt(purchaseAmount)/1000;
        System.out.println(numOfTicket+"개를 구매했습니다.");
        LottoGenerator.generate(lottoTicket, numOfTicket);
        LottoGenerator.printLottoTicket(lottoTicket);
        System.out.println();
        return purchaseAmount;
    }

    private String inputWinningNum() throws IllegalArgumentException {
        String winningNum = Console.readLine();
        WinningNumberValidator.validate(winningNum);
        String[] splitWinningNumber = winningNum.split(",");
        for (String num : splitWinningNumber) {
            winningNumber.add(Integer.parseInt(num));
        }
        System.out.println();
        return winningNum;
    }

    private String inputBonusNum() throws IllegalArgumentException {
        String bonusNum = Console.readLine();
        BonusNumberValidator.validate(bonusNum);
        System.out.println();
        return bonusNum;
    }
}
