package lotto.domain;

import lotto.function.Parser;
import lotto.function.UIFunction;

import java.util.List;

public class User {
    public User() {}

    /**
     * 사용자에게 구입 금액을 입력받고,
     * Market을 통해 로또를 발행한다.
     * @return 로또 리스트
     */
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

    /**
     * 사용자에게 로또 번호와 보너스 번호를 입력 받아서,
     * 당첨 로또 객체를 생성하여 반환한다.
     * @return 당첨 로또
     */
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