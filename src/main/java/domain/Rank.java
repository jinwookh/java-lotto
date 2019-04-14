package domain;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 5_0000),
    THIRD(5, 150_0000),
    SECOND(5, 3_0000_0000),
    FIRST(6, 20_0000_0000);

    private static final int THIRD_OR_SECOND_RANK = 5;
    private static final int MIN_IDENTICAL_COUNT = 3;

    private int number;
    private int prize;
    private boolean hasBonus;

    private Rank(int number, int prize) {
        this.number = number;
        this.prize = prize;
    }

    private boolean matchValues(int number) {
        if (number == this.number) {
            return true;
        }
        return false;
    }

    public static Rank valueOf(int number, boolean hasBonus) {
        if (number == THIRD_OR_SECOND_RANK && hasBonus) {
            return SECOND;
        }

        for (Rank rank : values()
             ) {
            if (rank.matchValues(number) && rank != SECOND) {
                return rank;
            }
        }

        if (number < MIN_IDENTICAL_COUNT) {
            return MISS;
        }

        throw new IllegalArgumentException();
    }

    public int prizeIs() {
        return prize;
    }

    public int countOfIdenticalNumbersIs() {
        return number;
    }

}
