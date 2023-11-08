package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();

        List<Lotto> userLottoTickets = purchaseLottoTickets(purchaseAmount);
        printResults1(userLottoTickets);

        Lotto winningLotto = generateWinningLotto();
        int bonusNumber = getBonusNumber();

        int prize = 0;
        printResults2(userLottoTickets, winningLotto, bonusNumber, prize);

    }

    private static int getPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            purchaseAmount = readPurchaseAmount();
            if (isValidPurchaseAmount(purchaseAmount)) {
                break;
            }
            else if (!isValidPurchaseAmount(purchaseAmount)){
                System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위로 입력하고 0보다 커야 합니다.");
                continue;
            }
        }
        return purchaseAmount;
    }
    
    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            return readPurchaseAmount();
        }
    }
    
    private static boolean isValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 == 0 && purchaseAmount > 0) {
            return true;
        } else if (!(purchaseAmount % 1000 == 0 && purchaseAmount > 0)) {
            return false;
        }
        return false;
    }
    
    private static List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        System.out.println("\n"+numberOfTickets+"개를 구매했습니다.");
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(LottoTicketGenerator.generateLottoTicket());
        }
        return lottoTickets;
    }

    private static Lotto generateWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = readWinningNumbers();
        return new Lotto(numbers);
    }
    
    private static List<Integer> readWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine();
        String[] numberStrings = input.split(",");
    
        if (numberStrings.length != 6) {
            System.out.println("[ERROR] 6개의 당첨 번호를 입력해야 합니다.\n");
            generateWinningLotto();
        }
        
        for (String numberStr : numberStrings) {
            boolean checkNum = isValidWinningNumberFormat(numberStr, numbers);
            if (checkNum) {
                int winningNumber = Integer.parseInt(numberStr.trim());
                numbers.add(winningNumber);
            }
            else if (!checkNum){
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이어야 하고 중복되지 않아야 합니다.\n");
                generateWinningLotto();
                break;
            }
        }
        return numbers;
    }
    
    private static boolean isValidWinningNumberFormat(String numberStr, List<Integer> numbers) {
        try {
            int winningNumber = Integer.parseInt(numberStr.trim());
            if (winningNumber >= 1 && winningNumber <= 45 && !numbers.contains(winningNumber)) {
                return true;
            } else if (!(winningNumber >= 1 && winningNumber <= 45 && !numbers.contains(winningNumber))) {
                return false;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getBonusNumber() {
        int bonusNumber = 0;
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            bonusNumber = Integer.parseInt(input);
            if (bonusNumber >= 1 && bonusNumber <= 45) { return bonusNumber; } 
            else if (!(bonusNumber >= 1 && bonusNumber <= 45)) { System.out.println("보너스 번호는 1부터 45 사이어야 합니다."); }
            
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자 형식이 아닙니다.");
            getBonusNumber();
        }
        return bonusNumber;
    }

    private static void printResults1(List<Lotto> userLottoTickets) {
        for (Lotto lotto : userLottoTickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    private static void printResults2(List<Lotto> userLottoTickets, Lotto winningLotto, int bonusNumber, int prize) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    
        int[] matchingNumbersCount = countMatchingNumbers(userLottoTickets, winningLotto, bonusNumber);
        prize = calculatePrize(matchingNumbersCount);
        printResults(userLottoTickets, matchingNumbersCount, prize);
    }
    
    private static int[] countMatchingNumbers(List<Lotto> userLottoTickets, Lotto winningLotto, int bonusNumber) {
        int[] matchingNumbersCount = new int[8];
    
        for (Lotto lotto : userLottoTickets) {
            int matchingNumbers = calculateMatchingNumbers(lotto, winningLotto);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
    
            if (matchingNumbers == 6) {
                matchingNumbersCount[7]++;
            } else if (matchingNumbers == 6 && !hasBonusNumber) {
                matchingNumbersCount[5]++;
            } else if (matchingNumbers == 5 && hasBonusNumber) {
                matchingNumbersCount[6]++;
            } else if (matchingNumbers == 5 && !hasBonusNumber) {
                matchingNumbersCount[4]++;
            } else if ((!(matchingNumbers == 6)) || !(matchingNumbers == 5)){
                matchingNumbersCount[matchingNumbers]++;
            }
        }
        return matchingNumbersCount;
    }
    
    private static int calculatePrize(int[] matchingNumbersCount) {
        int prize = 0;
        for (int i = 3; i < 8; i++) {
            int prizeAmount = 0;
            if (i == 3) {
                prizeAmount = matchingNumbersCount[3] * 5000;
            } else if (i == 4) {
                prizeAmount = matchingNumbersCount[4] * 50000;
            } else if (i == 5) {
                prizeAmount = matchingNumbersCount[5] * 1500000;
            } else if (i == 6) {
                prizeAmount = matchingNumbersCount[6] * 30000000; 
            } else if (i == 7) {
                prizeAmount = matchingNumbersCount[7] * 2000000000;
            }
            prize += prizeAmount;
        }
        return prize;
    }
    
    private static void printResults(List<Lotto> userLottoTickets, int[] matchingNumbersCount, int prize) {
        for (int i = 3; i < 8; i++) {
            if (i == 6) {
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingNumbersCount[6] + "개");
            } else if (i!= 6 && i!=7) {
                System.out.println(i + "개 일치 (" + addCommasToNumber(getPrizeAmount(i)) + "원) - " + matchingNumbersCount[i] + "개");
            } else if (i == 7) {
                System.out.println(i-1 + "개 일치 (2,000,000,000원) - " + matchingNumbersCount[7] + "개");
            }
        }
        int totalTickets = userLottoTickets.size();
        double profitRate = (prize / (totalTickets * 1000.0)) * 100;
        profitRate = Math.round(profitRate * 100.0) / 100.0; 
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private static String addCommasToNumber(int number) {
        return String.format("%,d", number);
    }
    
    private static int getPrizeAmount(int matchingNumbers) {
        if (matchingNumbers == 3) {
            return 5000;
        } else if (matchingNumbers == 4) {
            return 50000;
        } else if (matchingNumbers == 5) {
            return 1500000;
        } else if (matchingNumbers == 6) {
            return 30000000;
        } 
        return 0;
    }
    
    private static int calculateMatchingNumbers(Lotto userLotto, Lotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchingNumbers = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }
}
