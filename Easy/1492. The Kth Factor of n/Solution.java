class Solution {
    public int kthFactor(int n, int k) {
        int i = 0, num = 0;
        while(i < k){
            if (n%++num == 0) i++;
            if (num > n) return -1;
        } 
        return num;
    }
}