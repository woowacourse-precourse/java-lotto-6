package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.CompareLottoToPrizeNumber.printPrizeText;
import static lotto.CompareLottoToPrizeNumber.winLottoToPrizeNumber;
import static lotto.Input.*;
import static lotto.RandomLottoNumber.randLottoNumbers;
import static lotto.SeparationNumber.separatePrizeNumber;

public class Application {
    public static void main(String[] args) {
        int purchaseInputMoney = getValidPurchaseInput(); // 올바른 구매 금액을 입력했는지 확인하고 올바르지 않으면 재입력한다

        ArrayList<List<Integer>> totalLotto = randLottoNumbers(purchaseInputMoney/1000); // 무작위로 생성한 로또를 이중 배열에 담는다

        String prizeNumber = getValidPrizeNumber(); // 올바른 당첨 번호를 입력했는지 확인하고 올바르지 않으면 재입력한다
        ArrayList<Integer> prizeNumberArray = separatePrizeNumber(prizeNumber); // 입력 값을 분리하여 배열에 담는다

        String bonusNumber = getValidBonusNumber(prizeNumberArray); // 올바른 보너스 번호를 입력했는지 확인하고 올바르지 않으면 재입력한다

        HashMap<Integer, Integer> winHashTable = winLottoToPrizeNumber(prizeNumberArray, totalLotto, Integer.parseInt(bonusNumber)); // 로또와 당첨 번호가 일치하는지 확인하기 위해 해시테이블 생성

        printPrizeText(winHashTable); // 결과를 출력한다
    }
}
