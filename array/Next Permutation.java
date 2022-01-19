Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]

SOLUTION:

import java.util.Scanner;
public class Main{
      static int[] swap(int a,int b,int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
        return nums;
    }
     static int[] sort(int a,int b,int[] nums){
        for(int i=a;i<b;i++){
            for(int j=i+1;j<b;j++){
                if(nums[i]>nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
         return nums;
    }
    
     static void nextPermutation(int[] nums){
        int len=nums.length;
        int lastin=-1;
        for(int i=1;i<len;i++){
            if(nums[i]>nums[i-1]){
                lastin=i;
            }
        }
        if(lastin==-1){
            for(int i=0;i<len/2;i++){
                int temp=nums[i];
                nums[i]=nums[len-1-i];
                nums[len-1-i]=temp;
            }
        }
        else{
            int index=lastin;
            for(int i=lastin;i<len;i++){
                if(nums[i]<nums[index] && nums[i]>nums[lastin-1]){
                    index=i;
                }
            }
           swap(lastin-1,index,nums);
           sort(lastin,len,nums);
        }
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
     }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
      
        for(int index = 0;index<n;index++){
            arr[index]=scanner.nextInt();
        }
        if(arr.length == 1){
          for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        }
        else{
           nextPermutation(arr);
        }
    }
}
