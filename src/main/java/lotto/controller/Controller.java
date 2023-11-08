package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.dto.IssuedLottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.service.LottoService;
import lotto.view.View;

public class Controller {

    LottoService lottoService;
    View view;
    InputController inputController;

    public Controller(LottoService lottoService, View view) {
        this.lottoService = lottoService;
        this.view = view;
        inputController = new InputController(view);
    }

    public void play() {
        Price price = getPrice();
        List<Lotto> lottos = issueLotto(price.getPrice());

        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        WinningStatisticsDto result = lottoService.getWinningStatistics(lottos, winningLotto,
                bonusNumber.getBonusNumber());
        view.printWinningStatistics(result);
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        BonusNumber bonusNumber;
        int inputBonusNumber = inputController.getInputBonusNumber();
        while (true) {
            try {
                bonusNumber = new BonusNumber(inputBonusNumber);
                checkWinningLottoContainsBonusNumberAndThrowException(winningLotto, bonusNumber);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                inputBonusNumber = inputController.getInputBonusNumber();
            }
        }
        return bonusNumber;
    }

    private Price getPrice() {
        Price price;
        int inputPrice = inputController.getInputPrice();
        while (true) {
            try {
                price = new Price(inputPrice);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                inputPrice = inputController.getInputPrice();
            }
        }
        return price;
    }

    private Lotto getWinningLotto() {
        Lotto winningLotto;
        List<Integer> inputWinningLottoNumbers = inputController.getInputWinningLottoNumbers();
        while (true) {
            try {
                winningLotto = new Lotto(inputWinningLottoNumbers);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                inputWinningLottoNumbers = inputController.getInputWinningLottoNumbers();
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

    private void checkWinningLottoContainsBonusNumberAndThrowException(Lotto winningLotto,
                                                                       BonusNumber bonusNumber)
            throws IllegalArgumentException {
        List<Integer> numbers = winningLotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new DuplicatedLottoNumberException();
        }
    }

    private List<IssuedLottoDto> parseLottoToDto(List<Lotto> lottos) {
        return lottos.stream()
                .map(i -> new IssuedLottoDto(i.getNumbers()))
                .toList();
    }

}
