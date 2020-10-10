public class OffByN implements CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (this.N < 0) {
            return false;
        } else if (Math.abs(x - y) == this.N) {
            return true;
        }
        return false;
    }
}
