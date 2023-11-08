package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
        int payMoney;
        private static List<Integer> lottoNumbers;
        private static List<Lotto> lottos;
        int bonusNumber;

        public void run(){
                buyingLotto();
        }
        private void buyingLotto() {
                OutputView.mentionInputPrice();
                payMoney = InputView.inputMoney();
                LottoPrice lottoPrice = new LottoPrice(payMoney);
                int count = lottoPrice.getLottoCount();
                makeLottos(count);
                OutputView.mentionInputWinningNumber();
                lottoNumbers = InputView.inputLottoNumbers();
                Lotto lotto = new Lotto(lottoNumbers);
                lotto.printNumbers();
                OutputView.mentionInputBonusNumber();
                bonusNumber = InputView.inputBonusNumber();
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
        // lottoPrice.getLottoCount()에 따라 lottos를 생성하는 메서드

}
