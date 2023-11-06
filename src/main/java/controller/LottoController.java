package controller;

import view.InputView;

/**
 * packageName    : controller
 * fileName       : LottoController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class LottoController {
    public void playLotto(){
        try {
            purchaseLotto();
        } catch(NumberFormatException e){

        } catch(IllegalArgumentException e){

        }
    }

    private void purchaseLotto(){
        setPurchaseAmount();
    }

    private void setPurchaseAmount(){
        InputView.enterAmount();
    }
}
