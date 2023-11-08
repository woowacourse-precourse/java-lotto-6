package lotto.io;

import lotto.constants.PrizeEnum;
import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class OutputHandler {

    private static final String PHRASE_AMOUNT_PURCHASE = "구입금액을 입력해 주세요.";
    private static final String PHRASE_QUANTITY_PURCHASED = "\n%d개를 구매했습니다.";
    private static final String PHRASE_INPUT_MAGIC_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String PHRASE_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String PHRASE_WIN_ACCOUNT = "\n당첨 통계";
    private static final String PHRASE_EARN_RATE = "총 수익률은 %.1f%%입니다.";
    private static final String HORIZON_SEP = "---";

    public static void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printQuantityPurchased(int quantity) {
        String phraseQuantity = String.format(PHRASE_QUANTITY_PURCHASED, quantity);
        System.out.println(phraseQuantity);
    }

    public static void printPrizeStat(HashMap<String, Integer> matchCountLotto) {
        printWinAccount();
        for (PrizeEnum prize : PrizeEnum.values()) {
            printPrize(prize.getComment(), prize.getAmount(), matchCountLotto.get(prize.getKey()));
        }
    }
    public static void printPrize(String place, int prizeMoney, int count) {
        String formattedMoney = String.format("%,d", prizeMoney);
        String formattedString = String.format(place, formattedMoney, count);
        System.out.println(formattedString);
    }

    public static void printReturnRate(double returnRate) {
        returnRate = returnRate * 100;
        String phraseReturnRate = String.format(PHRASE_EARN_RATE, returnRate);
        System.out.println(phraseReturnRate);
    }

    public static void printPurchasePhrase() {
        System.out.println(PHRASE_AMOUNT_PURCHASE);
    }

    public static void printMagicNumberPhrase() {
        System.out.println(PHRASE_INPUT_MAGIC_NUMBER);
    }

    public static void printBonusNumberPhrase() {
        System.out.println(PHRASE_INPUT_BONUS_NUMBER);
    }

    public static void printWinAccount() {
        System.out.println(PHRASE_WIN_ACCOUNT);
        System.out.println(HORIZON_SEP);
    }
}
