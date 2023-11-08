package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Amount;
import lotto.model.BonusNumber;
import lotto.model.InputParser;
import lotto.model.Lotto;
import lotto.model.LottoNumbersGenerator;
import lotto.model.Lottos;
import lotto.model.ResultCalculator;
import lotto.model.StringToIntegerConvertor;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Amount amount = getValidAmount();
        Lottos lottos = createLottos(amount);
        WinLotto winLotto = getValidWinLotto();
        printResult(winLotto, lottos);
    }

    // IllegalArgumentException 발생 시 해당 메소드 반복
    private <T> T getValidInput(Supplier<T> method) {
        while (true) {
            try {
                return method.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 정상 값 입력될 때 까지 구매 금액 입력
    private Amount getValidAmount() {
        return getValidInput(() -> new Amount(InputView.requestAmount()));
    }


    // 입력 받은 금액에 해당하는 로또 생성
    private Lottos createLottos(Amount amount) {
        List<Lotto> autoLottos = generateAutoLottos(amount);
        Lottos lottos = new Lottos(autoLottos);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private List<Lotto> generateAutoLottos(Amount amount) {
        int count = amount.calculateCount();
        OutputView.printCount(count);
        return new LottoNumbersGenerator().generateLottos(count);
    }


    // 정상 WinLotto 생성 까지 WinLotto 생성
    private WinLotto getValidWinLotto() {
        return getValidInput(this::createWinLotto);
    }

    // 우승 로또 생성
    private WinLotto createWinLotto() {
        Lotto winNumbers = getValidInput(this::inputWinNumbers);
        BonusNumber bonusNumber = getValidInput(this::inputBonusNumber);
        return new WinLotto(winNumbers, bonusNumber);
    }

    // 우승 번호 입력 및 반환
    private Lotto inputWinNumbers() {
        String inputNumbers = InputView.requestWinningNumbers();
        List<String> parsedNumbers = InputParser.parseInput(inputNumbers);
        List<Integer> parsedIntegerNumbers = StringToIntegerConvertor.stringToInteger(parsedNumbers);
        return new Lotto(parsedIntegerNumbers);
    }

    // 보너스 번호 입력 및 반환
    private BonusNumber inputBonusNumber() {
        String inputNumber = InputView.requestBonusNumber();
        int bonusInput = StringToIntegerConvertor.stringToInteger(inputNumber);
        return new BonusNumber(bonusInput);
    }


    // 최종 결과 출력
    private void printResult(WinLotto winLotto, Lottos lottos) {
        ResultCalculator resultCalculator = new ResultCalculator(winLotto, lottos);
        OutputView.printResult(resultCalculator.calculateResult(),
                resultCalculator.calculateRateOfReturn());
    }
}