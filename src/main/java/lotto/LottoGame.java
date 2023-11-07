package lotto;

import Validator.LottoValidator;

public class LottoGame {

    public LottoGame(){
    }

    public void startProcess() {

        // money input
        Integer money = null;
        while (money == null) {
            GuideMessage.ofInputMoney();
            money = GameInput.insertMoney();
        }

        // create lottos
        Lottos lottos = Lottos.issueLottos(money);
        Integer issueNumber = lottos.getSize();
        GuideMessage.ofIssuedLottos(lottos, issueNumber);

        // input winner number
        GuideMessage.ofInputWinningNumber();
        Lotto winnigNumbers = GameInput.insertWinnigNumbers();

        // input bonus number
        GuideMessage.ofInputBounsNumber();
        Integer bonusNumber = GameInput.insertBonusNumber();

        // check duplicated number between winning and bonus
        LottoValidator.checkWinnerAndBonusDuplicatedNumber(winnigNumbers,bonusNumber);

        // find result
        LottoResultWinners lottoResultWinners =
                LottoResultWinners.findWinnerOfLotto(lottos, winnigNumbers, bonusNumber);
        TotalPrizeMoney totalPrizeMoney = TotalPrizeMoney.findTotalPrizeMoney(lottoResultWinners);
        Double earningRate = totalPrizeMoney.getEarningRate(money);

        // print result
        GuideMessage.ofLottoWinnerResult(lottoResultWinners, earningRate);

    }

}
