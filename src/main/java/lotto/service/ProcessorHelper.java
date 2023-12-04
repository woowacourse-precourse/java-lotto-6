package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessorHelper {

    public LottoArrays createAndPrintLottoNumber(PurchaseInfo purchaseInfo) {
        LottoArrays lottoArrays = createLotto(purchaseInfo);
        for (Lotto lotto : lottoArrays.getLottoList()) {
            System.out.println(lotto.toString());
        }
        return lottoArrays;
    }

    public LottoArrays createLotto(PurchaseInfo purchaseInfo) {
        LottoArrays lottoArrays = new LottoArrays();
        for (int cnt = 0; cnt < purchaseInfo.getPurchaseCount(); cnt++) {
            List<Integer> numbers = pickUniqueRandomNumber();
            Lotto lotto = new Lotto(numbers);
            lottoArrays.addLottoArray(lotto);
        }
        return lottoArrays;
    }

    public List<Integer> pickUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public void judgeAndPrintLottoResult(LottoArrays lottoArrays, NumberInfo numberInfo) {
        LottoResult lottoResult = countMatchNumbers(lottoArrays.getLottoList(), numberInfo);
        printLottoResult(lottoResult.getLottoResultMap());
    }

    public LottoResult countMatchNumbers(List<Lotto> lottoList, NumberInfo numberInfo) {
        LottoResult lottoResult = new LottoResult();
        WinningNumber winningNumber = numberInfo.getWinningNumbersList();
        BonusNumber bonusNumber = numberInfo.getBonusNumber();

        for (Lotto lotto : lottoList) {
            boolean bonus = false;
            int matchCount = (int) lotto.getNumbers().stream().
                    filter(winningNumber.getWinningNumber()::contains).count();
            if(matchCount == 5){
                bonus = judgeBounsNumber(lotto, bonusNumber.getBonusNumber().get(0));
            }
            if(bonus) {
                recordMatchNumbers(lottoResult, 7);
            }
            if(!bonus & matchCount >= 3){
                recordMatchNumbers(lottoResult, matchCount);
            }
        }
        return lottoResult;
    }

    public void recordMatchNumbers(LottoResult lottoResult, int matchCount){
        lottoResult.addLottoResult(matchCount);
    }

    public boolean judgeBounsNumber(Lotto lotto, int bounsNumber){
        if(lotto.getNumbers().stream().anyMatch(num -> num == bounsNumber)){
            return true;
        }
        return false;
    }

    public void printLottoResult(Map<Integer, Integer> lottoResultMap){

//        System.out.println(lottoResultMap.toString());

        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoResultMap.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - "  + lottoResultMap.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResultMap.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResultMap.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "  + lottoResultMap.get(6) + "개");

        int sumWinner = 5000*lottoResultMap.get(3) + 50000*lottoResultMap.get(4) +
                        1500000*lottoResultMap.get(5) + 30000000*lottoResultMap.get(7) +
                        2000000000*lottoResultMap.get(6);

    }
}

