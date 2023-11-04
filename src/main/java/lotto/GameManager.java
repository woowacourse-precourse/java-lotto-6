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

    public void printWinning(List<Lotto> lottos) {
        Map<Integer, List<Lotto>> lottoByWinningCount = new HashMap<>();
        int winningWithBonusCount = 0;
        for (Lotto lotto : lottos) {
            if (lotto.getWinningCount() > 2) {
                lottoByWinningCount.put(lotto.getWinningCount(), new ArrayList<>());
                lottoByWinningCount.get(lotto.getWinningCount()).add(lotto);
            }
            if (lotto.getWinningCountWithBonusNumber()) {
                winningWithBonusCount += 1;
            }
        }
        Optional.of("").orElse("test");
        System.out.println("3개 일치 (5,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(3)).stream().count()+ "개");
        System.out.println("4개 일치 (50,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(4)).stream().count()  + "개");
        System.out.println("5개 일치 (1,500,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(5)).stream().count()  + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + " - " + winningWithBonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(6)).stream().count()  + "개");
    }

}
