package lotto.domain.number;

import java.util.Objects;

public abstract class Number implements Comparable<Number>{

    protected int value;

    public int getValue(){
        return this.value;
    }

    @Override
    public int compareTo(Number other){
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
