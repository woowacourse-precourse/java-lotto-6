package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    public List<Integer> createRandomNumber(){
        Randoms.pickNumberInRange(1, 45);
        Set<Integer> lottoNumbers = new TreeSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return lottoNumbers.stream().toList();
    }

    public List<Integer> getWinningLottoNumberByRead(){
        String input = readLine();
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    public Integer getBonusLottoNumberByRead(){
        String input = readLine();
        return Integer.parseInt(input);
    }

    public int getPaymentForLottoByRead() {
        int lottoAmount = 0;
        while (true) {
            if (lottoAmount > 0) break;
            try {
                lottoAmount = getPaymentForLottoByRead(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoAmount;
    }

    protected int getPaymentForLottoByRead(String readLine) {

        try {
            int price = Integer.parseInt(readLine);
            assertPaymentForLotto(price);
            int numberOfLotto = price / 1000;
            return numberOfLotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력해주세요.");
        }
    }

    private void assertPaymentForLotto(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원 단위로 입력해주세요.");
        }
    }

}
