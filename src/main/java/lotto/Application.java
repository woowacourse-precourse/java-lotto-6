package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
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
    static List<Integer> numbers = new ArrayList<>();
    static int totalPrizeAmount = 0;
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        generateLottoTickets(readInput.readPurchase());
        showLottoTickets();
        System.out.println("당첨번호를 입력해 주세요.");
        generateWinningNumbers(readInput.readWinningNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber=getBonusNumber(readInput.readBonusNumber());
        compareLottoWithWinning(bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        showPrizeCount();
        calculateProfitRate();
        Console.readLine();
//        System.out.println("8개를 구매했습니다");
//        System.out.println("[8, 21, 23, 41, 42, 43]");
//        System.out.println("[3, 5, 11, 16, 32, 38]");
//        System.out.println("[7, 11, 16, 35, 36, 44]");
//        System.out.println("[1, 8, 11, 31, 41, 42]");
//        System.out.println("[13, 14, 16, 38, 42, 45]");
//        System.out.println("[7, 11, 30, 40, 42, 43]");
//        System.out.println("[2, 13, 22, 32, 38, 45]");
//        System.out.println("[1, 3, 5, 14, 22, 45]");
//        Console.readLine();
//        Console.readLine();
//        System.out.println("3개 일치 (5,000원) - 1개");
//        System.out.println("4개 일치 (50,000원) - 0개");
//        System.out.println("5개 일치 (1,500,000원) - 0개");
//        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
//        System.out.println("6개 일치 (2,000,000,000원) - 0개");
//        System.out.println("총 수익률은 62.5%입니다.");




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
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(null);
        return new Lotto(numbers);
    }

    public static void showLottoTickets() {
        Integer numberOfLottoTickets = lottoTickets.size();
        System.out.println(String.format("%d개를 구매했습니다.",numberOfLottoTickets));
        for(Lotto lottoTicket : lottoTickets) {
            numbers = lottoTicket.getNumbers();
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
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String formattedProfitRate = decimalFormat.format(profitRate);
        System.out.println("총 수익률은 "+formattedProfitRate+"%입니다.");
    }

    public static void showPrizeCount() {
        System.out.println("3개 일치 (5,000원) - "+Prize.THREE_MATCH.getMatchCount()+"개");
        System.out.println("4개 일치 (50,000원) - "+Prize.FOUR_MATCH.getMatchCount()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+Prize.FIVE_MATCH.getMatchCount()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+Prize.FIVE_MATCH_WITH_BONUS.getMatchCount()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+Prize.SIX_MATCH.getMatchCount()+"개");

    }
}
