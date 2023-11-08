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
            try {
                GuideMessage.ofInputMoney();
                money = GameInput.insertMoney();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                money = null;
            }
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
        Lotto winningNumbers = null;
        while(winningNumbers == null){
            try {
                GuideMessage.ofInputWinningNumber();
                winningNumbers = GameInput.insertWinnigNumbers();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                winningNumbers = null;
            }
        }
        return winningNumbers;
    }

    private Integer setBonusNumber(Lotto winnigNumbers) {
        Integer bonusNumber = null;
        while (bonusNumber == null) {
            try {
                GuideMessage.ofInputBounsNumber();
                bonusNumber = GameInput.insertBonusNumber();
                LottoValidator.checkWinnerAndBonusDuplicatedNumber(winnigNumbers, bonusNumber);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                bonusNumber = null;
            }

        }
        return bonusNumber;
    }

    private LottoResultWinners findWinner(Lottos lottos, Lotto winnigNumbers, Integer bonusNumber) {
        LottoResultWinners lottoResultWinners =
                Judge.findWinnerOfLotto(lottos, winnigNumbers, bonusNumber);
        return lottoResultWinners;
    }

}
