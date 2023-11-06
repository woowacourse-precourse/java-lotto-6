package lotto.controller;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static int amount;
    private static Lotto winningNumbers;
    private static int bonusNumber;

    List<Lotto> lottos = new ArrayList<>();
    //amount 입력 받아서 모델에서 validation 처리 -> amount 모델 생성
    //winning 입력 받아서 모델에서 validation 처리 -> Lotto에서
    //bonusNumber 입력 받아서 모델에서 validation 처리 -> bonusNum 모델 생성?

    //amount 값만큼 랜덤 로또 생성, lottos에 저장

    //각 로또가 몇개 맞았는지 확인, lottos, amount, winningNumbers, bonusNumber 등등 활용,
    //모델 생성(로또 결과 모델)해서 각 로또가 몇개 맞혔는지 보너스는 맞혔는지 확인하고 map에 넣기
    //수익률 출력 -> 당첨금/로또 구입금
}
