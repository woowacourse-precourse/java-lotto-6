package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoInput implements InputPort{

    private static final String delimiter = ",";
    private final InputReader reader;

    public LottoInput(InputReader reader) {
        this.reader = reader;
    }

    @Override
    public int receiveMoney() {
        String input = reader.readLine();
        return mapToInt(input);
    }

    @Override
    public List<Integer> receiveLottos() {
        String input = reader.readLine();
        return Arrays.stream(input.split(delimiter, -1))
                .map(it -> mapToInt(it))
                .collect(Collectors.toList());
    }

    @Override
    public int receiveBonus() {
        String input = reader.readLine();
        return mapToInt(input);
    }

    private int mapToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IoException.NOT_NUMBER.getMessage());
        }
    }
}
