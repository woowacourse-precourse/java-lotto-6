package lotto.service;

import lotto.utils.BillException;
public class UserBillToAmount {
    public static int billToAmount(int Bill) {
        BillException.isBillValid(Bill);
        int amount = Bill / 1000;
        return amount;
    }
}
