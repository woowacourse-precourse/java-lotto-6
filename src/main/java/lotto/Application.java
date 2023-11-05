package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int inputTry = readInputPrice();
        List<Lotto> lottoList = makeLottoNumber(inputTry);
    }

    private static List<Lotto> makeLottoNumber(int inputTry) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i< inputTry; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }

        for (Lotto lottonum : lottoList) {
            System.out.println(lottonum.getNumbers());
        }
        return lottoList;
    }

    private static int readInputPrice() {
        int inputTry;
        while(true){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int inputPrice = Integer.parseInt(readLine());
                validateThousandUnit(inputPrice);
                inputTry= (inputPrice/1000);
                return inputTry;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateThousandUnit (int inputPrice) {
        if((inputPrice %1000)!=0){
            throw new IllegalArgumentException("[ERROR] 구입금액 단위는 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}
