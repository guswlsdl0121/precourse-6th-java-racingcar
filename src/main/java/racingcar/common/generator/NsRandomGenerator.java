package racingcar.common.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class NsRandomGenerator implements RandomGenerator {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private NsRandomGenerator() {
    }

    public static RandomGenerator of() {
        return new NsRandomGenerator();
    }

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
