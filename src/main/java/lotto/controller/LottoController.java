package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class LottoController {
        int payMoney;
        private static List<Integer> lottoNumbers;
        private static List<Lotto> lottos;
        private static CalculateLotto calculateLotto;
        private static LottoPrice lottoPrice;
        int bonusNumber;

        public void run(){
               int count = buyingLotto();
                OutputView.printLottoCount(count);

                makeLottos(count);

                lottoNumbers = InputView.inputLottoNumbers();
                Lotto winLotto = new Lotto(lottoNumbers);

                bonusNumber = InputView.inputBonusNumber();

                calculateLotto = new CalculateLotto(winLotto,bonusNumber);
                resultLottos(lottos,calculateLotto);
        }
        private int buyingLotto() {
                payMoney = InputView.inputMoney();
                LottoPrice lottoPrice = new LottoPrice(payMoney);
                int count = lottoPrice.getLottoCount();
                return count;
        }
        private static List<Lotto> makeLottos(int count){
                lottos = new ArrayList<>();
                for(int i = 0; i< count; i++){
                        lottos.add(makeLotto());
                }
                return lottos;
        }
        private static Lotto makeLotto(){
                LottoGenerator lottoGenerator = new LottoGenerator();
                lottoNumbers = LottoGenerator.startRandom();
                System.out.println(lottoNumbers);
                return new Lotto(lottoNumbers);
        }
        private void resultLottos(List<Lotto> lottos, CalculateLotto calculateLotto){
                Map<WinLotto,Integer> result = setResult();
                WinLotto winLotto;

                for (Lotto lotto : lottos) {
                        winLotto = calculateLotto.match(lotto);
                        result.put(winLotto, result.get(winLotto) + 1);
                }
                printResult(result);
        }
        private Map<WinLotto,Integer> setResult(){
                Map<WinLotto,Integer> result = new LinkedHashMap<>();
                for(WinLotto winLotto: WinLotto.values()){
                        result.put(winLotto,0);
                }
                return result;
        }
        private void printResult(Map<WinLotto, Integer> result){
                OutputView.printResultMessage();
               for(int i = WinLotto.values().length -1; i >=0; i--){
                       WinLotto.values()[i].printMessage(result.get(WinLotto.values()[i]));
               }
        }
        // lottoPrice.getLottoCount()에 따라 lottos를 생성하는 메서드

}
