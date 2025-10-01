package racingcar.random;

public class StubRandomGenerator implements RandomGenerator {
    private final int[] seq;
    private int idx = 0;

    public StubRandomGenerator(int[] seq) {
        this.seq = seq;
    }

    @Override
    public int nextInt() {
        return seq[idx++ % seq.length];
    }
}
