package yuan_code;

import java.util.Arrays;

/**
 *  3.最长连续递增序列
 */
public class Question003 {
    /**
     * 最长子序列长度
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums){
        if(nums.length<=1)
            return nums.length;
        int count = 1;
        int res = 1;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                count++;
            }else{
                count = 1;
            }
            res = count > res ? count : res;
        }
        return res;
    }

    /**
     * 最长递增子序列个数
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        //数组长度
        int[] lengths = new int[len];
        //dp数组
        int[] counts = new int[len];
        Arrays.fill(counts,1);
        for(int i = 0;i<len;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(lengths[j] >= lengths[i]){
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    }else if(lengths[j] + 1 == lengths[i]){
                        counts[i] += counts[j];
                    }
                }
            }
        }
        int longest = 0;
        int ans = 0;
        for(int length:lengths){
            longest = Math.max(longest,length);
        }
        for(int i = 0;i<len;i++){
            if(lengths[i]==longest){
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        Question003 question = new Question003();
        System.out.println(question.findNumberOfLIS(nums));
    }
}
