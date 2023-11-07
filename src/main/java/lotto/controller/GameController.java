package lotto.controller;

import lotto.constant.Message;
import lotto.dto.GameResultDTO;
import lotto.dto.LottoDTO;
import lotto.service.GameService;

import java.util.List;

public class GameController {

    private final GameService gameService = new GameService();

    public void purchaseLotto(String input){

        gameService.purchaseLotto(input);
    }

    public void saveWinningNumbers(String input) {

        gameService.saveWinningNumbers(input);
    }

    public void saveBonusNumber(String input) {

        gameService.saveBonusNumber(input);
    }

    public String getPurchaseAmount() {

        StringBuilder result = new StringBuilder();

        int amount = gameService.getPurchaseAmount();

        result.append(amount).
                append(Message.PURCHASE_AMOUNT_MESSAGE.getMessage());

        return result.toString();
    }

    public String getPurchaseLottos() {

        StringBuilder result = new StringBuilder();

        List<LottoDTO> lottoDTOS = gameService.getPurchaseLottos();

        for(LottoDTO dto : lottoDTOS) {

            result.append(dto.toString()).append("\n");
        }

        return result.toString();
    }

    public String getWinningInfo() {

        StringBuilder result = new StringBuilder();

        GameResultDTO gameResultDTO = gameService.getGameResult();

        result.append(gameResultDTO.toString());

        return result.toString();
    }

    public String getYieldRate() {

        StringBuilder result = new StringBuilder();

        double yieldRate = gameService.getYieldRate();

        result.append("총 수익률은 ").append(yieldRate).append("%입니다.");

        return result.toString();
    }
}
