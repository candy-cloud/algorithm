package com.candy.algorithm.v0to10.v1两数之和;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 方法一：暴力枚举
     * 思路及算法
     * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     *
     * 复杂度分析
     * 时间复杂度：O(N^2)O(N2)，其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)O(1)。
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            int num = target-nums[i];
            for(int y=i+1;y<nums.length;y++){
                if(num==nums[y]){
                    return new int[]{i,y};
                }
            }
        }
        return null;
    }

    /**
     *方法二：哈希表
     * 思路及算法
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     *
     * 复杂度分析
     * 时间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。对于每一个元素 x，我们可以 O(1)O(1) 地寻找 target - x。
     * 空间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] a = twoSum(nums,13);
        System.out.println(a.length);
    }
}
