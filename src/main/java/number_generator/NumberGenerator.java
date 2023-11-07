package number_generator;

import java.util.List;

public interface NumberGenerator {
    public List<Integer> generateNumberSet(int min, int max, int size);
}
