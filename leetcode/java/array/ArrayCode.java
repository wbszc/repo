public class ArrayCode{

public static void main(String[]args){
       System.out.println("hello world");
       int[] test = {0,1,1,2,2};
       int[]test2 = {1,2,3,4,5,0,-1};
       System.out.println(removeDuplicate(test));
       System.out.println(removeDuplicate2(test));
       System.out.println(searchInRotatedSortedArray(test2,2));
    System.out.println(searchInRotatedSortedArray2(test,1));

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


}