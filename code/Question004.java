package yuan_code;

import java.util.Arrays;

/**
 *  4.最长不连续序列
 */
public class Question004 {

    public int findLongestNon(int[] nums){
        int len = nums.length;
        if(len <= 1) return len;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i = 1;i<dp.length;i++){
            for(int j = i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int res = 0;
        for(int num:dp){
            res = Math.max(res,num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,8,7,2,9,10};
        Question004 question004 = new Question004();
        System.out.println(question004.findLongestNon(nums));
    }
}
