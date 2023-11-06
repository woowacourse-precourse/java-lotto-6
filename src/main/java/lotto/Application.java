package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
//    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        startLotto();
    }

    public static void startLotto(){
        User user = new User();

        user.getRandomLotto();


        Lotto lotto = new Lotto(getLottoNumbers());

    }

    public static List<Integer> getLottoNumbers(){
        while (true){
            try{
                String[] StringLottoNumber = Console.readLine().split(",");
                return convertValidatedLottoNumber(StringLottoNumber);
            }  catch (IllegalArgumentException e){
                System.out.println(Message.ERROR_MESSAGE + " " + Message.INPUT_VALUE_OVERHEAD);
            }
        }
    }

    public static List<Integer> convertValidatedLottoNumber(String[] stringLottoNumber){
        List<Integer> numbers = new ArrayList<>();
        for (String number: stringLottoNumber) {
            try{
                numbers.add(Integer.parseInt(number));
            } catch (Exception e){
                e.printStackTrace();
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }




}
