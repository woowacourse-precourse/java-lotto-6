package lotto.controller;

import static lotto.validator.BonusNumberValidator.checkBonusNumberRangeAndThrowException;
import static lotto.validator.BonusNumberValidator.checkWinningLottoWinningBonusDuplicatedAndThrowException;
import static lotto.validator.InputValidator.checkBonusInput;
import static lotto.validator.InputValidator.checkPriceInput;
import static lotto.validator.InputValidator.checkWinningLottoInput;
import static lotto.validator.PriceValidator.validatePrice;
import static util.string.StringUtils.parseLottoNumber;
import static util.string.StringUtils.parseStringToInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.IssuedLottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.LottoService;
import lotto.view.View;

public class Controller {

    LottoService lottoService;
    View view;

    public Controller(LottoService lottoService, View view) {
        this.lottoService = lottoService;
        this.view = view;
    }

    public void play() {
        int userPrice = getUserInputPrice();
        List<Lotto> lottos = issueLotto(userPrice);

        Lotto winningLotto = getWinningLotto(getWinningLottonumbers());
        int bonusNumber = getInputBonusNumber(winningLotto);

        WinningStatisticsDto result = lottoService.getWinningStatistics(lottos, winningLotto, bonusNumber);
        view.printWinningStatistics(result);
    }

    private Lotto getWinningLotto(List<Integer> winningLottonumbers) {
        Lotto winningLotto;
        while (true) {
            try {
                winningLotto = new Lotto(winningLottonumbers);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                winningLottonumbers = getWinningLottonumbers();
            }
        }
        return winningLotto;
    }

    private List<Lotto> issueLotto(int userPrice) {
        List<Lotto> lottos = lottoService.issueNewLotto(userPrice);
        view.printNumberOfPurchasedLotto(lottoService.getNumberOfLottoToBeIssued(userPrice));
        view.printIssuedLottoNumbers(parseLottoToDto(lottos));
        return lottos;
    }

    private List<IssuedLottoDto> parseLottoToDto(List<Lotto> lottos) {
        return lottos.stream()
                .map(i -> new IssuedLottoDto(i.getNumbers()))
                .toList();
    }

    private int getInputBonusNumber(Lotto winningLotto) {
        String inputBonusNumber;
        while (true) {
            view.printRequestBonusNumber();
            inputBonusNumber = readInput();
            try {
                checkBonusNumberValidate(inputBonusNumber, winningLotto);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return parseStringToInt(inputBonusNumber);
    }

    private void checkBonusNumberValidate(String inputBonusNumber, Lotto winningLotto) {
        checkBonusInput(inputBonusNumber);
        int bonusNumber = parseStringToInt(inputBonusNumber);
        checkBonusNumberRangeAndThrowException(bonusNumber);
        checkWinningLottoWinningBonusDuplicatedAndThrowException(winningLotto, bonusNumber);
    }

    private int getUserInputPrice() {
        String inputPrice;
        while (true) {
            view.printRequestPriceMessage();
            inputPrice = readInput();
            try {
                checkPriceValidate(inputPrice);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return parseStringToInt(inputPrice);
    }

    private void checkPriceValidate(String inputPrice) {
        checkPriceInput(inputPrice);
        validatePrice(parseStringToInt(inputPrice));
    }

    private List<Integer> getWinningLottonumbers() {
        String inputWinningLotto;
        while (true) {
            view.printRequestWinningNumbers();
            inputWinningLotto = readInput();
            try {
                checkWinningLottoInput(inputWinningLotto);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        return parseLottoNumber(inputWinningLotto);
    }

    private String readInput() {
        return Console.readLine();
    }
}
