public class OffByOne implements CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(Character.toLowerCase(x) - Character.toLowerCase(y)) == 1) {
            return true;
        }
        return false;
    }
}
