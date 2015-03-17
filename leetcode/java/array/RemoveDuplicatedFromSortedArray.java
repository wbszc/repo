public class RemoveDuplicatedFromSortedArray{

public static void main(String[]args){
       System.out.println("hello world");
       int[] test = {0,1,1,2,2};
       System.out.println(removeDuplicate(test));
}
    /**
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example, Given input array A = [1,1,2],
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
}