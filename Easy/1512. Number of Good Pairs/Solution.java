class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] indexer = new int[100];
        int count = 0;
        for(int i = 0; i < nums.length; i++) 
            count += indexer[nums[i]-1]++;
        return count;
    }
}