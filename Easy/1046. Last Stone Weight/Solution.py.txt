class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        n = len(stones)  # if n = 1
        s = 0
        f = 0
        sMax = -n+1    # sMax = 0 if n = 1
        fMax = 0
        
        # Loop until second max doesn't get updated
        while sMax != 0:
            
            s = 0
            f = n-1
            sMax = 0
            fMax = 0
            
            for i in range(n):    
                # Update either first or second max if new max is found.
                # If a new first max is found, also update second max to old first max.
                if fMax < stones[i]: 
                    
                    # Second max = old first max
                    s = f
                    sMax = fMax
                    
                    # First max = new first max
                    f = i
                    fMax = stones[i]
                    
                elif sMax < stones[i]:
                    s = i;
                    sMax = stones[i];
                    
            # Stones clashing - Update stone weights
            stones[f] = fMax - sMax if sMax < fMax else 0    # First max is the difference 
            stones[s] = stones[s] if s is f else 0           # Second max is 0, if positions are different
        
        return stones[f]