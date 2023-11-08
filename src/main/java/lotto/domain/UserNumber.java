//package lotto.domain;
//
//import static lotto.view.InputView.inputBonusNumber;
//import static lotto.view.InputView.inputLottoNumber;
//import static lotto.view.InputView.inputUserNumber;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import lotto.Lotto;
//
//public class UserNumber {
//    public static List<Integer> userLotto = new ArrayList<>();
//    public static int bonus = 0;
//    public static List<Integer> userNumber(){
//        List<String> stringLotto = Arrays.asList(inputUserNumber().split(","));
//        for (int i = 0; i < stringLotto.size(); i++) {
//            userLotto.add(Integer.parseInt(stringLotto.get(i)));
//        }
//        Lotto.validateLottoNumber(userLotto);
//        return userLotto;
//    }
//
//    public static void bonusNumber(){
//        bonus =  inputBonusNumber();
//        bonusValidation(bonus);
//    }
//    public static void setBonus(){
//        try{
//            bonusNumber();
//        }catch (IllegalArgumentException e){
//            System.out.println("[ERROR] 로또 번호의 범위는 1~45 사이 입니다.");
//            bonusNumber();
//        }
//    }
//
//    public static void bonusValidation(int number) throws IllegalArgumentException{
//        if(number > 45 || number < 1){
//            throw new IllegalArgumentException();
//        }
//    }
//
//
//
////    private static void userNumberValidate(){
////        try{
////            userNumber();
////        }catch(IllegalArgumentException e){
////            userNumber();
////        }
////    }
//
//}
