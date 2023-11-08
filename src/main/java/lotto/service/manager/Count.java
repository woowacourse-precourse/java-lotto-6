package lotto.service.manager;

public class Count {

    private long count;

    public Count() {
        this(0L);
    }

    public Count(long count) {
        this.count = count;
    }


    public void plus() {
        count++;
    }

    public long getCount() {
        return count;
    }
}
