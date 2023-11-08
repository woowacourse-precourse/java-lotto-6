package lotto;

import Validator.LottoValidator;

public class LottoGame {

    public LottoGame(){
    }

    public void startProcess() {

        Integer money = setMoney();
        Lottos lottos = setLottos(money);
        Lotto winnigNumbers = setWinningNumber();
        Integer bonusNumber = setBonusNumber(winnigNumbers);

        LottoResultWinners lottoResultWinners = findWinner(lottos, winnigNumbers, bonusNumber);
        TotalPrizeMoney totalPrizeMoney = TotalPrizeMoney.findTotalPrizeMoney(lottoResultWinners);
        Double earningRate = totalPrizeMoney.getEarningRate(money);
        GuideMessage.ofLottoWinnerResult(lottoResultWinners, earningRate);
    }

    private Integer setMoney() {
        Integer money = null;
        while (money == null) {
            GuideMessage.ofInputMoney();
            money = GameInput.insertMoney();
        }
        return money;
    }

    private Lottos setLottos(Integer money) {
        Lottos lottos = Lottos.issueLottos(money);
        Integer issueNumber = lottos.getSize();
        GuideMessage.ofIssuedLottos(lottos, issueNumber);
        return lottos;
    }

    private Lotto setWinningNumber() {
        GuideMessage.ofInputWinningNumber();
        Lotto winnigNumbers = GameInput.insertWinnigNumbers();
        return winnigNumbers;
    }

    private Integer setBonusNumber(Lotto winnigNumbers) {
        GuideMessage.ofInputBounsNumber();
        Integer bonusNumber = GameInput.insertBonusNumber();
        LottoValidator.checkWinnerAndBonusDuplicatedNumber(winnigNumbers,bonusNumber);

        return bonusNumber;
    }

    private LottoResultWinners findWinner(Lottos lottos, Lotto winnigNumbers, Integer bonusNumber) {
        LottoResultWinners lottoResultWinners =
                LottoResultWinners.findWinnerOfLotto(lottos, winnigNumbers, bonusNumber);
        return lottoResultWinners;
    }


}
