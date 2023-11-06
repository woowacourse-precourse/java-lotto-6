package lotto.view;



import lotto.domain.Lotto;

import java.util.List;

import static lotto.domain.Constant.MAX_LOTTOES_SIZE;
import static lotto.domain.Message.*;


public class OutputView {

    public static void printPurchaseLottoes(List<Lotto> lottoes){
        System.out.println("\n"+lottoes.size()+ OUTPUT_PURCHASE);
        for(Lotto lotto : lottoes){
            System.out.println(lotto.getNumbers());
        }
    }


    public static void printFinalResult(){
        System.out.println("\n"+OUTPUT_RESULT_START);
        System.out.println(THREE_MATCH+" "+COUNT);
        System.out.println(FOUR_MATCH+" "+COUNT);
        System.out.println(FIVE_MATCH+" "+COUNT);
        System.out.println(FIVE_BONUS_MATCH+" "+COUNT);
        System.out.println(SIX_MATCH+" "+COUNT);
        System.out.println(RATE_OF_RETURN+" "+END);
    }



//    public static void printRoundResult(List<Car> cars){
//        for(Car car : cars){
//            System.out.print(car.getName() + " : ");
//            printDashMark(car.getMove());
//        }
//        System.out.print("\n");
//    }
//
//    public static void printDashMark(int move){
//        for(int i = 0; i<move; i++){
//            System.out.print("-");
//        }
//        System.out.print("\n");
//    }
//
//    public static void printFinalWinner(List<String> finalWinner){
//        System.out.print(FINAL_WINNER);
//
//        for(int i = 0; i<finalWinner.size(); i++){
//            System.out.print(" " + finalWinner.get(i));
//            if(i != finalWinner.size()-1)
//                System.out.print (",");
//        }
//    }





}
