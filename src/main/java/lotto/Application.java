package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        generateLottoTickets(Console.readLine());
        showLottoTickets();
        System.out.println("당첨번호를 입력해 주세요.");
        getWinningNumbers(Console.readLine());
        System.out.println("보너스 번호를 입력해주세요.");
        Integer bonusNumber=getBonusNumber(Console.readLine());
        compareLottoWithWinning(bonusNumber);
        showPrizeCount();
        calculateProfitRate();
    }

    public static Integer convertMoneyFormat(String inputMoney) {
        Integer money = Integer.valueOf(inputMoney);
        return money;
    }
    public static Integer getQuantityOfLotto(Integer money) {
        Integer quantityOfLotto = money/1000;
        return quantityOfLotto;
    }
    public static void generateLottoTickets(String inputMoney) {
        Integer money= convertMoneyFormat(inputMoney);
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
    public static void getWinningNumbers(String inputWinningNumbers) {
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
