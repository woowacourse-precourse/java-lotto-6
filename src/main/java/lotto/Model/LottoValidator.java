//package lotto.Model;
//
//import lotto.Constants;
//
//import java.util.List;
//
//import static lotto.Controller.InputController.*;
//
//public class LottoValidator {
//    private final int LOTTO_COUNT;
//    public LottoValidator(){
//        this.LOTTO_COUNT = setLottoCount();
//        validate();
//    }
//    public void validate() {
//        isRightDivision();
//    }
//
//    public void isRightDivision() {
//        if(LOTTO_COUNT % Constants.PRICE_OF_LOTTO != 0) {
//            throw new IllegalArgumentException();
//        }
//    }
//}
