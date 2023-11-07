package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1. 사용자로부터 로또 구입 금액을 입력받고, 로또 구입 금액에 해당하는 만큼 로또를 발행한다.(로또 1장의 가격은 1,000원)
        System.out.println("구입금액을 입력해 주세요.");
        long userInputAmount = getUserInputAmount();

        int lottoCount = (int)(userInputAmount/1000);
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);

        List<Lotto> lottos = getLotto(lottoCount);
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }

    }

    public static long getUserInputAmount() {
        String userInput;
        while(true) {
            try {
                userInput = readLine().trim();
                inputAmountValidate(userInput);
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 금액을 1,000원 단위 숫자로 입력해주세요.");
            }
        }

        return Long.parseLong(userInput);
    }

    public static void inputAmountValidate(String userInput){
        if(!isNumeric(userInput)){
            throw new IllegalArgumentException();
        }
        if(!hasRemainder(userInput)){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumeric(String userInput){
        try {
            Long.parseLong(userInput);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean hasRemainder(String userInput){
        if( !((Long.parseLong(userInput) % 1000L) == 0) ){
            return false;
        }
        return true;
    }

    public static List<Lotto> getLotto(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(pickUniqueNumbersInRange(1,45,6)));
        }

        return lottos;
    }
}
