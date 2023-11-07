package lotto.controller;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

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

    public void playGame() {

    }

    public void endGame() {

    }
}
