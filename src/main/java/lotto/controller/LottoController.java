package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private static EnumMap<Prize, Integer> prizeMap = new EnumMap<Prize, Integer>(Prize.class);
    public PurchaseAmount payMoney() {
        int money = 0;
        try {
            money = InputView.inputPurchaseAmount();
            return new PurchaseAmount(money);
        } catch(IllegalArgumentException e) {
            System.out.println("");
            return payMoney();
        }

    }

    public WinningLotto selectWinningLottoNumbers() {
        try {
            List<Integer> winningSixNumbers = InputView.inputWinnerNumbers();
            int winningBonusNumbers = InputView.inputBonusNumbers();
            return new WinningLotto(new Lotto(winningSixNumbers), winningBonusNumbers);
        } catch(IllegalArgumentException e) {
            System.out.println("");
            return selectWinningLottoNumbers();
        }
    }

    public List<Lotto> issueLottoList(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = purchaseAmount.getLottoCount();
        OutputView.outputLottoCount(lottoCount);
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto();
            OutputView.outputIssuedLotto(lotto);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public EnumMap<Prize, Integer> compareWithWinningNum(List<Lotto> lottoList, WinningLotto winningLotto) {
        boolean isEqualWithBonus = false;
        for (int i=0; i<lottoList.size(); i++) {
            int equalCount = lottoList.get(i).compareWithLotto(winningLotto);

            if (equalCount == 5) {
                isEqualWithBonus = lottoList.get(i).compareWithBonusNum(winningLotto);
            }
            Prize prize = Prize.rankLotto(equalCount, isEqualWithBonus);
            prizeMap.put(prize, prizeMap.getOrDefault(prize, 0)+1);
        }
        return prizeMap;
    }




}
