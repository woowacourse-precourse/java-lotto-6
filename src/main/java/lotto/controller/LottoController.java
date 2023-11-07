package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static int amount;
    private static Lotto winningLotto;
    private static int bonusNumber;

    List<Lotto> lottos = new ArrayList<>();

    public void start() {
        getLottoAmount();
        getLottos();
//        getWinningLotto();
        System.out.println(getWinningLotto().getNumbers());
//        getBonusNumber();
        System.out.println(getBonusNumber());
    }

    //amount 값만큼 랜덤 로또 생성, lottos에 저장
    private List<Lotto> getLottos() {
        RandomNumbers randomNumbers = new RandomNumbers();
//        Lotto lotto = new Lotto();
        for (int i = 0; i < amount / 1000; i++) {
            Lotto lotto = new Lotto(randomNumbers.getRandomNumbers());
            lottos.add(lotto);
        }
        OutputView.IssuedLottoNumbers(amount, lottos);
        return lottos;
    }

    //amount 입력 받아서 모델에서 validation 처리 -> amount 모델 생성
    private void getLottoAmount() {
        LottoAmount lottoAmount = new LottoAmount(InputView.purchaseAmount());
        amount = lottoAmount.getAmount();
    }

    private Lotto getWinningLotto() {
        Lotto lotto = new Lotto(lottoStringtoIntegerList());
        winningLotto = lotto;
        return winningLotto;
    }

    private List<Integer> lottoStringtoIntegerList() {
        Lotto lotto = new Lotto(InputView.winningNumber());
        return lotto.getNumbers();
    }

    private int getBonusNumber() {
        BonusNumber bonus = new BonusNumber(InputView.bonusNumber(), winningLotto.getNumbers());
        bonusNumber = bonus.getBonusNumber();
        return bonusNumber;
    }

    //각 로또가 몇개 맞았는지 확인, lottos, amount, winningNumbers, bonusNumber 등등 활용,
    //모델 생성(로또 결과 모델)해서 각 로또가 몇개 맞혔는지 보너스는 맞혔는지 확인하고 map에 넣기
    //수익률 출력 -> 당첨금/로또 구입금
    private void getLottoResults(){
//        HashMap<List<String>, Integer> hashMap = new HashMap<>();
//        hashMap.put();

        LottoResult lottoResults = new LottoResult();
    }
    //String인 result 객체를 여러 개 모아서 List<Result>로 할까?
    //각 Result.get당첨금액을 다 더해서 /amount



}
