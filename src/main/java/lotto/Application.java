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
        Lotto lotto = new Lotto(getLottoNumbers());

    }

    public static List<Integer> getLottoNumbers(){
        while (true){
            try{
                String[] StringLottoNumber = Console.readLine().split(",");
                return convertValidatedLottoNumber(StringLottoNumber);
            }  catch (IllegalArgumentException e){
                System.out.println(Message.ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
