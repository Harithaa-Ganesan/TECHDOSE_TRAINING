There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.

It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].

Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.

 

Example 1:

Input: encoded = [3,1]
Output: [1,2,3]
Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
Example 2:

Input: encoded = [6,5,4,6]
Output: [2,4,1,5,3]
 

Constraints:

3 <= n < 105
n is odd.
encoded.length == n - 1


PROGRAM:

class Solution {
   public int[] decode(int[] encoded) {
        int last= 1, size= encoded.length;
        for(int i=2; i<=size+1; i++) last^= i;
        for(int i=0; i<size; i= i+2) last^= encoded[i];
        int[] res= new int[size+1];
        for(int i= size; i>0; i--){
            res[i]= last;
            last^= encoded[i-1];
        }
        res[0]= last;
        return res;
    }
}
