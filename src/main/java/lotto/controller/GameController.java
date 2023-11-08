package lotto.controller;

import lotto.domain.Error;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.GameService;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        int lottoMoney;

        while(true){
            String rawInput = InputView.requestInputLottoMoney();
            try {
                lottoMoney = convertRawInputLottoMoneyToInt(rawInput);
                break;
            } catch (Exception e) {
                ExceptionView.printErrorMessage(e.getMessage());
            }
        }

        gameService.initGame(lottoMoney);
        OutputView.printLottoCount(gameService.getLottoCount());
        OutputView.printWinningLottos(gameService.getWinningLottos());
    }

    public void playGame() {
        Lotto playerLotto;
        int bonusNumber;

        while(true){
            String rawInputLottoNumbers = InputView.requestInputLottoNumbers();
            try {
                playerLotto = convertRawInputLottoNumbersToLotto(rawInputLottoNumbers);
                break;
            } catch (Exception e) {
                ExceptionView.printErrorMessage(e.getMessage());
            }
        }
        gameService.setPlayerLotto(playerLotto);

        while(true){
            String rawInputBonusNumber = InputView.requestInputBonusNumber();
            try {
                bonusNumber = convertRawInputBonusNumberToInt(rawInputBonusNumber, playerLotto);
                break;
            } catch (Exception e) {
                ExceptionView.printErrorMessage(e.getMessage());
            }
        }
        gameService.setBonusNumber(bonusNumber);

        gameService.comparePlayerLottoWithWinningLottos();
    }

    public void endGame() {
        Map<Rank, Integer> rankCountMap = gameService.getRankCountMap();
        OutputView.printWinningStatistics(rankCountMap);

        double profitRate = gameService.calculateProfitRate();
        OutputView.printProfitRate(profitRate);
    }

    private int convertRawInputLottoMoneyToInt(String rawInput) {
        validateRawInputLottoMoney(rawInput);
        return Integer.parseInt(rawInput);
    }

    private void validateRawInputLottoMoney(String rawInput) {
        int lottoMoney = 0;

        // 숫자인지 검증
        try{
            lottoMoney = Integer.parseInt(rawInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_INPUT);
        }
        // 1000보다 작은지 검증
        if(lottoMoney < 1000) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_MONEY);
        }
        // 1000원 단위인지 검증
        if(lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_MONEY_UNIT);
        }
    }

    private Lotto convertRawInputLottoNumbersToLotto(String rawInput) {
        List<Integer> lottoNumbers = validateRawInputLottoNumbers(rawInput);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> validateRawInputLottoNumbers(String rawInput) {
        String[] splitedRawInput = rawInput.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();

        // 숫자인지 검증
        for(String number : splitedRawInput) {
            try{
                lottoNumbers.add(Integer.parseInt(number));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(Error.INVALID_NUMBER_INPUT);
            }
        }

        return lottoNumbers;
    }

    private Integer convertRawInputBonusNumberToInt(String rawInput, Lotto playerLotto) {
        validateRawInputBonusNumber(rawInput, playerLotto);
        return Integer.parseInt(rawInput);
    }

    private void validateRawInputBonusNumber(String rawInput, Lotto playerLotto) {
        int bonusNumber = 0;

        // 숫자인지 검증
        try{
            bonusNumber = Integer.parseInt(rawInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_INPUT);
        }
        // 1~45 사이의 숫자인지 검증
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Error.INVALID_LOTTO_NUMBER_RANGE);
        }
        // 로또 번호와 중복되는지 검증
        if(playerLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.DUPLICATE_LOTTO_NUMBER);
        }
    }
}
