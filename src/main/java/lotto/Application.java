package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswerValidator;
import lotto.domain.LottoSalesManager;

public class Application {
    public static void main(String[] args) {

        List<Lotto> purchaseLottos = purchaseLottos();
        showPurchaseLottos(purchaseLottos);
        List<Integer> answerNumbers = makeAnswerNumbers();
        int bonusNumber = makeBonusNumber();

        List<Integer> ranks = new ArrayList<>();
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        int fourthCount = 0;
        int fifthCount = 0;
        for(Lotto lotto: purchaseLottos){
            int matchedCount = lotto.compareWithTheCorrectAnswer(answerNumbers);
            boolean bonusNumberIsMatched = lotto.compareWithBonusNumber(bonusNumber);
            if(matchedCount == 5){
                if()
            }
        }

    }

    private static void showPurchaseLottos(List<Lotto> purchaseLottos) {
        System.out.println(purchaseLottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : purchaseLottos){
            lotto.printLottoNumbers();
        }
    }

    private static int makeBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        boolean isValid = false;
        while (!isValid) {
            try{
                isValid = false;
                bonusNumber = LottoAnswerValidator.convertStringToNumber(Console.readLine());
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
                isValid = true;
            }
        }
        return bonusNumber;
    }

    private static List<Integer> makeAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> answerNumbers = null;
        boolean isValid = false;
        while (!isValid) {
            try{
                isValid = false;
                answerNumbers = LottoAnswerValidator.checkIsValidLottoNumbers(Console.readLine());
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
                isValid = true;
            }
        }
        return answerNumbers;
    }

    private static List<Lotto> purchaseLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        boolean isValid = false;
        LottoSalesManager lottoSalesManager = null;
        while (!isValid) {
            try{
                isValid = false;
                lottoSalesManager = new LottoSalesManager(Console.readLine());
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
                isValid = true;
            }
        }
        return lottoSalesManager.makeLottos();
    }
}
