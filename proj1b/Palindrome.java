public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    // This is an iterative implementation.
    /** public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        for (int i = 0; i < word.length() / 2; i += 1) {
            if (wordDeque.removeFirst().equals(wordDeque.removeLast())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    */

    // This is a recursion implementation.
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque);
    }

    // This is the recursion implementation helper method.
    public boolean isPalindrome(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        if (!wordDeque.removeFirst().equals(wordDeque.removeLast())) {
            return false;
        }
        return isPalindrome(wordDeque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque, cc);
    }

    // This is the recursion implementation helper method.
    public boolean isPalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        char x = wordDeque.removeFirst();
        char y = wordDeque.removeLast();
        if (!cc.equalChars(x, y)) {
            return false;
        }
        return isPalindrome(wordDeque, cc);
    }
}
