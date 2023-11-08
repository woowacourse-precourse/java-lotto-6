package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lottery {
    private static final String EXCEPTION_PREFIX = "[ERROR]";
    private static final int PRICE_OF_LOTTO = 1000;
    private int receivedMoney;
    private int quantityOfLottoPublishable;
    private List<Integer> chosenNumber;
    private List<Lotto> lottos = new ArrayList<>();
    private int bonusNumber;


    public void receiveMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String money = Console.readLine();

            if (!money.matches("^[0-9]+$")) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX + "정수만 입력 가능합니다.");
            }
            if (Integer.parseInt(money) % 1000 != 0) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX + "입력은 1000 단위로 해주세요.");
            }
            receivedMoney = Integer.parseInt(money);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            receiveMoney();
        }
    }

    public void calculateQuantityOfLottoAndNotify() {
        quantityOfLottoPublishable = receivedMoney / PRICE_OF_LOTTO;
        System.out.println(quantityOfLottoPublishable + "개를 구매했습니다.");
    }

    public void publishLotto() {
        for (int i = 0; i < quantityOfLottoPublishable; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber = lottoNumber.stream().sorted().toList();
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);

            System.out.println(lotto);
        }
    }

    public void getChosenLottoNumber() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String chosenNum = Console.readLine();

            if (chosenNum.split(",").length != 6) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX + " 쉼표로 나눠진 6개의 숫자를 입력해주세요.");
            }

            chosenNumber = Arrays.stream(chosenNum.split(",")).map(Integer::parseInt).sorted().toList();

            if (!validateChosenNumber()) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX + "숫자의 범위나 중복된 요소를 확인해주세요.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            getChosenLottoNumber();
        }
    }

    public boolean validateChosenNumber() throws IllegalArgumentException {
        int conditionMetValue = chosenNumber.stream().filter(el -> 1 <= el && el <= 45).toList().size();

        if (conditionMetValue != chosenNumber.size()) {
            return false;
        }

        List<Integer> distinctNum = new HashSet<>(chosenNumber).stream().toList();

        if (chosenNumber.size() != distinctNum.size()) {
            return false;
        }

        return true;
    }

    public void getChosenBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String chosenNum = Console.readLine();

            if (!chosenNum.matches("^[0-9]+$")) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX + "보너스 번호는 정수로 입력해주세요.");
            }

            int bonusNumber = Integer.parseInt(chosenNum);

            if (1 > bonusNumber || bonusNumber > 45) {
                throw new IllegalArgumentException(EXCEPTION_PREFIX + "보너스 번호는 1부터 45 이내의 정수로 입력해주세요.");
            }

            this.bonusNumber = bonusNumber;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            getChosenBonusNumber();
        }
    }

    public void notifyLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 0; i < lottos.size(); i++) {
            int winningNums = lottos.get(i).checkLottoWinning(chosenNumber);
            countWinningLottoByGrade(winningNums);
        }

        notifyRateOfWinning();

        double rateOfRevenue = calculateRateOfRevenue();
        System.out.println("총 수익률은 " + rateOfRevenue + "%입니다.");
    }

    private void notifyRateOfWinning() {
        System.out.println(LottoState.FIFTH);
        System.out.println(LottoState.FOURTH);
        System.out.println(LottoState.THIRD);
        System.out.println(LottoState.SECOND);
        System.out.println(LottoState.FIRST);
    }

    public void countWinningLottoByGrade(int winningNum) {
        if (winningNum == 3) {
            LottoState.FIFTH.countNumberOfWinningNumbers();
        } else if (winningNum == 4) {
            LottoState.FOURTH.countNumberOfWinningNumbers();
        } else if (winningNum == 5) {
            boolean checkBonusNum = checkBonusNum();
            if (checkBonusNum) {
                LottoState.SECOND.countNumberOfWinningNumbers();
                return;
            }
            LottoState.THIRD.countNumberOfWinningNumbers();
        } else if (winningNum == 6) {
            LottoState.FIRST.countNumberOfWinningNumbers();
        }
    }

    private boolean checkBonusNum() {
        boolean result = false;

        int bonusNum = Randoms.pickNumberInRange(1, 45);
        if (bonusNum == bonusNumber) {
            result = true;
        }

        return result;
    }

    private double calculateRateOfRevenue() {
        int amountOfWinning = LottoState.FIFTH.calculateWinningAmount();
        amountOfWinning += LottoState.FOURTH.calculateWinningAmount();
        amountOfWinning += LottoState.THIRD.calculateWinningAmount();
        amountOfWinning += LottoState.SECOND.calculateWinningAmount();
        amountOfWinning += LottoState.FIRST.calculateWinningAmount();

        double rateOfRevenue = (double) amountOfWinning / receivedMoney;

        rateOfRevenue = (double) Math.round(rateOfRevenue * 10) / 10;
        return rateOfRevenue;
    }


}
