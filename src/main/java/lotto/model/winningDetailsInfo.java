package lotto.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

public class winningDetailsInfo {

    private final Map<winningDetails, counter> Details;

    public winningDetailsInfo() {
        Details = new EnumMap<>(winningDetails.class);
        for (winningDetails winningDetails : winningDetails.values()) {
            Details.put(winningDetails, new counter());
        }
    }

    public void update(final winningDetails winningDetails) {
        counter currentCounter = Details.get(winningDetails);
        Details.put(winningDetails, currentCounter.plus());
    }

    public int get(final winningDetails winningDetails) {
        counter counter = Details.get(winningDetails);
        return counter.getCount();
    }

}
