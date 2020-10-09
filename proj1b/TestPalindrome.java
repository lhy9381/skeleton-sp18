import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean actual1 = palindrome.isPalindrome("a");
        assertTrue("isPalindrome one char case failed.", actual1);
        boolean actual2 = palindrome.isPalindrome("");
        assertTrue("isPalindrome empty case failed.", actual2);
        assertFalse(palindrome.isPalindrome("cat"));
        boolean actual = palindrome.isPalindrome("racecar");
        assertTrue("isPalindrome general true case failed.", actual);
        assertTrue(palindrome.isPalindrome("abba"));
        assertFalse(palindrome.isPalindrome("abbaaaa"));
    }

    @Test
    public void testOboIsPalindrome() {
        // Test off by one isPalindrome method
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertFalse(palindrome.isPalindrome("abbaaaa", offByOne));
        assertFalse(palindrome.isPalindrome("abba", offByOne));
        assertTrue("isPalindrome one char case failed.", palindrome.isPalindrome("a", offByOne));
        assertTrue("isPalindrome empty case failed.", palindrome.isPalindrome("", offByOne));
    }
}
