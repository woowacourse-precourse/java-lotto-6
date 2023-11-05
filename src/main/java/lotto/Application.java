package lotto;

import lotto.Amount;

import java.util.*;
import java.util.Vector;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static Vector<Integer> lottoNumberVector = new Vector<>(LOTTO_NUMBERS_SIZE);
    private static int bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Amount amount = new Amount(); //가격을 입력으로 받고 validation함

        Lotto WinLotto = getWinNumbers(); // 로또 당첨 번호를 입력받음

    }

    private static List<Integer> parseLottoNumbers(String lottoNums) { //입력 -> List<Integer>
        String[] tokens = lottoNums.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim()); // 쉼표 다음에 공백이 올 수 있으므로 trim()을 사용
            numbers.add(number);
        }
        return numbers;
    }

    private static Lotto getWinNumbers(){
        while(true){
            try {
                System.out.print("당첨 번호를 입력하세요: ");
                String LottoNums = Console.readLine();
                List<Integer> LottoNumsIntList = parseLottoNumbers(LottoNums);
                Lotto winLotto = new Lotto(LottoNumsIntList);
                return winLotto;
            }catch (NumberFormatException e) { //ParseInt에서 던지는 exception
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다.");
            } catch (IllegalArgumentException e) { //Lotto class에서 던지는 exception
                System.out.println(e.getMessage());
            }
        }
    }


}
