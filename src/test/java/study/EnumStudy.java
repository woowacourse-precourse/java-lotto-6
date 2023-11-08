package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EnumStudy {

    @Test
    void Enum_사용() {
        assertThat(Fruit.BANANA.getName()).isEqualTo("banana");
    }

    @Test
    void Enum_values() {
        assertThat(Fruit.values().length).isEqualTo(3);
    }

    @Test
    void Enum_getByNumber() {
        Fruit fruit = Fruit.getFruitByNumber(2);
        assertThat(fruit).isEqualTo(Fruit.APPLE);
    }
    @Test
    void Enum_valueOf() {
        assertThat(Fruit.valueOf("BANANA")).isEqualTo(Fruit.BANANA);
    }

    @Test
    void Enum_ordinal() {
        assertThat(Fruit.APPLE.ordinal()).isEqualTo(1);
    }

    @Test
    void Enum_singleton() {
        Fruit.APPLE.addCount();
        Fruit fruit = Fruit.valueOf("APPLE");
        assertThat(fruit.getCount()).isEqualTo(1);
    }

    enum Fruit {
        BANANA(1, "banana"),
        APPLE(2, "apple"),
        NONE(0, "nothing");

        int fruitNumber;
        String fruitName;
        int fruitCount;

        private Fruit(int fruitNumber, String fruitName) {
            this.fruitCount = 0;
            this.fruitNumber = fruitNumber;
            this.fruitName = fruitName;
        }

        public static Fruit getFruitByNumber(int number) {
            for (Fruit fruit : Fruit.values()){
                if(fruit.fruitNumber == number) return fruit;
            }
            return NONE;
        }

        public void addCount() {
            this.fruitCount++;
        }

        public String getName() {
            return this.fruitName;
        }

        public int getCount() {
            return this.fruitCount;
        }
    }
}
