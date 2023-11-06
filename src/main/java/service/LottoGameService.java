package service;

import static utils.PrintUtils.errorPrint;
import static utils.PrintUtils.print;
import static utils.PrintUtils.printf;

import camp.nextstep.edu.missionutils.Console;
import constants.LottoGameMessage;
import domain.Lotto;
import domain.LottoGame;
import domain.UserLotto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGameService {
    private UserLotto userLotto;
    private LottoGame lottoGame = new LottoGame();

    public void runLottoGame(){
        purchaseLotto();

        printf(LottoGameMessage.PURCHASED_COUNT.toString(), userLotto.getLottoCount());
        List<Lotto> lottoList = getLottoList(userLotto.getLottoCount());
        lottoList.stream()
                .forEach(lotto -> print(lotto.getNumbers().toString()));

        print(LottoGameMessage.WINNING_NUMBER.toString());
    }
    public List<Lotto> getLottoList(int lottoCount){
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, lottoCount)
                .forEach(i -> {
                    List<Integer> lottoNumbers = lottoGame.createLottoNumbers();
                    lottoList.add(new Lotto(lottoNumbers));
                });
        return lottoList;
    }

    public void purchaseLotto(){
        boolean isAmount = false;
        while(!isAmount){
            print(LottoGameMessage.PURCHASE_AMOUNT.toString());
            isAmount = isGetUserLotto(readInput());
        }
    }

    public boolean isGetUserLotto(String purchasedAmount){
        try{
            userLotto = new UserLotto(purchasedAmount);
        }catch (IllegalArgumentException iae){
            errorPrint(iae.getMessage());
            return false;
        }
        return true;
    }

    private String readInput(){
        return Console.readLine();
    }

}
