package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoGame() {

        // Set map.
        this.rankCounts = new HashMap<>();
        Arrays.stream(Rank.values()).forEach((rank) -> {
            this.rankCounts.put(rank, 0);
        });
    }

    public void startGame() {
        int purchaseAmount = getPurchaseAmount();
        this.winningNumbers = inputWinningNumbers();
        this.bonusNumber = inputBonusNumber();

        ArrayList<Lotto> lottos = LottoMachine.buyLotto(purchaseAmount);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(Lotto::printNumbers);
        lottos.forEach((lotto) -> {
            Rank rank = lotto.checkRank(this.winningNumbers, this.bonusNumber);
            int count = this.rankCounts.getOrDefault(rank, 0);
            this.rankCounts.put(rank, count + 1);
        });

        rankCounts.entrySet()
                .stream()
                .filter(rank -> !rank.getKey().equals(Rank.NOTHING))
                .sorted(Map.Entry.comparingByKey())
                .forEach((rank) -> {
            String rankInfo = rank.getKey().getFormattedRankInfo();
            System.out.println(rankInfo + " - " + rank.getValue() + "개");
        });

        Long profitAmount = rankCounts.entrySet()
                .stream().filter((entry) -> entry.getValue() > 0)
                .map((entry) -> entry.getKey().prizeAmount * entry.getValue())
                .mapToLong(Integer::longValue)
                .sum();

        Double profitRate = calculateProfitRate(profitAmount, purchaseAmount);

        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private Double calculateProfitRate(Long profit, Integer purchaseAmount) {
//        return Math.round(((double) profit / purchaseAmount * 100)) / 100.0;

        return (double) profit / purchaseAmount * 100.0;
    }

    public int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");

        while (true) {
            try {
                String input = Console.readLine();
                validateAmount(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateAmount(String input) {
        if(!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;

        System.out.println("당첨 번호를 입력해 주세요.");

        while(true) {
            try {
                winningNumbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                validateWinningNumbers(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }

        boolean areNumbersInRange = winningNumbers.stream()
                .anyMatch(number -> 1 <= number && 45 >= number);
        if (!areNumbersInRange) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력이 가능합니다.");
        }

        boolean areNumbersUnique = winningNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count <= 1);
        if (!areNumbersUnique) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while(true) {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력이 가능합니다.");
        }

        this.winningNumbers.forEach((winningNumber) -> {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            }
        });

    }


}
