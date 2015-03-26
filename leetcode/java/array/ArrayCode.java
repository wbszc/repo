import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayCode{

public static void main(String[]args){
       System.out.println("hello world");
       int[] test = {0,1,1,2,2};
       int[]test2 = {1,2,3,4,5,0,-1};
       System.out.println(removeDuplicate(test));
       System.out.println(removeDuplicate2(test));
       System.out.println(searchInRotatedSortedArray(test2,2));
    System.out.println(searchInRotatedSortedArray2(test,1));
    
    int[] test3 = {100, 4, 200, 1, 3, 2};
    System.out.println(findLongestConsecutiveSequence(test3));

}
    /**
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
     */
    public static int removeDuplicate(int[] arr){
	if(arr == null || arr.length ==0 ) return 0;
	if(arr.length ==1) return 1;
	int mark = 0;
	for(int i = 0; i < arr.length; i ++){
	    if(i>0 && arr[i]==arr[i-1]){
		//move one
	    }else{
		arr[mark] =arr[i];
		mark++;
	    }
	}
	return mark;
    }


/**                                                                                                                                                                              
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.                                                              
Do not allocate extra space for another array, you must do this in place with constant memory.                                                                                       
aFor example,
Given input array A = [1,1,2],                                                                                                                                          
Your function should return length = 2, and A is now [1,2].                                                                                                                          
What if duplicates are allowed at most twice?                                                                                                                                        
*/
public static int removeDuplicate2(int[] arr){
    if(arr == null || arr.length ==0 ) return 0;
    if(arr.length ==1) return 1;
    int mark = 0;
    int count = 0;
    for(int i = 0; i < arr.length; i ++){
	if(i>0 && arr[i]==arr[i-1]){
	    if(count ==0){
		arr[mark] = arr[i];
		mark++;
		count++;
	    }else if(count==1){
		//move on                                                                                                                                                        
	    }
	}else{
	    arr[mark] =arr[i];
	    mark++;
	    count =0;
	}
    }
    return mark;
}

    /**
Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.
     */
    public static int searchInRotatedSortedArray(int[] arr, int tar){
	//find the mid, check
	if(arr == null || arr.length ==0) return -1;
	if(arr.length ==1 && tar!= arr[0]) return -1;
	int left = 0;
	int right = arr.length-1;
	while(left <= right){
	    int mid = left + (right-left)/2;
	    if(arr[mid] == tar){
		return mid;
	    }else{
		if(arr[left] <= arr[mid]){
		    //left is sorted
		    if(arr[left] <= tar && tar<= arr[mid]){
			right = mid-1;
		    }else{
			left = mid+1;
		    }
		}else{
		    //right is sorted
		    if(arr[mid] <= tar && tar<= arr[right]){
			left = mid +1;
		    }else{
			right = mid-1;
		    }
		}
	    }
	    
	}
	return -1;
 }
    
    /**
     Follow up : You may assume duplicate exists in the array.
     */
    public static int searchInRotatedSortedArray2(int[] arr, int tar){
        //find the mid, check
        if(arr == null || arr.length ==0) return -1;
        if(arr.length ==1 && tar!= arr[0]) return -1;
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == tar){
                return mid;
            }else{
                if(arr[left] < arr[mid]){
                    //left is sorted
                    if(arr[left] <= tar && tar<= arr[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else if(arr[right] > arr[mid]){
                    //right is sorted
                    if(arr[mid] <= tar && tar<= arr[right]){
                        left = mid +1;
                    }else{
                        right = mid-1;
                    }
                }else{
                    left++;
                }
            }
            
        }
        return -1;
    }

    /**
     There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log(m + n)).
     */
    public static double medianOfTwoSortedArray(int[] arr1, int[] arr2){
        return 0.0;
    }
    
    /**
     Given an unsorted array of integers, find the length of the longest consecutive elements sequence.For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. Your algorithm should run in O(n) complexity.
     */
    public static int findLongestConsecutiveSequence(int[] arr){
        if(arr ==null || arr.length ==0) return 0;
        if(arr.length ==1) return 1;
        //first, save all element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i ++){
            map.put(arr[i], 1);
        }
        
        for(int i : map.keySet()){
            if(map.get(i) != -1){
                //eligible
                int local = i;
                int count = map.get(i);
                while(map.keySet().contains(local+1) && map.get(local+1)!= -1){
                    count += map.get(local+1);
                    map.put(local+1, -1);
                    local++;
                }
                map.put(i, count);
            }
        }
        int max = 1;
        for(int i : map.keySet()){
            if(map.get(i) > max){
                max = map.get(i);
            }
        }
        return max;
    }
    
    /**
     Given an array of integers, find two numbers such that they add up to a specific target number. The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based. You may assume that each input would have exactly one solution. Input: numbers={2, 7, 11, 15}, target=9.Output: index1=1, index2=2
     */
    public static int[] findTwoSum(int[] arr, int tar){
        if(arr == null || arr.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res =new int[2];
        for(int i = 0; i < arr.length; i ++){
            if(!map.containsKey(arr[i])){
                map.put(tar - arr[i], i+1);
            }else{
                //found it
                res[0] = map.get(arr[i]);
                res[1] = i+1;
                break;
            }
        }
        return res;
    }

    /**
     Given an array S of n integers, are there elements a,b,c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. Note:• Elements in a triplet (a, b, c) must be in non-descending order. (ie, a ≤ b ≤ c) • The solution set must not contain duplicate triplets.
     For example, given array S = {-1 0 1 2 -1 -4}. A solution set is: (-1, 0, 1) (-1, -1, 2)
     */
    public static ArrayList<ArrayList<Integer>> findThreeSum(ArrayList<Integer> list){
        if(list == null || list.size() <3) return null;
        int tar = 0;
        Collections.sort(list);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i  < list.size(); i ++){
            int j = i+1;
            int k = list.size()-1;
            while(j < k){
                if(list.get(i) + list.get(j) + list.get(k) ==0){
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(list.get(i));
                    l.add(list.get(j));
                    l.add(list.get(k));
                }else if(list.get(i) + list.get(j) + list.get(k) <0){
                    //increment j
                    j++;
                }else{
                    k--;
                }
                continue;
            }
        }
        return res;
    }
}