package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswerValidator;
import lotto.domain.LottoSalesManager;

public class Application {
    private final static int lottoPrice = 1000;

    public static void main(String[] args) {
        List<Lotto> purchaseLottos = purchaseLottos();
        System.out.println();
        showPurchaseLottos(purchaseLottos);
        System.out.println();
        List<Integer> answerNumbers = makeAnswerNumbers();
        int bonusNumber = makeBonusNumber();
        System.out.println();
        finish(purchaseLottos, answerNumbers, bonusNumber);
    }

    private static void finish(List<Lotto> purchaseLottos, List<Integer> answerNumbers, int bonusNumber) {
        int[] ranks = new int[5];
        for (Lotto lotto : purchaseLottos) {
            int matchedCount = lotto.compareWithTheCorrectAnswer(answerNumbers);
            boolean bonusNumberIsMatched = lotto.compareWithBonusNumber(bonusNumber);
            if (matchedCount >= 3) {
                ranks[LottoSalesManager.judgeLottosRank(matchedCount, bonusNumberIsMatched) - 1]++;
            }
        }
        Calculator.calculateTheRateOfReturn(ranks, purchaseLottos.size() * lottoPrice);
    }

    private static void showPurchaseLottos(List<Lotto> purchaseLottos) {
        System.out.println(purchaseLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchaseLottos) {
            lotto.printLottoNumbers();
        }
    }

    private static int makeBonusNumber() {
        int bonusNumber = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");

                isValid = true;
                bonusNumber = LottoAnswerValidator.convertStringToNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                isValid = false;
            }
        }
        return bonusNumber;
    }


    private static List<Integer> makeAnswerNumbers() {
        List<Integer> answerNumbers = null;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                isValid = true;
                answerNumbers = LottoAnswerValidator.checkIsValidLottoNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                isValid = false;
            }
        }
        return answerNumbers;
    }

    private static List<Lotto> purchaseLottos() {
        boolean isValid = false;
        LottoSalesManager lottoSalesManager = null;
        while (!isValid) {
            try {
                isValid = true;
                System.out.println("구입금액을 입력해 주세요.");
                lottoSalesManager = new LottoSalesManager(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                isValid = false;
            }
        }
        return lottoSalesManager.makeLottos();
    }
}
