/**
 * You have a total of n coins that you want to form
 *  in a staircase shape, where every k-th row must have 
 * exactly k coins.Given n, find the total number of full 
 * staircase rows that can be formed n is a non-negative integer
 *  and fits within the range of a 32-bit signed integer.
 */

class Solution {
    public int arrangeCoins(int n) {
        /** 
        //Solution 1 Time Complexity - O(n)
        int fullStairCaseRows=0;
        int currentStairCaseRow=0;
        while(n>0)
        {
            currentStairCaseRow++;
            int CoinsReqForFullRow =((currentStairCaseRow*(currentStairCaseRow+1))/2);
            if(n>CoinsReqForFullRow)
            {
                fullStairCaseRows++;
            }
            else
            break;
        }
        return fullStairCaseRows;
        */

        //Solution 2 - Time Complexity - O(logn)
        //Since We need to find k such that k(k+1)/2 <= n
        //And Coins are in incremental Order We can use Binary Search
        //We need long since for mid*mid+1 for int > 2^17 => 2^34 out of bounds for int
        long low = 0;
        long high = n;
        long mid;
        while(low<=high)
        {
            mid = low+(high-low)/2;
            int coins = (mid*(mid+1)/2);
            if(coins==n){
                return (int)mid;
            }
            if(coins > n){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return (int)high;
    }
}