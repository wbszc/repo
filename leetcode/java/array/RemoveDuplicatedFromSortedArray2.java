public class RemoveDuplicatedFromSortedArray2{

public static void main(String[]args){
       System.out.println("hello world");
       int[] test = {0,1,1,2,2};
       System.out.println(removeDuplicate2(test));
}
    /**
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example, Given input array A = [1,1,2],
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
}