package lotto.domain.purchase.lottocount;

public final class CashMapper {
    public static Long mapToInteger(String cashInput) {
        return Long.parseLong(cashInput);
    }
}
