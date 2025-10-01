package racingcar.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RealRandomGenerator implements RandomGenerator {
    @Override
    public int nextInt() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
