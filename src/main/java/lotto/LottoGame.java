package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    Input input;
    List<Lotto> lottoList;

    LottoGame(Input input) {
        this.input = input;
    }

    public void runGame() {
        Integer totalPrice = inputTotalPrice();
        Integer lottoCount = totalPrice / 1000;
        System.out.println(String.format("%d개를 구매했습니다.", totalPrice/1000));
        List<Lotto> lottoList = generateLotto(lottoCount);
        List<Integer> winningNumber = inputWinningNumbers();
        Integer bonusNumber = inputBonusNumber();
        resultLotto(matchLottosWithWinningNumbers(lottoList, bonusNumber, winningNumber));
    }

    private Integer inputTotalPrice() {
        Integer inputPrice = input.inputIntegerWithMessage(Script.TOTALPRICE);
        if (inputPrice % 1000 != 0) {
            Error.UNIT.print();
            return inputTotalPrice();
        }
        return inputPrice;
    }

    private List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = input.inputIntegerListWithMessage(Script.WINNINGNUMBERS);
        try {
            validate(winningNumbers);
        } catch (IllegalArgumentException illegalArgumentException) {
            return inputWinningNumbers();
        }
        return winningNumbers;
    }

    private Integer inputBonusNumber() {
        return input.inputIntegerWithMessage(Script.BONUSNUMBER);
    }

    private List<Lotto> generateLotto(Integer count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
        }
        System.out.println();
        return lottoList;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private int[] matchLottosWithWinningNumbers(List<Lotto> lottoList, Integer bounusNumber, List<Integer> winningNumber) {
        int[] result = new int[9];
        for (Lotto lotto : lottoList) {
            Integer matchNumberCount = lotto.getRanking(winningNumber);
            if (matchNumberCount == 3 && lotto.matchBonusNumber(bounusNumber)) {
                result[matchNumberCount-1] += 1;
                continue;
            }
            if (matchNumberCount == 2) {
                result[matchNumberCount-1] += 1;
                continue;
            }
            result[matchNumberCount] += 1;
        }
        return result;
    }

    private void resultLotto(int[] result) {
        System.out.println("당첨 통계\n---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", result[5]));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", result[4]));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", result[3]));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", result[2]));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", result[1]));
        System.out.println("총 수익률은 입니다");
    }
    

}
