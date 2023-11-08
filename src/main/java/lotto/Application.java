package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum Prize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private int matchNumbers;
    private int prizeAmount;
    private int matchCount;

    Prize(int matchNumbers, int prizeAmount) {
        this.matchNumbers = matchNumbers;
        this.prizeAmount = prizeAmount;
        this.matchCount = 0;
    }
    public int getMatchNumbers() {
        return matchNumbers;
    }
    public int getPrizeAmount() {
        return prizeAmount;
    }
    public void increaseMatchCount() {
        this.matchCount++;
    }
    public int getMatchCount() {
        return matchCount;
    }
    public static int matchPrize(int numberOfMatches, boolean hasBonus) {
        for (Prize prize : values()) {
            if (prize.matchNumbers == numberOfMatches) {
                if (hasBonus && prize == FIVE_MATCH) {
                    return FIVE_MATCH_WITH_BONUS.prizeAmount;
                }
                prize.increaseMatchCount();
                return prize.prizeAmount;
            }

        }
        return 0;
    }
}
public class Application {
    static ArrayList<Lotto> lottoTickets = new ArrayList<>();
    static List<Integer> winningNumbers = new ArrayList<>();
    static int totalPrizeAmount = 0;
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요:");
        generateLottoTickets(readPurchase());
        showLottoTickets();
        System.out.println("당첨번호를 입력해 주세요.");
        generateWinningNumbers(readWinningNumbers());
        System.out.println("보너스 번호를 입력해주세요.");
        Integer bonusNumber=getBonusNumber(readBonusNumber());
        compareLottoWithWinning(bonusNumber);
        showPrizeCount();
        calculateProfitRate();
    }

    public static Integer readPurchase() {
        while (true) {
            try {
                String purchaseAmount = Console.readLine().trim();
                isNumeric(purchaseAmount);
                int amount = Integer.parseInt(purchaseAmount);
                isDividedByThousand(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void isDividedByThousand(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000단위로 입력해주세요");
        }
    }
    public static void isNumeric(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isEmpty())
            throw new IllegalArgumentException("빈 금액은 입력할 수 없습니다.");
        for (char c : purchaseAmount.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("구입 금액은 숫자여야 합니다");
            }
        }
    }
    public static String readWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = Console.readLine();
                isContainComma(inputWinningNumbers);
                getBeWinningNumbers(inputWinningNumbers);
                return inputWinningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }


        }

    }
    public static void getBeWinningNumbers(String inputWinningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>();
        for (String inputWinningNumber: inputWinningNumbers.split(",")) {
            int num = isRangeIn(inputWinningNumber);
            if (!uniqueWinningNumbers.add(num)) {
                throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
            }
        }

        if (uniqueWinningNumbers.size()!=6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자를 입력해야합니다.");
        }
    }

    public static int isRangeIn(String inputWinningNumber) {

        try {
            int num = Integer.parseInt(inputWinningNumber.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("번호는 1에서 45사이의 숫자입니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        }
    }
    public static void isContainComma(String winningNumbers) {
        if(!winningNumbers.contains(",")) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분해주세요.");
        }
    }
    public static String readBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = Console.readLine();
                isBonusNumeric(inputBonusNumber);
                int bonusNumber =Integer.valueOf(inputBonusNumber);
                validateBonusNumber(bonusNumber);
                validateBonusNotDuplicate(bonusNumber);
                return inputBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

    }
    public static void isBonusNumeric(String inputBonusNumber) {
        if (inputBonusNumber == null || inputBonusNumber.isEmpty())
            throw new IllegalArgumentException("빈 번호는 입력할 수 없습니다.");
        for (char c : inputBonusNumber.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다");
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45사이의 숫자입니다.");
        }
    }

    public static void validateBonusNotDuplicate(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }



    public static Integer convertMoneyFormat(String inputMoney) {
        Integer money = Integer.valueOf(inputMoney);
        return money;
    }
    public static Integer getQuantityOfLotto(Integer money) {
        Integer quantityOfLotto = money/1000;
        return quantityOfLotto;
    }
    public static void generateLottoTickets(Integer money) {
        Integer quantityOfLotto = getQuantityOfLotto(money);
        for (int i = 0; i<quantityOfLotto; i++) {
            lottoTickets.add(generateLotto());
        }
    }
    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(null);
        return new Lotto(numbers);
    }
    public static void showLottoTickets() {
        Integer numberOfLottoTickets = lottoTickets.size();
        System.out.println(String.format("%d개를 구매했습니다.",numberOfLottoTickets));
        for(Lotto lottoTicket : lottoTickets) {
            List<Integer> numbers = lottoTicket.getNumbers();
            System.out.println(numbers);
        }
    }
    public static void generateWinningNumbers(String inputWinningNumbers) {
        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.valueOf(winningNumber));
        }
    }
    public static Integer getBonusNumber(String inputBonusNumber) {
        Integer bonusNumber = Integer.valueOf(inputBonusNumber);
        return bonusNumber;
    }
    public static void compareLottoWithWinning(Integer bonusNumber) {
        for(Lotto lottoTicket : lottoTickets) {
            Integer numberOfMatches = (int) lottoTicket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean hasBonus = lottoTicket.getNumbers().contains(bonusNumber);
            totalPrizeAmount += calculatePrizeAmount(numberOfMatches,hasBonus);



        }
    }
    public static Integer calculatePrizeAmount(int numberOfMatches, boolean hasBonus) {
        int prizeAmount = Prize.matchPrize(numberOfMatches, hasBonus);
        return prizeAmount;
    }
    public static void calculateProfitRate() {
        int totalPurchase = lottoTickets.size() * 1000;
        float profitRate = ((float) totalPrizeAmount / totalPurchase) * 100;
    }
    public static void showPrizeCount() {
        System.out.println(Prize.THREE_MATCH.getMatchCount());
        System.out.println(Prize.FOUR_MATCH.getMatchCount());
        System.out.println(Prize.FIVE_MATCH.getMatchCount());
        System.out.println(Prize.FIVE_MATCH_WITH_BONUS.getMatchCount());
        System.out.println(Prize.SIX_MATCH.getMatchCount());
    }
}
