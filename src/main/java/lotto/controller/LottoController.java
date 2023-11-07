package lotto.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoAmount;

import static lotto.view.InputView.inputPlayerAmount;

public class LottoController {

    private static LottoAmount playerLottoAmount;     //사용자가 구입한 로또 가격치

    private static List<Integer> lotto = new ArrayList<>(); // 사용자의 로또

    private static List<Lotto> lottoList;//로또 객체 리스트

    private static WinningResult winningResult;

    public void start(){
        int ticketCount= inputPlayerAmount();
        OutputView.printTicketCnt(ticketCount);

        lottoList= makeLottoList(ticketCount);
        winningResult= checkBonus();

    }

    public int inputPlayerAmount(){
        playerLottoAmount = new LottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calcLottoNum();
    }
    public WinningResult checkBonus(){
        Lotto lotto= new Lotto(InputView.inputWinningNumbers());
        List<Integer> winningNumber= lotto.getLottoNumbers();
        int ball = InputView. inputBonusNumber();

        lotto.validateBonusNumber(winningNumber, ball);
        winningResult= new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;

    }

    private static List<Lotto> makeLottoList(int ticketCount){
        lottoList= new ArrayList<>();
        for(int i=0; i<ticketCount; i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto(){
        LottoNumbers lottoNumbers = new LottoNumbers();

        lotto = new ArrayList<>();
        lotto= lottoNumbers.setLottoNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);

    }

}
