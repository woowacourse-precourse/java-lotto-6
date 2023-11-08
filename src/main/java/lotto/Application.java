package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.controller.MainController;
import lotto.model.Lotto;
import lotto.model.User;

public class Application {
    private static MainController mainController;
    public static void main(String[] args) {
        mainController = MainController.getIntstance();
        try{
            mainController.startLotto();
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }



    public static List<Integer> getLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true){
            try{
                String[] StringLottoNumber = Console.readLine().split(",");
                return convertValidatedLottoNumber(StringLottoNumber);
            }  catch (IllegalArgumentException e){

            }
        }
    }

    public static List<Integer> convertValidatedLottoNumber(String[] stringLottoNumber){
        List<Integer> numbers = new ArrayList<>();
        for (String number: stringLottoNumber) {
            try{
                if(numbers.equals("")){
                    throw new IllegalArgumentException();
                }
                numbers.add(Integer.parseInt(number));
            } catch (Exception e){
                e.printStackTrace();
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }

}
