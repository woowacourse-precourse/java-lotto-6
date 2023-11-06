package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        // 로또 구입 금액 입력
        String inputMoney = inputView.readLottoMoney();

        // 로또 구매 수량 출력
        LottoAmount lottoAmount = new LottoAmount(inputMoney);
        outputView.printLottoAmount(lottoAmount);

//        // 수량만큼 로또 생성 후 로또번호 출력
//        for (int i = 0; i < lottoAmount.getLottoAmount(); i++) {
//            generateLotto();
//        }

        // 당첨번호 입력
//        String lottoNumber = inputView.readLottoNumber();

        // 보너스번호 입력
//        String inputBonus = inputView.readBonusNumber();
//        int bonusNumber = Validator.validateBonusNumber(inputBonus);

        // 당첨내역 출력

        // 수익률 출력
    }

//    private void makeLottoNumber(String lottoNumber) {
//        // "1,2,3,4,5,6" -> [1,2,3,4,5,6]
//        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
//
//    }

//    private void generateLotto() {
//        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        Lotto lotto = new Lotto(numbers);
//        printLotto(lotto.getLottoNumber());
//    }
//
//    private void printLotto(List<Integer> numbers) {
//        outputView.printLottoNumber(numbers);
//    }
}
