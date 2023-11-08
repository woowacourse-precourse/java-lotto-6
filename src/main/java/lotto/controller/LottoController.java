package lotto.controller;

import static lotto.util.Introduction.INPUT_AMOUNT_OF_LOTTO;
import static lotto.util.Introduction.INPUT_BONUS_NUMBER;
import static lotto.util.Introduction.INPUT_WINNING_NUMBERS;

import java.util.Comparator;
import java.util.List;
import lotto.model.data.Lotto;
import lotto.model.data.WinningPortfolio;
import lotto.model.generator.LottoNumberGenerator;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 전체적인 로또 게임 흐름을 관리하는 컨트롤러 클래스다.
 * input을 받고, output을 출력하며 view와 Model/Service 사이를 통신한다.
 */
public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;

    /**
     * {@code LottoConotroller} 인스턴스를 생성하는 private 생성자이다.
     *
     * @param inputView 유저의 input을 관리하기 위한 input view
     * @param outputView 정보와 결과를 출력하는 output view
     */
    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        lottoService = new LottoService();
    }

    /**
     * {@code LottoController} 인스턴스를 생성하는 정적 팩토리 메소드다.
     *
     * @param inputView 유저의 input을 관리하기 위한 input view
     * @param outputView 정보와 결과를 출력하는 output view
     * @return {@code LottoController}의 새 인스턴스
     */
    public static LottoController of(InputView inputView, OutputView outputView) {
        return new LottoController(inputView, outputView);
    }

    /**
     * 로또 구입 금액을 입력받고, 로또를 구입하고, 당첨 내역을 계산하는 전체적인 로또 게임 흐름을 지휘한다.
     *
     * @param lottoNumberGenerator 로또 번호 generator
     * @param order 로또 번호의 정렬 기준을 정의하는 comparator
     */
    public void runLottoStore(LottoNumberGenerator lottoNumberGenerator, Comparator<Integer> order) {
        payMoney(lottoNumberGenerator, order);
        drawNumber();
        printWinning();
    }

    private void payMoney(LottoNumberGenerator lottoNumberGenerator, Comparator<Integer> order) {
        while (true) {
            try {
                Integer numberOfLotto = getNumberOfLotto();
                createLottos(numberOfLotto, lottoNumberGenerator, order);

                break;
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private void drawNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber(winningNumbers);

        lottoService.createAnswerNumbers(winningNumbers, bonusNumber);
    }

    private void printWinning() {
        WinningPortfolio winningPortfolio = lottoService.evaluateWinnings();
        outputView.printWinningStatistics(winningPortfolio);
    }

    private Integer getNumberOfLotto() {
        outputView.printIntroduction(INPUT_AMOUNT_OF_LOTTO.getIntroduction());
        int amountOfInvestment = lottoService.validateAndConvertInvestmentAmount(inputView.inputConstant());

        return lottoService.calculateNumberOfLottos(amountOfInvestment);
    }

    private void createLottos(Integer numberOfLotto, LottoNumberGenerator lottoNumberGenerator,
                              Comparator<Integer> order) {
        List<Lotto> purchasedLottos = lottoService.purchaseLottos(numberOfLotto, lottoNumberGenerator, order);
        outputView.printLottos(purchasedLottos);
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                outputView.printIntroduction(INPUT_WINNING_NUMBERS.getIntroduction());

                return lottoService.validateAndConvertWinningNumbers(inputView.inputList());
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                outputView.printIntroduction(INPUT_BONUS_NUMBER.getIntroduction());

                return lottoService.validateAndConvertBonusNumber(inputView.inputConstant(), winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }
}
