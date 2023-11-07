package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.enums.ViewMessage;

public class LottoView {

    private final LottoController lottoController;

    public LottoView(LottoController lottoController){
        this.lottoController = lottoController;
    }
    public void raffleLotto(){
        RaffleLottoResponse response = outputRaffleLotto(inputNormalNumber());
        outputAddBonusNumber(response.getLotto(), inputBonusNumber());
    }

    private String inputNormalNumber(){
        System.out.println(ViewMessage.INPUT_LOTTO_NUMBER);
        String input = Console.readLine();
        return input;
    }

    private String inputBonusNumber(){
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER);
        String input  = Console.readLine();
        return input;
    }

    private RaffleLottoResponse outputRaffleLotto(String input){
        RaffleLottoResponse response = lottoController.raffleLotto(input);
        System.out.println(response);
        return response;
    }

    private RaffleLottoResponse outputAddBonusNumber(Lotto lotto, String input){
        RaffleLottoResponse response = lottoController.pickBonusNumber(lotto, input);
        System.out.println(response);
        return response;
    }

}
