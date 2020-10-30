class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int n = stones.length;  // if n = 1
        int s = 0;
        int f = 0;
        int sMax = -n+1;    // sMax = 0 if n = 1
        int fMax = 0;
        
        // Loop until second max doesn't get updated
        while (sMax != 0) {
            s = 0;
            f = n-1;
            sMax = 0;
            fMax = 0;
            for (int i = 0; i < n; i++) {
                
                // Update either first or second max if new max is found.
                // If a new first max is found, also update second max to old first max.
                if (fMax < stones[i]) { 
                    
                    // Second max = old first max
                    s = f;
                    sMax = fMax;
                    
                    // First max = new first max
                    f = i;
                    fMax = stones[i];
                    
                } else if (sMax < stones[i]) {
                    s = i;
                    sMax = stones[i];
                }
            }
            // Stones clashing - Update stone weights
            stones[f] = (sMax < fMax) ? fMax - sMax : 0;    // First max is the difference 
            stones[s] = (s == f) ? stones[s] : 0;           // Second max is 0, if positions are different
        }
        
        return stones[f];
    }
}