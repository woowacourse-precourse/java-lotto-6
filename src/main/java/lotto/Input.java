package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Input {
    public static int money;
    public static int lottoQuantity;
    public static int[][] lottoAllNumbers;

    public Input(){
        InputMoney();
    }

    public static void InputMoney(){
        String inputMoney;

        System.out.println("구입금액을 입력해 주세요.");
        inputMoney = Console.readLine();
        try{
            Input.money = Integer.parseInt(inputMoney);
        }catch (NumberFormatException n){
            try{
                throw new IllegalArgumentException("no int");
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 금액은 숫자만 적용이 가능합니다.");
                InputMoney();
            }
        }

        LottoQuantity(money);
    }

    public static void MoneyTest(){

    }

    //구입 금액에서 갯수 뽑아오기
    public static void LottoQuantity(int money){
        lottoQuantity = money / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        LottoPick(Input.lottoQuantity);
    }

    //로또 랜덤 번호 갯수 만큼 가져오기
    public static void LottoPick(int quantity){
        lottoAllNumbers = new int[quantity][6];

        for (int i = 0; quantity > i; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            for (int j = 0; j < 6; j++){
                lottoAllNumbers[i][j] = numbers.get(j);
            }
            Arrays.sort(lottoAllNumbers[i]);
            System.out.println(Arrays.toString(lottoAllNumbers[i]));
        }
        InputLottoNumbers();
    }

    public static void InputLottoNumbers(){
        String[] inputLottoNumbers;
        ArrayList<Integer> lottoNumbers = new ArrayList<Integer>();

        System.out.println("당첨 번호를 입력해 주세요.");
        inputLottoNumbers = Console.readLine().split(",");
        for (int i = 0; i < inputLottoNumbers.length; i++){
            lottoNumbers.add(Integer.parseInt(inputLottoNumbers[i]));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.InputBonus();
    }

}
