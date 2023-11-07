package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoController {
    private static int amount;
    private static Lotto winningLotto;
    private static int bonusNumber;

    List<Lotto> lottos = new ArrayList<>();
//    List<LottoResult> lottoResults = new ArrayList<>();

    public void start() {
        getLottoAmount();
        getLottos();
        getWinningLotto();
        getBonusNumber();
//        System.out.println(getBonusNumber());

        getLottoResults(winningLotto.getNumbers(), lottos, bonusNumber);
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

    //각 로또가 몇개 맞았는지 확인, lottos, winningNumbers, bonusNumber 등등 활용
    //lottos의 lotto 하나가 winningNumber와 중복되는 숫자 개수 찾고
    //만약 중복되는 숫자 개수가 5개라면, 보너스 숫자 맞혔는지 확인
    //알맞은 enum 선택하고 LottoResult의 해쉬 맵에 넣기 -> 출력
    //수익률 출력 -> 당첨금/로또 구입금
    //해쉬 맵 format의 lottoOfMatching * integer 해서 수익금 구하기
    private void getLottoResults(List<Integer> winningNumbers, List<Lotto> lottos, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(o -> winningNumbers.stream().anyMatch(Predicate.isEqual(o)))
                    .count();

            lottoResult.addHashMap(matchCount, isMatchBonus(lotto, bonusNumber));

        }
        //출력

        calculateReturnOnLotto(lottoResult.getLottoResultHashMap());
//        return lottoResult.getLottoResultHashMap();
    }

    private boolean isMatchBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void calculateReturnOnLotto(HashMap<LottoResultFormat, Integer> lottoResults){

//        출력
    }

}
