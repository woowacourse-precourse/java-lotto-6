package lotto;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    final static int lottolength = 6;
    final static int coinStandard = 1000; 
    static int inputCoin;
    static List<List<Integer>> lottoTotal = new ArrayList<>();

    public static void CoinValidate(int inputCoin){
        if (inputCoin % coinStandard != 0)
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");        
    }

    public static void GetCoin(){
        System.out.println("구입금액을 입력해 주세요.");
        inputCoin = Integer.parseInt(Console.readLine());
        CoinValidate(inputCoin);
        inputCoin = inputCoin / coinStandard;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GetCoin();        
        for(int i=0; i<inputCoin; i++){

        }
        
    }
}
