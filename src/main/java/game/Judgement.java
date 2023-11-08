package game;

import io.Output;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Judgement {


    public static int isDivisibleByTicketPrice(int number) {
        int ticketPrice = Constants.TICKET_PRICE.getValue();
        int output = number % ticketPrice;
        int result = number / ticketPrice;
        if (output != 0) {
            throw new IllegalArgumentException(Output.errorCanNotDivideMessage);
        }
        return result;
    }

    public static void checkBuyMoneyIsValid(String BuyMoney) {
        if (!BuyMoney.matches("\\d+")) {
            throw new IllegalArgumentException(Output.errorNeedIntInputMessage);
        }
        try {
            int value = Integer.parseInt(BuyMoney);
            if (value <= 0) {
                throw new IllegalArgumentException(Output.errorNumberIsOver0);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Output.errorValidIntegerNumber);
        }

    }

    public static int checkSpecialNumber(String spcialNumber) {
        int value;
        try {
            value = Integer.parseInt(spcialNumber);
            if (value < 1 || value > 45) {
                throw new IllegalArgumentException(Output.errorValidSpecialNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Output.errorValidIntegerNumber);
        }
        return value;
    }

    public static int resultHitLottoCheck(List<Integer> hitNumberList,
            Integer bonusNumber, List<Lotto> lottoTickets) {
        List<Integer> hitIndexLottoList = new ArrayList<>();

        int[] countList = lottoCheckFunction(lottoTickets, hitNumberList, bonusNumber);
        int totalAmount = calTotalAmount(countList);
        addHitIndexLottoList(countList, hitIndexLottoList);
        Output.resultLottoMessage(hitIndexLottoList);
        return totalAmount;
    }

    private static int calTotalAmount(int[] countList) {
        int totalAmount = 0;

        totalAmount += countList[0] * 5000;      // 3개 일치 (5,000원)
        totalAmount += countList[1] * 50000;     // 4개 일치 (50,000원)
        totalAmount += countList[2] * 1500000;   // 5개 일치 (1,500,000원)
        totalAmount += countList[3] * 30000000;  // 5개 + 보너스번호 일치 (30,000,000원)
        totalAmount += countList[4] * 2000000000; // 6개 일치 (2,000,000,000원)

        return totalAmount;
    }

    private static int countMatchingBonusNumbers(Integer bonusNumber, List<Integer> ticketNumbers) {
        int count = 0;
        if (ticketNumbers.contains(bonusNumber)) {
            count++;
        }
        return count;
    }

    private static int countMatchingNumbers(List<Integer> hitNumbers, List<Integer> ticketNumbers) {
        int count = 0;
        for (int number : hitNumbers) {
            if (ticketNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static void addHitIndexLottoList(int[] countList, List<Integer> hitIndexLottoList) {
        for (int j : countList) {
            hitIndexLottoList.add(j);
        }
    }

    private static int[] lottoCheckFunction(List<Lotto> lottoTickets,
            List<Integer> hitNumberList, Integer bonusNumber) {

        int[] counts = new int[5]; // Index 0: hit3Count, 1: hit4Count, 2: hit5Count, 3: hit5WithBonusCount, 4: hit6Count

        for (Lotto ticket : lottoTickets) {
            int matchingNumbers = countMatchingNumbers(hitNumberList, ticket.getNumbers());
            int matchingBonusNumbers = countMatchingBonusNumbers(bonusNumber, ticket.getNumbers());
            if (matchingNumbers == 3) {
                counts[0]++;
                continue;
            }
            if (matchingNumbers == 4) {
                counts[1]++;
                continue;
            }
            if (matchingNumbers == 5 && matchingBonusNumbers == 1) {
                counts[3]++;
                continue;
            }
            if (matchingNumbers == 5) {
                counts[2]++;
                continue;
            }
            if (matchingNumbers == 6) {
                counts[4]++;
            }
        }
        return counts;
    }

    public static void calculateLottoProfit(int BuyMoney, int totalAmountMoney) {
        double profit = ((double) totalAmountMoney / BuyMoney) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0#");

        String formattedProfit = decimalFormat.format(profit);
        Output.totalProfitMessage(formattedProfit);
    }
}
