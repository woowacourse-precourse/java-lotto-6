package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startLotto();
    }

    public static void startLotto(){
        User user = new User();
        Lotto lotto = new Lotto(getLottoNumbers());

    }

    public static List<Integer> getLottoNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (true){
            try{
                String[] StringLottoNumber = Console.readLine().split(",");
                convertValidatedLottoNumber(StringLottoNumber, numbers);
                break;
            }  catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return numbers;
    }

    public static void convertValidatedLottoNumber(String[] stringLottoNumber, List<Integer> numbers){

    }




}
