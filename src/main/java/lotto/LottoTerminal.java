package lotto;

import static lotto.constants.ProgramMessage.PRINT_COUNT_OF_LOTTO_ISSUED;
import static lotto.constants.ProgramMessage.REQUEST_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class LottoTerminal {
    private static final int NUMBERS_COUNT_PER_LOTTO = 6;
    private static final int MIN_OF_LOTTO_NUMBER = 1;
    private static final int MAX_OF_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    private long amountPaid;
    private List<List<Integer>> allLottoIssued = new ArrayList<>();
    private long countOfLottoIssued;

    public String requestAndReadPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());

        return Console.readLine();
    }

    public void receivePayment(long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void LottoIssuance() {
        while (amountPaid > 0) {
            HashSet<Integer> numbersToCheck = new HashSet<>();

            while (numbersToCheck.size() < NUMBERS_COUNT_PER_LOTTO) {
                numbersToCheck.add(Randoms.pickNumberInRange(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER));
            }

            List<Integer> numbersOfLotto = transformHashSetToList(numbersToCheck);
            Lotto lotto = new Lotto(numbersOfLotto);
            allLottoIssued.add(numbersOfLotto);
            countOfLottoIssued++;
            amountPaid -= LOTTO_PRICE;
        }
    }

    private List<Integer> transformHashSetToList(HashSet<Integer> hashSet) {
        List<Integer> list = new ArrayList<>();

        Iterator iter = hashSet.iterator();
        while (iter.hasNext()) {
            list.add(Integer.parseInt(iter.next().toString()));
        }

        return list;
    }

    public void printAllLotto() {
        System.out.println();
        System.out.println(countOfLottoIssued + PRINT_COUNT_OF_LOTTO_ISSUED.getMessage());

        for (int i = 0; i < allLottoIssued.size(); i++) {
            Collections.sort(allLottoIssued.get(i));

            System.out.println(allLottoIssued.get(i));
        }
    }
}
