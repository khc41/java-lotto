package lotto;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int VALUE_MIN = 1;
    private static final int VALUE_MAX = 45;

    private static final Map<Integer, LottoNumber> CACHE;

    static {
        CACHE = new HashMap<>();
        for (int i = VALUE_MIN; i <= VALUE_MAX; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value) {
        if (value < VALUE_MIN || value > VALUE_MAX) {
            throw new IllegalArgumentException("잘못된 로또 숫자입니다.");
        }
        return CACHE.get(value);
    }

    public int getValue() {
        return value;
    }

    public static Collection<LottoNumber> selectableNumbers() {
        return CACHE.values();
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
