class Solution {
    
    //  Case 1
    //  Increment by 1 for single letter palindromes
    private static int firstCaseA() {
        return 1;
    }

    //  Case 2
    //  Compares the value of two nodes prev and next. If they are equal, increment count and call the prev and next of
    //  same.
    //        ? <- 0 -> ?
    //      ? <- 0 0 0 -> ?
    //  If case 3 passes, it will also call case 2 on it's outer two nodes.
    //
    //        ? <- 0 0 -> ?
    //      ? <- 0 0 0 0 -> ?
    private static int secondCaseA(int i, int j, char[] s) {
        if (i < 0 || j >= s.length) return 0;
        if (s[i] == s[j]) return 1 + secondCaseA(i-1, j+1, s);
        return 0;
    }

    //  Case 3
    //  Checks if the next node is not null and has the same value as curr:
    //      0 -> ?
    //  If so, increment count and check second case:
    //      ? <- 0 0 -> ?
    private static int thirdCaseA(int i, char[] s) {
        return (i+1 < s.length && s[i] == s[i+1]) ? 1 + secondCaseA(i-1, i+2, s) : 0;
    }

    private static int countPalindromeA(char[] s) {

        int count = 0;
        int i = 0;
        int n = s.length;
        while(i < n) {
            count += firstCaseA();              // Single character palindromes: s[i]
            count += secondCaseA(i-1, i+1, s);  // Outer character palindromes: ? <- s[i] -> ?
            count += thirdCaseA(i, s);          // Next character palindromes: s[i] -> ?
            i++;
        }

        return count;
    }
    
    public int countSubstrings(String str) {
        return countPalindromeA(str.toCharArray());
    }
}