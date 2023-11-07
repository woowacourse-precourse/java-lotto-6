/**
 * @Package_name   : view
 * @Class_name     : LottoController
 * <p>
 * Create Date : 2023-11-07
 * Create User : 정은채
 */
package controller;

import model.Lotto;
import model.LottoNumberPicker;
import model.LottoTicketSeller;
import view.InputView;
import view.OutputView;

public class LottoController {
    /**
     * Description : 로또 로직 컨트롤러
     *
     * @Method : controlLotto()
     */
    public void controlLotto(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printLottoBuy();
        int money = inputView.inputLottoBuy();

        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(money);
        int lottoTicketNum = lottoTicketSeller.receiveLottotickets();

        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        while(lottoTicketNum-- > 0){
            Lotto lotto = new Lotto(lottoNumberPicker.lottoNumberPick());
            //로또셋들 저장(LottoNumberSetHolder) (
        }

    }
}
