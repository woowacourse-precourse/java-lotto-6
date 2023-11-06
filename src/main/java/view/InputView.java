package view;

public class InputView {

    public void showInputPriceToUser() {
        System.out.println(InputMessage.INPUT_PRICE.getMsg());
    }

    public void showInputLottoNumberToUser(){
        System.out.println(InputMessage.INPUT_LOTTO_NUMBER.getMsg());
    }

    public void showInputBonusNumberToUser(){
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMsg());
    }
}
