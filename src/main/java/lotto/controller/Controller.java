package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.IssuedLottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.LottoService;
import lotto.view.View;
import util.string.StringUtils;
import util.string.validator.InputValidator;

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
        int bonusNumber = getInputBonusNumber(winningLotto.getNumbers());

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

    private int getInputBonusNumber(List<Integer> numbers) {
        String inputBonusNumber;
        while (true) {
            view.printRequestBonusNumber();
            inputBonusNumber = readInput();
            try {
                InputValidator.checkBonusInput(inputBonusNumber, numbers);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return StringUtils.parseStringToInt(inputBonusNumber);
    }

    private int getUserInputPrice() {
        String inputPrice;
        while (true) {
            view.printRequestPriceMessage();
            inputPrice = readInput();
            try {
                InputValidator.checkPriceInput(inputPrice);
                lottoService.getNumberOfLottoToBeIssued(StringUtils.parseStringToInt(inputPrice));
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return StringUtils.parseStringToInt(inputPrice);
    }

    private List<Integer> getWinningLottonumbers() {
        String inputWinningLotto;

        while (true) {
            view.printRequestWinningNumbers();
            inputWinningLotto = readInput();
            try {
                InputValidator.checkWinningLottoInput(inputWinningLotto);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        return StringUtils.parseLottoNumber(inputWinningLotto);
    }

    private String readInput() {
        return Console.readLine();
    }
}
