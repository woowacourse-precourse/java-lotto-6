package lotto.io;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exceptions.ReadIntegerException;

public class Input {
    public static String promptLine(Object message) {
        Output.println(message);
        return Console.readLine();
    }

    public static int readLineAsInt() {
        String line = Console.readLine();
        try {
            return Integer.parseInt(line);
        }
        catch (NumberFormatException e) {
            throw new ReadIntegerException();
        }
    }

    public static List<Integer> readLineAsIntegerList(String sep) {
        String line = Console.readLine();
        List<String> splited = Arrays.stream(line.split(sep, -1)).toList();
        List<Integer> ret = new ArrayList<>();
        try {
            for (var sp : splited) {
                ret.add(Integer.parseInt(sp));
            }
        } catch (NumberFormatException e) {
            throw new ReadIntegerException();
        }
        return ret;
    }
}