package lotto.controller;

import lotto.CommonLotto;
import lotto.domain.LottoGame;
import lotto.view.LottoInput;
import lotto.domain.LottoResults;
import lotto.view.LottoView;
import lotto.domain.Validate;

public class LottoController {
    public static void LottoStart() {
        LottoView.msgLottoPrice();
        int lottoCount = calcLottoCount(inputLottoPrice());
        LottoView.msgLottoCount(lottoCount);
        LottoGame lottoGame = new LottoGame(lottoCount);

        LottoView.msgLottoNum(lottoGame);
        LottoView.msgLottoWinningNum();
        inputWinningNum(lottoGame);
        LottoView.msgBonusNum();
        inputBonusNum(lottoGame);
        LottoView.msgWinningStatistics();
        LottoResults lottoResults = new LottoResults(lottoGame);
        lottoResults.lottoResult();
    }


    public static int inputLottoPrice() {
        while (true) {
            try {
                return LottoInput.inputLottoPrice();
            } catch (IllegalArgumentException error) {
                errorHandling(error);
            }
        }
    }

    public static void inputWinningNum(LottoGame lottoGame) {
        while (true) {
            try {
                lottoGame.setWinningNum(LottoInput.inputWinningNum());
                break;
            } catch (IllegalArgumentException error) {
                errorHandling(error);
            }
        }
    }

    public static void inputBonusNum(LottoGame lottoGame) {
        while (true) {
            try {
                int bonusNum = LottoInput.inputBonusNum();
                Validate.validateBonusNum(bonusNum,lottoGame.winningNum);
                lottoGame.setBonusNum(bonusNum);
                break;
            }catch (IllegalArgumentException error){
                errorHandling(error);
            }
        }
    }

    private static void errorHandling(IllegalArgumentException ex){
        ex.getMessage();
        ex.printStackTrace();
    }

    public static int calcLottoCount(int price) {
        return price / CommonLotto.LOTTO_PRICE;
    }
}
