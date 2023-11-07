package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.RandomNumbers;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private static int amount;
    private static Lotto winningLotto;
    private static int bonusNumber;

    List<Lotto> lottos = new ArrayList<>();

    public void start() {
        getLottoAmount();
        getLottos();
        getWinningLotto();
    }

    private List<Lotto> getLottos(){
        RandomNumbers randomNumbers = new RandomNumbers();
        for (int i = 0; i < amount; i++) {
            lottos.add((Lotto) randomNumbers.getRandomNumbers());
        }
        return lottos;
    }

    //amount 입력 받아서 모델에서 validation 처리 -> amount 모델 생성
    public void getLottoAmount() {
        LottoAmount lottoAmount = new LottoAmount(InputView.purchaseAmount());
        amount = lottoAmount.getAmount();
    }

    //winning 입력 받아서 모델에서 validation 처리 -> Lotto에서
    public void getWinningLotto() {
        Lotto lotto = new Lotto(lottoStringtoIntegerList());
        winningLotto = lotto;
    }

    private List<Integer> lottoStringtoIntegerList() {
        Lotto lotto = new Lotto(InputView.winningNumber());
        return lotto.getNumbers();
    }

    //bonusNumber 입력 받아서 모델에서 validation 처리 -> bonusNum 모델 생성?

    //amount 값만큼 랜덤 로또 생성, lottos에 저장

    //각 로또가 몇개 맞았는지 확인, lottos, amount, winningNumbers, bonusNumber 등등 활용,
    //모델 생성(로또 결과 모델)해서 각 로또가 몇개 맞혔는지 보너스는 맞혔는지 확인하고 map에 넣기
    //수익률 출력 -> 당첨금/로또 구입금
}
