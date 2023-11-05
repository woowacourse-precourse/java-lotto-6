package lotto.view;



import lotto.domain.Lotto;

import java.util.List;

import static lotto.domain.Constant.MAX_LOTTOES_SIZE;
import static lotto.domain.Message.OUTPUT_RESULT;


public class OutputView {

    public static void printPurchaseLottoes(List<Lotto> lottoes){
        System.out.println("\n"+lottoes.size()+OUTPUT_RESULT);
        for(Lotto lotto : lottoes){
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto){
        System.out.print("[");
        for(int i = 0; i<lotto.getNumbers().size(); i++){
            System.out.print(lotto.getNumbers().get(i));
            if(i != MAX_LOTTOES_SIZE-1)
                System.out.print(", ");
        }
        System.out.println("]");
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
