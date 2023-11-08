package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private GameService gameService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void startGame() {
        String rawInput = inputView.requestInputLottoMoney();
        int lottoMoney = convertRawInputLottoMoneyToInt(rawInput);

        gameService.initGame(lottoMoney);

        outputView.printLottoCount(gameService.getLottoCount());
        outputView.printWinningLottos(gameService.getWinningLottos());
    }

    public void playGame() {
        String rawInputLottoNumbers = inputView.requestInputLottoNumbers();
        Lotto playerLotto = convertRawInputLottoNumbersToLotto(rawInputLottoNumbers);
        gameService.setPlayerLotto(playerLotto);

        String rawInputBonusNumber = inputView.requestInputBonusNumber();
        int bonusNumber = convertRawInputBonusNumberToInt(rawInputBonusNumber, playerLotto);
        gameService.setBonusNumber(bonusNumber);

        gameService.comparePlayerLottoWithWinningLottos();
    }

    public void endGame() {
        Map<Rank, Integer> rankCountMap = gameService.getRankCountMap();
        outputView.printWinningStatistics(rankCountMap);

        double profitRate = gameService.calculateProfitRate();
        outputView.printProfitRate(profitRate);
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
            System.out.println("숫자가 아닙니다.");
        }
        // 1000보다 작은지 검증
        if(lottoMoney < 1000) {
            throw new IllegalArgumentException("1000이상 숫자를 입력해주세요.");
        }
        // 1000원 단위인지 검증
        if(lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
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
                System.out.println("숫자가 아닙니다.");
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
            System.out.println("숫자가 아닙니다.");
        }
        // 1~45 사이의 숫자인지 검증
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1~45 사이의 숫자를 입력해주세요.");
        }
        // 로또 번호와 중복되는지 검증
        if(playerLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 중복되는 숫자입니다.");
        }
    }
}
