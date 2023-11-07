package lotto.util.generator;

@FunctionalInterface
public interface NumberGenerator {
    int generate(int min, int max);
}
