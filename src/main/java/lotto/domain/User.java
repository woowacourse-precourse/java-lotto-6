package lotto.domain;

import lotto.function.Parser;
import lotto.function.UIFunction;

import java.util.List;

public class User {
    public User() {}

    public List<Lotto> buyLotto() {
        try {
            String inputPayment = UIFunction.requestInput("구입 금액을 입력해 주세요.");
            int payment = Parser.toInteger(inputPayment);
            return new Market().issueLotto(payment);
        } catch (IllegalArgumentException e) {
            UIFunction.showErrorMessage(e);
            return buyLotto();
        }
    }

    public LottoWinningNumber createWinningLottoNumber() {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
        createLotto(lottoWinningNumber);
        createBonusNumber(lottoWinningNumber);
        return lottoWinningNumber;
    }

    private void createLotto(LottoWinningNumber lottoWinningNumber) {
        try {
            String inputLottoNumbers = UIFunction.requestInput("당첨 번호를 입력해 주세요.");
            List<Integer> numbers = Parser.toIntegerList(inputLottoNumbers);
            lottoWinningNumber.setLotto(new Lotto(numbers));
        } catch (IllegalArgumentException e) {
            UIFunction.showErrorMessage(e);
            createLotto(lottoWinningNumber);
        }
    }

    private void createBonusNumber(LottoWinningNumber lottoWinningNumber) {
        try {
            String inputBonusNumber = UIFunction.requestInput("보너스 번호를 입력해 주세요");
            int bonusNumber = Parser.toInteger(inputBonusNumber);
            lottoWinningNumber.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            UIFunction.showErrorMessage(e);
            createBonusNumber(lottoWinningNumber);
        }
    }
}