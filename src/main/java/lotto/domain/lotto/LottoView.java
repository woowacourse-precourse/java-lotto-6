package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.user.User;
import lotto.global.enums.ViewMessage;

public class LottoView {

    private final LottoController lottoController;

    public LottoView(LottoController lottoController){
        this.lottoController = lottoController;
    }

    public void runLotto(final User user){
        RaffleLottoResponse response = outputRaffleLotto(inputNormalNumber());
        Lotto raffledLotto = response.getLotto();
        outputAddBonusNumber(raffledLotto, inputBonusNumber());
        outputLottoStats(user, raffledLotto);
    }

    private String inputNormalNumber(){
        System.out.println(ViewMessage.INPUT_LOTTO_NUMBER);
        String input = Console.readLine();
        return input;
    }

    private String inputBonusNumber(){
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return input;
    }

    private RaffleLottoResponse outputRaffleLotto(final String input){
        RaffleLottoResponse response = lottoController.raffleLotto(input);
        System.out.println(response);
        return response;
    }

    private void outputAddBonusNumber(final Lotto lotto, final String input){
        RaffleLottoResponse response = lottoController.pickBonusNumber(lotto, input);
        System.out.println(response);
    }

    private void outputLottoStats(final User user, final Lotto raffledLotto){
        System.out.println(ViewMessage.OUTPUT_WIN_STATS);
        List<LottoResultResponse> responses = lottoController.getLottoStatistics(user, raffledLotto);
        responses.forEach(System.out::println);
    }

    private void outputRateOfReturn(final User user){
        System.out.println(user.getRateOfReturn());
    }

}
