
/*
 * @Author cgc
 * @Description //TODO 
 * @Date 22:17 2019/4/2/002
 * @Param 
 * @return 
 **/
public class TwoNumSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     【示例:】
         给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     * //TODO 【Accept】
     */

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i+1; j < nums.length; j++) {
                    if(nums[i]+nums[j] == target ){
                        return new int[]{i,j};
                    }
            }
        }
        return null;

    }
    public static void main(String[] args) {
        System.out.println(new TwoNumSum().twoSum(new int[]{2,3,4},5)[0]);
    }

}