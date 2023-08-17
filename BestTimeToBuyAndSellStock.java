//striver sde sheet

/*      121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

import java.util.*;

class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int buyPrice=prices[0],profit=0;        //firstly buyprice is the initial element of the array
        for( int i=0 ; i<prices.length ; i++ )
        {
            //if buyprice is greter than the present price 
            if( buyPrice>=prices[i] )
            {
                //then present price set to buy price
                buyPrice=prices[i];
            }
            else
            {
                //if not then find the maximum profit
                profit=Math.max(profit,prices[i]-buyPrice);
            }
        }
        return profit;
    }
}


//driver code
public class BestTimeToBuyAndSellStock
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int t=Sc.nextInt();
        while( t-->0 )
        {
            int n=Sc.nextInt();
            int prices[]=new int[n];
            for( int i=0 ; i<n ; i++ )
            {
                prices[i]=Sc.nextInt();
            }
            Solution sl=new Solution();
            System.out.print(sl.maxProfit( prices));
        }
    }
}    