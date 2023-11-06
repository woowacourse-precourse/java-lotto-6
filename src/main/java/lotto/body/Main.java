package lotto.body;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoBody;
import lotto.util.Validate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Validate valid = new Validate();

    private int purchaseMoney = 0;
    private List<Integer> prizeNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    public Main() {
        readPurchaseMoney();
        System.out.println();
        LottoBody lottos = new LottoBody(purchaseMoney);
        readPrizeNumbers();
        System.out.println();
        readBonusNumber();
        System.out.println();
        lottos.setAnswerNumbers(prizeNumbers);
        lottos.setBonus(bonusNumber);
        System.out.print(lottos.printPrizeResult());
        System.out.println(lottos.getProfit());
    }

    private String read() {
        return Console.readLine();
    }

    private void readPurchaseMoney() {
        int returnVal;
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                returnVal = valid.getPurchaseMoney(read());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        purchaseMoney = returnVal;
    }

    private void readPrizeNumbers() {
        List<Integer> returnVal;
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                returnVal = valid.getPrizeNumbers(read());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        prizeNumbers = returnVal;
    }

    private void readBonusNumber() {
        int returnVal;
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                returnVal = valid.getBonusNumber(prizeNumbers, read());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        bonusNumber = returnVal;
    }
}