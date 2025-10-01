package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("name must be 1..5 characters");
        }
        this.name = name;
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveIf(int random) {
        if (random >= MOVE_THRESHOLD) {
            position++;
        }
    }
}
