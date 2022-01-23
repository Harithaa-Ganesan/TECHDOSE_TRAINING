Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
  
  SOLUTION:
class Solution {
   public class Pair implements Comparable<Pair>
    {
        int num;
        int count;
       public Pair(int num,int count)
       {
            this.num=num;
            this.count=count;
       }
       public int compareTo(Pair o)
        {
        return this.count - o.count;
        }
         
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
            {
                int of=hm.get(nums[i]);
                int nf=of+1;
                hm.put(nums[i],nf);
            }
            else
            {
                hm.put(nums[i],1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int key:hm.keySet())
        {
            Pair p=new Pair(key,hm.get(key));
            if(pq.size()<k)
            {
                pq.add(p);
            }
            else
            {
                Pair curr=pq.peek();
                if(p.count>curr.count)
                {
                    pq.remove(curr);
                    pq.add(p);
                
                }
            }
        }
       int[] res=new int[k];
       for(int i=0;i<k;i++)
       {
           res[i]=pq.remove().num;
       }
        return res;
    }
}
