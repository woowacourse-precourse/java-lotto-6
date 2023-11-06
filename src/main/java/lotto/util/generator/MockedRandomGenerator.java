package lotto.util.generator;

import java.util.List;
import java.util.function.Supplier;

public class MockedRandomGenerator implements RandomStrategy {
    private final Supplier<List<Integer>> supplier;

    public MockedRandomGenerator(Supplier<List<Integer>> supplier) {
        this.supplier = supplier;
    }

    @Override
    public List<Integer> generate() {
        return supplier.get();
    }
//
//    private static void addAlternativeNumber(List<Integer> lotto, int randomNumber) {
//        if (hasDuplicatedNumber(lotto, randomNumber)) {
//            return;
//        }
//        lotto.add(randomNumber);
//    }
//
//    private static boolean hasStandardSize(List<Integer> lotto, int standardSize) {
//        return lotto.size() == standardSize;
//    }
//
//    private static boolean hasDuplicatedNumber(List<Integer> lotto, int generatedNumber) {
//        if (lotto.contains(generatedNumber)) {
//            return true;
//        }
//        return false;
//    }
}
