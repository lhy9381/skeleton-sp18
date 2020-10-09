public class OffByN implements CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    private int N;

    public OffByN(int inputN) {
        N = inputN;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(Character.toLowerCase(x) - Character.toLowerCase(y)) == N) {
            return true;
        }
        return false;
    }
}
