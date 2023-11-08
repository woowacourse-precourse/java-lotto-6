package lotto.domain.amount;

public class Amount {

    protected final int amount;

    protected Amount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Amount amountObj = (Amount) obj;
        return this.amount == amountObj.amount;
    }
}
