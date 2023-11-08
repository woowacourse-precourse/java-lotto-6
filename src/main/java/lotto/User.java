package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class User {

    final static int LOTTO_PRICE = 1000;
    final static int LOTTO_START_NUMBER = 1;
    final static int LOTTO_END_NUMBER = 45;
    final static int LOTTO_PICK_NUMBER = 6;
    public int inputMoney() {
        String moneyStr = Console.readLine();
        try{
            return verifyMoney(moneyStr);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMoney();
        }

    }

    public static int verifyMoney(String moneyStr) {
        int money;
        try {
            money = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원을 단위로 입력해주세요");
        }

        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 0원 이상의 돈을 입력해주세요");
        }

        return money;
    }

    public static int verifyIntValue(String moneyStr) {
        int money;
        try {
            money = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (money < LOTTO_START_NUMBER || money > LOTTO_END_NUMBER) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return money;
    }

    public List<List<Integer>> generateLottoNumber(int money) {
        int lottoNum = money / LOTTO_PRICE;
        System.out.println(lottoNum + "개를 구매했습니다.");
        List<List<Integer>> lottoNumberTotal = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_PICK_NUMBER);
            List<Integer> lottoNumberOrder = new ArrayList<>(lottoNumber);
            Collections.sort(lottoNumberOrder);
            lottoNumberTotal.add(lottoNumberOrder);
        }
        printLottoNumbers(lottoNumberTotal);
        System.out.println();
        return lottoNumberTotal;
    }

    public static void printLottoNumbers(List<List<Integer>> lottoNumberTotal) {
        for (List<Integer> lottoNumber : lottoNumberTotal) {
            System.out.println(lottoNumber.toString());
        }
    }

    public Lotto inputAnswer() {
        List<Integer> answerNum = new ArrayList<>();
        String answerStr = Console.readLine();
        String[] answer = answerStr.split(",");

        try{
            for (String numStr : answer) {
                answerNum.add(verifyIntValue(numStr));
            }
            return new Lotto(answerNum);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputAnswer();
        }
    }


    public int inputBonusNumber() {
        String bonusStr = Console.readLine();
        try{
            return verifyIntValue(bonusStr);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

}
