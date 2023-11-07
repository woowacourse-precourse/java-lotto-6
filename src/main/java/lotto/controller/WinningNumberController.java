package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Errors;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.List;

public class WinningNumberController {
    private LottoView lottoView = new LottoView();
    private LottoService lottoService = new LottoService();

    public Lotto runWinningNumber(){
        return processWinningNumber();
    }

    public Lotto processWinningNumber(){
        while(true) {
            try {
                Lotto lotto = new Lotto(getWinningNumber());
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber(){
        List<Integer> winningNumber;
        lottoView.printInputWinningNumber();
        try{
            winningNumber = lottoService.splitWinningNumber(Console.readLine());
            return winningNumber;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(Errors.WINNIG_NUMBER_NOT_INTEGER.getErrorMessage());
        }
    }

}
